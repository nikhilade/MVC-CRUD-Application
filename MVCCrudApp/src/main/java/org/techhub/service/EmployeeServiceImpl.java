package org.techhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.model.Employee;
import org.techhub.repository.EmployeeRepository;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public boolean isAddNewEmployee(Employee employee) {
		return empRepo.isAddNewEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return empRepo.getAllEmployee();
	}

	@Override
	public boolean isDeleteEmployee(int empid) {
		return empRepo.isDeleteEmployee(empid);
	}

	@Override
	public boolean isUpdateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.isUpdateEmployee(employee);
	}

}
