package com.mx.Proveedores.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Proveedores.Entity.Proveedores;
import com.mx.Proveedores.Service.ProveedoresServImpl;

@RestController
@RequestMapping("/Proveedores")
@CrossOrigin
public class ProveedoresWS {

	@Autowired
	private ProveedoresServImpl service;

	@GetMapping
	public ResponseEntity<?> listar() {
		List<Proveedores> proveedores = service.listar();
		
		if (proveedores.isEmpty()) 
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedores);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Proveedores proveedor) {
		Proveedores nuevoProveedor = service.guardar(proveedor);
		if (nuevoProveedor != null) 
			return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProveedor);
		
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PostMapping("/tienda/{tiendaId}")
	public ResponseEntity<?> obtenerPorTiendaId(@PathVariable int tiendaId) {
		List<Proveedores> proveedores = service.buscarPorTiendaId(tiendaId);
		
		if (proveedores.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.status(HttpStatus.OK).body(proveedores);
			
	}
	
	
	
}















