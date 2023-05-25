package com.FoodTec.demo.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DepartmentService
{
	@Autowired
	private IDepartmentRepository repo;

	public void save( @RequestBody Department department )
	{
		repo.save(department);
	}

	public List<Department> findAll()
	{
		return repo.findAll();
	}

	public Department findById( @PathVariable Long id )
	{
		return repo.findById(id).get();
	}

	public void deleteById( @PathVariable Long id )
	{
		repo.deleteById(id);
	}
}
