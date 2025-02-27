package com.tcs.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.tcs.mvc.controller.entity.EmployeeEntity;
import com.tcs.mvc.empmodel.EmployeeModel;
import com.tcs.mvc.service.EmployeeService;


import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/addEmployee")
	public String getEmployee() {
		return "add-Employee";
	}
	@PostMapping("/saveEmployee")
	public String setEmployee(EmployeeModel employeeModel) {
		
		employeeService.setEmployee(employeeModel);
		return "save-Employee";
	}
	@GetMapping("/getemployeedetails")
	public String getEmployeeDetails(Model model) 
	{
		List<EmployeeEntity> employees=employeeService.getEmployeeDetails();
		model.addAttribute("employees", employees);
		return "employee-list";
	}
	
	@GetMapping("/getsearchform")
	public String getSearchForm()
	{
		
		return "search-employee";
	}
	@PostMapping("/searchbyid")
	public String postMethodName(@RequestParam Long id, Model model) {
		
		EmployeeEntity employee=employeeService.searchByID(id);
		model.addAttribute("employee",employee);
		return "search-employee";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id) {
		
		employeeService.deleteEmployeeById(id);
		
		return "redirect:/getemployeedetails";
	}
	
	

}
