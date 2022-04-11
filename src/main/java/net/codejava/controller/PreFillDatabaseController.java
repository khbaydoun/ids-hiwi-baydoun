package net.codejava.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Employee;
import net.codejava.service.EmployeeService;

@Controller
@ResponseBody
public class PreFillDatabaseController {
	@Resource
	EmployeeService employeeService;
	@RequestMapping(value ="/")
	public ModelAndView homepage(ModelAndView model, HttpServletResponse response) {
		
		model.setViewName("Fill");
		response.setStatus(HttpServletResponse.SC_OK);
		return model;
	}
	@RequestMapping(value ="/preFill", method = RequestMethod.POST, produces = "application/json" )
	public ModelAndView databaseFill(ModelAndView model,HttpServletResponse response) {
		
		employeeService.getFillDatabase();
		model.setViewName("Fill");
		response.setStatus(HttpServletResponse.SC_OK);
		return model;
		//return new ModelAndView("redirect:/");
	}

}
