package org.techhub.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.techhub.model.Employee;

@Repository("empRepo")
public class EmployeeRepositoryImpl implements EmployeeRepository{
	@Autowired
	JdbcTemplate template;

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
	
	
}
