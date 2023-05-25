package com.FoodTec.demo.department;

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
@RequestMapping(path = "/department")
public class DepartmentController
{
	@Autowired
	private IDepartmentRepository repo;

	@PostMapping("/saveDepartment")
	public String saveDepartment( @RequestBody Department dept )
	{
		repo.save(dept);
		return "Department Saved";
	}

	@GetMapping("/getAllDepartments")
	public List<Department> getAll()
	{
		return repo.findAll();
	}

	@GetMapping("/getById/{id}")
	public Department getById( @PathVariable Long id )
	{
		return repo.findById(id).get();
	}

	@DeleteMapping("/delete/{id}")
	public String delete( @PathVariable Long id )
	{
		repo.deleteById(id);
		return "Department Deleted";
	}

}
