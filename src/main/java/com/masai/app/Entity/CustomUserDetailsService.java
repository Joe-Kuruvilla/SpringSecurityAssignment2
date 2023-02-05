package com.masai.app.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.app.Repository.EmployeeRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	CustomUser user=null;
	@Autowired
	private EmployeeRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Employee emp=repo.findByUserName(username);
		if(emp!=null)
		{
			user=new CustomUser(emp);
		}
		return user;
	}

}
