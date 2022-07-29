package com.busyqa.coop.security;


import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig{
	
	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Autowired
	private JwtAuthenticationFilter authenticationFilter;
	
	//Defining Authorizations
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http
			
			.cors().configurationSource(new CorsConfigurationSource() {

			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration config = new CorsConfiguration();
				config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowCredentials(true);
				config.setAllowedHeaders(Collections.singletonList("*"));
				config.setExposedHeaders(Arrays.asList("Authorization"));
				config.setMaxAge(3600L);
				

				return config;
				}
				
			}).and()
			.csrf()
			.disable()
			.authorizeRequests()
			.antMatchers("/authenticate","/signup").permitAll()//permitted entrypoints
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.antMatchers(HttpHeaders.ALLOW).permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler)//exception handling entry point
			.and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//Stateless Session
		
            ;
		
		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);//Authentication Filter
	    
    
		
		return http.build();
	}


	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
		
	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerbuilder) throws Exception {
//		authenticationManagerbuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}


	

}
