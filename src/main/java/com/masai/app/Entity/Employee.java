package com.masai.app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee 
{
	@Id
	@GeneratedValue
	private int id;
	
	private String userName;
	private String password;
	private String address;
	private String role;
}
