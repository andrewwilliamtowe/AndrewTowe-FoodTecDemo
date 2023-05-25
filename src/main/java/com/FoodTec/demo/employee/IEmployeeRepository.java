package com.FoodTec.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long>
{

}
