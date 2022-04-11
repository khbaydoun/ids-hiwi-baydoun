package net.codejava.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.codejava.dao.impl.EmployeeDAO;
import net.codejava.model.Employee;

@Service
public class EmployeeService {
	@Resource
	@Qualifier("employeeDAOImpl")
	private EmployeeDAO employeeDAO;
	
	public Employee getEmployeeByID( int id) {
		return employeeDAO.getEmployeeInfoByID(id);
	}
	public List <Employee> getEmployee() {
		List <Employee> employeeList = employeeDAO.getEmployeeInfo();
		for (Employee employee :employeeList) {
			if(employee.getName().equals(null)) {
				employeeList.remove(employee);
			}
		}
		return employeeList;
	}
	public void getFillDatabase() {
		employeeDAO.fillDatabase();
	}

}
