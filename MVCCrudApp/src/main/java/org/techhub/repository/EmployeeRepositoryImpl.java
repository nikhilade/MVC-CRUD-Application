package org.techhub.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.techhub.model.Employee;

@Repository("empRepo")
public class EmployeeRepositoryImpl implements EmployeeRepository{
	@Autowired
	JdbcTemplate template;

	List<Employee> list;
	
	@Override
	public boolean isAddNewEmployee(Employee employee) {
		
		int value=template.update("insert into employee values('0',?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, employee.getName());
				ps.setString(2, employee.getEmail());
				ps.setString(3, employee.getContact());
			}
		});
		return value>0?true:false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		list = template.query("select * from employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setEmail(rs.getString(3));
				emp.setContact(rs.getString(4));
				return emp;
			}
		});
		return list;
	}
	
	
}
