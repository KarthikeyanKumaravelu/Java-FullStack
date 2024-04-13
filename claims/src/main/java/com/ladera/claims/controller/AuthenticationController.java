package com.ladera.claims.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.claims.s1.entities.AuthenticationResponse;
import com.ladera.claims.s1.entities.User;
import com.ladera.claims.s1.service.AuthenticationService;
@RestController
@RequestMapping("/auth")
@CrossOrigin(originPatterns = "*",methods = {RequestMethod.GET,RequestMethod.POST},allowedHeaders = "Content-type")
public class AuthenticationController {

	private final AuthenticationService authService;
	
	
	
	
	public AuthenticationController(AuthenticationService authService) {
		super();
		this.authService = authService;
	}


	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody User request){
		return  ResponseEntity.ok(authService.register(request));
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody User request){
		return  ResponseEntity.ok(authService.authenticate(request));
	}

	@GetMapping("/admin")
	public String welcomeUser() {
		return "Hello Admin";
	}
	

}
