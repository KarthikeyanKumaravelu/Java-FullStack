package com.ladera.claims.s1.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ladera.claims.s1.entities.AuthenticationResponse;
import com.ladera.claims.s1.entities.User;
import com.ladera.claims.s1.repositories.UserDAO;

@Service
public class AuthenticationService {

	private final UserDAO repository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final JwtService jwtService;
	
	private final AuthenticationManager authManager;

	
	
	public AuthenticationService(UserDAO repository, PasswordEncoder passwordEncoder, JwtService jwtService,
			AuthenticationManager authManager) {
		super();
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authManager = authManager;
	}



	public AuthenticationResponse register (User request) {
		User user = new User ();
		
		user.setUserName(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());
		
		repository.save(user);
		
		String token = jwtService.generateToken(user);
		return new AuthenticationResponse(token);
	}
	
	public AuthenticationResponse authenticate (User request) {
		authManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername(), 
						request.getPassword()
				)
		);
		
		User user = repository.findByUserName(request.getUsername()).orElseThrow();
		String token = jwtService.generateToken(user);
		
		return new AuthenticationResponse(token);
	}

}
