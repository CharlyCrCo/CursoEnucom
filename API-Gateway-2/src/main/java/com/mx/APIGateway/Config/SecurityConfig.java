package com.mx.APIGateway.Config;

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

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// Metodo con Usuario y COntraseña configurados en Memoria
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
	/*HttpBasicConfigurer<HttpSecurity> httpBasicConfigurer(HttpSecurity http) throws Exception{
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.and()
				.httpBasic();
	}*/
	
	// Metodo utilizado para trabajar con los filtro de seguridad se SpringSecurity "SrcurityFilterChain"
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests( // URLs permitidos
						authorize -> authorize
							.requestMatchers("/Tienda/Clientes/**").authenticated()
							.requestMatchers("/Tienda/Productos/**").authenticated()
							.requestMatchers(HttpMethod.GET,"/Tienda").authenticated()
							.anyRequest().denyAll())
			.formLogin().and()
			.httpBasic();
		
		return http.build();
	}
	
}
















