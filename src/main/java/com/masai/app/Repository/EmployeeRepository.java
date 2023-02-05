package com.masai.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.app.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

	public Employee findByUserName(String username);

}
