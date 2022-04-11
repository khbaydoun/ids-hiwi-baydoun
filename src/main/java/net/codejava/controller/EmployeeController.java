package net.codejava.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Employee;
import net.codejava.service.EmployeeService;

@RestController
@RequestMapping("/REST")
public class EmployeeController {
	@Resource
	private EmployeeService employeeService;
	
	@RequestMapping(value="/ListWithName", method =RequestMethod.GET)
	public ModelAndView findAllEmployeeWithName(ModelAndView model,HttpServletResponse response) {
		List<Employee> employeeList = employeeService.getEmployee();
		model.setViewName("SearchByID");
		model.addObject("employeeList",employeeList );
		response.setStatus(HttpServletResponse.SC_OK);
		return model;
		
	}
	@RequestMapping(value="/ById/{id}", method =RequestMethod.GET)
	public ModelAndView findAllEmployeeWithName(@PathVariable int id ,ModelAndView model,HttpServletResponse response) {
		Employee employee = employeeService.getEmployeeByID(id);
		model.setViewName("home");
		model.addObject("employee",employee );
		response.setStatus(HttpServletResponse.SC_OK);
		return model;
		
	}
	/*@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}*/
	
}
