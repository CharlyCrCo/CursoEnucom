package com.mx.Tienda.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Proveedores;

@FeignClient(
		name = "MS-Proveedores", 
		url = "http://localhost:8011", 
		path = "/Proveedores")
public interface IProveedoresFeign {

	@PostMapping
	public Proveedores save(@RequestBody Proveedores proveedor);

	@PostMapping("/tienda/{tiendaId}")
	public List<Proveedores> getProveedoresByTiendaId(@PathVariable int tiendaId);

	
}
