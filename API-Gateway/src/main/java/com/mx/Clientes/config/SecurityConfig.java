package com.mx.Clientes.config;
/*
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
*/
//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

	// Metodo con usuario y Contraseña configurados en memoria.
	/*@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		manager.createUser(
					User.withDefaultPasswordEncoder()
						.username("user")
						.password("1234")
						.roles("USER")
						.build()
				);
		return manager;
	}*/ 
	
	// Metodo para agregar seguridad Basica para todas las peticiones "BasicAuth"
	/*@Bean
	HttpBasicConfigurer<HttpSecurity> httpBasicConfigurer(HttpSecurity http) throws Exception{
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.and()
				.httpBasic();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(HttpMethod.POST,"/Tienda/Productos/**").authenticated()
						.requestMatchers("/Tienda/Clientes/**").authenticated()
					.anyRequest().authenticated())
			.formLogin().and()
			.httpBasic();
		return http.build();
	}
	
	
	
	// Metodo para utilizar el valor de USUARIO y CONTRASEÑA desde Propiedades.	
	/*@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest().authenticated()
			.and()
			.httpBasic();
		return http.build();
	}*/

	
	
}

















