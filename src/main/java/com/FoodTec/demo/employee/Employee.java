package com.FoodTec.demo.employee;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "EMPLOYEE")
public class Employee
{
	@Id
	@GeneratedValue
	private @Nonnull Long id;
	private @Nonnull String name;
	private @Nonnull Long department_id;

}
