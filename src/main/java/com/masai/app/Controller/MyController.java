package com.masai.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.Entity.Employee;
import com.masai.app.Repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class MyController 
{
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	PasswordEncoder passEncoder;
	@GetMapping("/user")
	public ResponseEntity<String> commonResource()
	{
		String msg="Welcome user, This is not a secured resource";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	@GetMapping("/secure/user")
	public ResponseEntity<String> securedResource()
	{
		String msg="Welcome user, This is a secured resource";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	@GetMapping("/admin")
	public ResponseEntity<String> admin()
	{
		return new ResponseEntity<String>("Welcome to masai app for admin",HttpStatus.ACCEPTED);
	}
	@PostMapping("/user")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		employee.setPassword(passEncoder.encode(employee.getPassword()));
		return new ResponseEntity<>(empRepo.save(employee),HttpStatus.ACCEPTED);
	}
}
