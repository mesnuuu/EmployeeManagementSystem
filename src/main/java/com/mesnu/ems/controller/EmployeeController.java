package com.mesnu.ems.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mesnu.ems.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data

	private List<Employee> theEmployees;

	@PostConstruct
	private void loadData() {

		// create employees
		Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@luv2code.com");
		Employee emp2 = new Employee(2, "Emma", "Baumgarten", "emma@luv2code.com");
		Employee emp3 = new Employee(3, "Avani", "Gupta", "avani@luv2code.com");

		// create the list
		theEmployees = new ArrayList<>();

		// add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);

	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "list-employees";
	}
}

/*
 * import java.util.List;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import com.mesnu.ems.entity.Employee; import
 * com.mesnu.ems.service.EmployeeService;
 * 
 * @Controller
 * 
 * @RequestMapping("/employees") public class EmployeeController {
 * 
 * private EmployeeService employeeService;
 * 
 * public EmployeeController(EmployeeService theEmployeeService) {
 * employeeService = theEmployeeService; }
 * 
 * // add mapping for "/list"
 * 
 * @GetMapping("/list") public String listEmployees(Model theModel) {
 * 
 * // get employees from db List<Employee> theEmployees =
 * employeeService.findAll();
 * 
 * // add to the spring model theModel.addAttribute("employees", theEmployees);
 * 
 * return "list-employees"; } }
 */