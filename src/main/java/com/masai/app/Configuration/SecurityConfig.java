package com.masai.app.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig 
{
	@Bean
	protected SecurityFilterChain masaiSecurityConfig(HttpSecurity http) throws Exception
	{
//		http.authorizeHttpRequests( (auth)->auth
//				.requestMatchers("/api/secure/user").authenticated()
//				.requestMatchers("/api/user").permitAll())
//				.httpBasic();
//		return http.build();
		
//				.requestMatchers("/api/secure/user").hasAuthority("user")
//				.requestMatchers("/api/admin").hasAuthority("admin")
//				.requestMatchers("/api/user").permitAll())
//				.httpBasic();
		
		http.authorizeHttpRequests( (auth)->auth
				.requestMatchers("/api/user").permitAll()
				.requestMatchers("/api/admin").hasAuthority("admin")
				.requestMatchers("/api/secure/user").authenticated()
		).csrf().disable().httpBasic();
		return http.build();
	}
	
//	@Bean
//	protected InMemoryUserDetailsManager useConfig() {
//		InMemoryUserDetailsManager userDetailsService= new InMemoryUserDetailsManager();
//		
//		UserDetails admin = User.withUsername("masai").password("masai123").authorities("admin").build();
//		UserDetails user = User.withUsername("hello").password("hello123").authorities("user").build();
//		
//		userDetailsService.createUser(user);
//		userDetailsService.createUser(admin);
//		
//		return userDetailsService;
//	}
	
	@Bean
	protected PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
}
