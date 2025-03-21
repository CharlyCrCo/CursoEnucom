package com.mx.Bicicleta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Bicicleta.Dominio.Bicicleta;
import com.mx.Bicicleta.Servicio.BicicletaServiceImpl;

@RestController
@RequestMapping(path = "/api/v1/Bici")
public class BicicletaWS {
	
	// inyeccion de dependencias del @Service
	@Autowired
	private BicicletaServiceImpl service;
	
	// -----------------CREACION DE EndPoints
	
	// Enpoint: "Listar"
	// URL:		http://localhost:8080/api/v1/Bici/listar
	@GetMapping(value = "listar")
	public List<Bicicleta> listar(){
		return service.listar();
	}
	
	// EndPoint: "Buscar"
	// URL:		http://localhost:8080/api/v1/Bici/buscar/{1}
	@PostMapping(value = "buscar/{idBici}")
	public Bicicleta buscar(@PathVariable int idBici) {
		return service.buscar(idBici);
	}
	
	// Enpoint: "Guardar"
	// URL:		http://localhost:8080/api/v1/Bici/guardar
	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Bicicleta bici) {
		/*	@RequestBody: Sirve para deserializar el Documento JSON y convertirlo en un Objeto Java.
		 *  @ResponseBody: Sirve para serializar el Objeto Java y convertirlo en un Documento JSON.
		 * */
		service.guardar(bici);
	}
	
	// Enpoint: "Editar"
	// URL:		http://localhost:8080/api/v1/Bici/editar
	@PutMapping(value = "editar")
	public void editar(@RequestBody Bicicleta bici) {
		service.editar(bici);
	}
	
	// Enpoint: "Eliminar"
	// URL:		http://localhost:8080/api/v1/Bici/eliminar/{1}
	@DeleteMapping(value = "eliminar/{idBici}")
	public void eliminar(@PathVariable int idBici) {
		service.eliminar(idBici);
	}
	
	
	
}
