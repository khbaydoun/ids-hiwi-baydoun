package net.codejava.dao.impl;

import java.util.List;

import net.codejava.model.Employee;

public interface EmployeeDAO {
	Employee  getEmployeeInfoByID (int id);
	List<Employee>  getEmployeeInfo ();
	void fillDatabase();
}
