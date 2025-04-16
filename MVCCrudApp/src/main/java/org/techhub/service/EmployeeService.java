package org.techhub.service;

import java.util.List;

import org.techhub.model.Employee;

public interface EmployeeService {
	public boolean isAddNewEmployee(Employee employee);
	public List<Employee> getAllEmployee();
}
