package com.ladera.claims.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ladera.claims.filter.JwtFilter;
import com.ladera.claims.s1.service.UserDetailsImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final UserDetailsImpl userDetailsService;
	
	private final JwtFilter jwtFilter;
	
	
	
	
	public SecurityConfig(UserDetailsImpl userDetailsService, JwtFilter jwtFilter) {
		super();
		this.userDetailsService = userDetailsService;
		this.jwtFilter = jwtFilter;
	}


	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests((req)-> {
					req.requestMatchers("/auth/register","/auth/login").permitAll();
					req.requestMatchers("/auth/admin").hasAuthority("ADMIN");
					req.requestMatchers("/claims/**").hasAuthority("ADMIN");
				})
				.userDetailsService(userDetailsService)
				         .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				         .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class)
				         .build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new  BCryptPasswordEncoder ();
	}
	
	@Bean
	public AuthenticationManager getAuthenticationManager (AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

}
