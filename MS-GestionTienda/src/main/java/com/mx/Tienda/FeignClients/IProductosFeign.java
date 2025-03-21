package com.mx.Tienda.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Tienda.Models.Productos;

@FeignClient(
		name = "MS-Productos", 
		url = "http://localhost:8010", 
		path = "/Productos")
public interface IProductosFeign {

	@PostMapping
	public Productos save(@RequestBody Productos producto);

	@GetMapping("/tienda/{tiendaId}")
	public List<Productos> getProductosByTiendaId(@PathVariable int tiendaId);

}
