package com.mx.Tienda.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	/*		@Bean
	 * 
	 * Que es @Bean: Es una anotacion que se utiliza en clases de Configuracion (@Configuration)
	 * para indicar que un metodo produce un "BEAN" que sera administrado por el Contenedor de Instancias
	 * de Spring.
	 * 
	 * Que es un "BEAN": En Spring es un objeto que forma parte del contexto de la aplicacion y es administrado
	 * por el Contenerdor de Instancias de Spring.
	 * Estos objetos pueden ser inyectados en otras partes del codigo mediante la "Inyeccion de dependencias"
	 * 
	 * En resumen: Un bean es una unica instancias que se encuentra almacenada en el "Contenedor de Instancias
	 * de Spring Framework". Esto para garantizar que solo exista una sola instancia de ese objeto.
	 * */

	// Ejemplo de un BEAN 
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
