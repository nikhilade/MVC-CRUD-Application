package org.techhub.repository;

import java.util.List;

import org.techhub.model.Employee;

public interface EmployeeRepository {
	public boolean isAddNewEmployee(Employee employee);
	public List<Employee> getAllEmployee();
}
