package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	@PostMapping("employee")
	public String addEmployee(@RequestBody Employee employee)
	{
		service.saveData(employee);
		return "added data in db";
		
	}
	@GetMapping("employee/{id}")
	public Employee getEmployee( @PathVariable("id")   int id)
	{
		Employee s=service.getData(id);
		return s ;
	}
	@DeleteMapping("employee/{id}")
	public String deleteEmployee(int id)
	{
		service.deleteData(id);
		return "deleted data from db"+id;
	}
	

}
