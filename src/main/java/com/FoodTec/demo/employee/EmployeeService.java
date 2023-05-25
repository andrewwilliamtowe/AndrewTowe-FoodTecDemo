package com.FoodTec.demo.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeService
{
	@Autowired
	private IEmployeeRepository repo;

	public void save( @RequestBody Employee employee )
	{
		repo.save(employee);
	}

	public List<Employee> findAll()
	{
		return repo.findAll();
	}

	public Employee findById( @PathVariable Long id )
	{
		return repo.findById(id).get();
	}

	public void deleteById( @PathVariable Long id )
	{
		repo.deleteById(id);
	}
}
