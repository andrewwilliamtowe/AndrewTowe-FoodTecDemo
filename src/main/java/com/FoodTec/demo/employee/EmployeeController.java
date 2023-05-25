package com.FoodTec.demo.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController
{
	@Autowired
	private EmployeeService service;

	@PostMapping("/saveEmployee")
	public String saveEmployee( @RequestBody Employee employee )
	{
		service.save(employee);
		return "Employee Saved";
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAll()
	{
		return service.findAll();
	}

	@GetMapping("/getById/{id}")
	public Employee getById( @PathVariable Long id )
	{
		return service.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String delete( @PathVariable Long id )
	{
		service.deleteById(id);
		return "Employee Deleted";
	}
}
