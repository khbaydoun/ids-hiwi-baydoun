package net.codejava.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.codejava.service.EmployeeService;

@Controller
@ResponseBody
public class PreFillDatabaseController {
	@Resource
	EmployeeService employeeService;
	@RequestMapping(value ="preFill", method = RequestMethod.POST, produces = "application/json" )
	public void databaseFill() {
		employeeService.getFillDatabase();
	}

}
