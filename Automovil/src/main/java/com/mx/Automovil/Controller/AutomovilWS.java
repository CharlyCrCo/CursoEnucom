package com.mx.Automovil.Controller;

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

import com.mx.Automovil.Entity.Automovil;
import com.mx.Automovil.Service.AutomovilServiceImpl;

@RestController
@RequestMapping("/Automovil")
public class AutomovilWS {

	@Autowired
	private AutomovilServiceImpl service;
	
	// Metodo: GET
	// http://localhost:8003/Automovil
	@GetMapping
	public List<Automovil> listar(){
		return service.listar();
	}
	
	// BUSCAR
	// http://localhost:8003/Automovil
	@PostMapping("/{idAuto}")
	public Automovil buscar(@PathVariable Long idAuto) {
		return service.buscar(idAuto);
	}
	
	// GUARDAR
	// http://localhost:8003/Automovil
	@PostMapping
	public Automovil guardar(@RequestBody Automovil auto) {
		return service.guardar(auto);
	}

	// Editar
	// http://localhost:8003/Automovil
	@PutMapping
	public Automovil editar(@RequestBody Automovil auto) {
		return service.editar(auto);
	}
	
	// ELIMINAR
	// http://localhost:8003/Automovil
	@DeleteMapping
	public Automovil eliminar(@RequestBody Automovil auto) {
		return service.eliminar(auto);
	}
	
	// http://localhost:8003/Automovil/buscarPorMarca/FORD
	@PostMapping("buscarPorMarca/{marca}")
	public List<Automovil> buscarPorMarca(@PathVariable String marca){
		return service.buscarPorMarca(marca);
	}
	
}













