package com.mx.EurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // Anotacion que le indica al framework que este proyecto sera un servidor de Eureka
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}

/*  ¿Que es Eureka Server ( Discovery Server)?
 * 
 * 		Es un componente de Netflix OSS ( Open Source Sofware) y es utilizado para la
 * implementacion de servicios basados en Arquitectura de microservicios.
 * Es una parte integal del sistema de Descrubimiento de servicios de Netflix, que 
 * permite a los servicios en un infraestructura de MS localizar y comunicarse entre si de manera dinamica.
 * 
 * Eureka se basa en el principio de CLIENTE - SERVIDOR, donde los clientes (microservicios)
 * se registran en el servidor de descubrimiento (Eureka Discovery Server).
 * y los servicios pueden consultar al servidor para encontrar la ubicacion y los detalles de los servicios con lo
 * que se desean comunicarse.
 */