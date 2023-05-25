package com.FoodTec.demo.general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodTec.demo.department.Department;
import com.FoodTec.demo.department.IDepartmentRepository;
import com.FoodTec.demo.employee.Employee;
import com.FoodTec.demo.employee.IEmployeeRepository;

@RestController
@RequestMapping(path = "/general")
public class GeneralController
{
	@Autowired
	private IDepartmentRepository department_repo;
	@Autowired
	private IEmployeeRepository employee_repo;
	private static Connection connection;

	@PostMapping("/seedTestData")
	public String saveEmployee()
	{
		Department software_department = new Department().builder().name("Software").build();
		Department IT_department = new Department().builder().name("IT").build();
		department_repo.save(software_department);
		department_repo.save(IT_department);
		department_repo.save(software_department);
		department_repo.save(IT_department);

		Employee andrew = new Employee().builder().name("Andrew Towe").department_id(software_department.getId()).build();
		Employee greg = new Employee(2l, "Greg Towe", IT_department.getId());
		employee_repo.save(andrew);
		employee_repo.save(greg);

		return "Test Data Seeded";

	}

	@GetMapping("/getAllData")
	public String getAllData() throws SQLException
	{
		String jdbcURL = "jdbc:h2:mem:db";

		connection = DriverManager.getConnection(jdbcURL, "user", "password");
		String sql = "SELECT employee.id, employee.name, employee.department_id, department.id, department.name from employee, department where department.id=employee.department_id";

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);
		ResultSetMetaData rsmd = resultSet.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		String to_return = "employee.id, employee.name, employee.department_id, department.id, department.name"
				+ System.lineSeparator();
		while ( resultSet.next() )
		{
			for ( int i = 1; i <= columnsNumber; i++ )
			{
				if ( i > 1 )
					to_return = to_return
							+ ",\t";
				String columnValue = resultSet.getString(i);
				to_return = to_return.concat(columnValue);
			}
			to_return = to_return
					+ System.lineSeparator();
		}
		return to_return;

	}
}
