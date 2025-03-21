package com.mx.Tienda.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.Models.Clientes;
import com.mx.Tienda.Models.Productos;
import com.mx.Tienda.Models.Proveedores;
import com.mx.Tienda.Service.TiendaServiceImp;

@RestController
@RequestMapping(path = "/Tienda")
public class TiendaWS {

	@Autowired
	private TiendaServiceImp service;

	// ----------------------------------------------- T I E N D A

	// Endpoint ListarTiendas
	// http://localhost:8014/Tienda
	@GetMapping
	public ResponseEntity<?> listarTiendas() {
		List<Tienda> tiendas = service.listar();
		if (tiendas.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		return ResponseEntity.status(HttpStatus.OK).body(tiendas);
	}

	// Endpoint Obtener Tienda
	// http://localhost:8014/Tienda/{idTienda}
	@GetMapping("/{idTienda}")
	public ResponseEntity<?> obtenerTienda(@PathVariable int idTienda) {
		Tienda tienda = service.buscar(idTienda);
		if (tienda == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		return ResponseEntity.status(HttpStatus.OK).body(tienda);
	}

	// Endpoint Guardar Tienda
	// http://localhost:8014/Tienda
	@PostMapping
	public ResponseEntity<?> guardarTienda(@RequestBody Tienda tienda) {
		Tienda nuevaTienda = service.guardar(tienda);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTienda);
	}

	// ----------------------------------------------- C L I E N T E S
	// Endpoint Guardar CLIENTE
	// http://localhost:8014/Tienda/Clientes
	@PostMapping("/Clientes")
	public ResponseEntity<?> guardarCliente(@RequestBody Clientes cliente) {
		Clientes nuevoCliente = service.saveCliente(cliente);
		if (nuevoCliente == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);

	}

	@GetMapping("/Clientes/{tiendaId}")
	public ResponseEntity<?> obtenerClientes(@PathVariable int tiendaId) {
		List<Clientes> clientes = service.getClientes(tiendaId);
		if (clientes == null || clientes.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		return ResponseEntity.status(HttpStatus.OK).body(clientes);
	}

	// ----------------------------------------------- P R O D U C T O S
	// Endpoint Guardar PRODUCTOS
	// http://localhost:8014/Tienda/Productos
	@PostMapping("/Productos")
	public ResponseEntity<?> guardarProducto(@RequestBody Productos producto) {
		Productos nuevoProducto = service.saveProducto(producto);
		if (nuevoProducto == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
	}

	@GetMapping("/Productos/{tiendaId}")
	public ResponseEntity<?> obtenerProductos(@PathVariable int tiendaId) {
		List<Productos> productos = service.getProductosRT(tiendaId);
		if (productos == null || productos.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		return ResponseEntity.status(HttpStatus.OK).body(productos);
	}

	// ----------------------------------------------- P R O V E E D O R E S
	// Endpoint Guardar PROVEEDORES
	// http://localhost:8014/Tienda/Proveedores
	@PostMapping("/Proveedores")
	public ResponseEntity<?> guardarProveedore(@RequestBody Proveedores proveedor) {
		Proveedores nuevoProveedor = service.saveProveedor(proveedor);
		if (nuevoProveedor == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProveedor);
	}

	@GetMapping("/Proveedores/{tiendaId}")
	public ResponseEntity<?> obtenerProveedores(@PathVariable int tiendaId) {
		List<Proveedores> proveedores = service.getProveedores(tiendaId);
		if (proveedores == null || proveedores.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		return ResponseEntity.status(HttpStatus.OK).body(proveedores);
	}

	// *************************************************************************************
	// Metodo para obtener toda la relacin de la TIENDA y sus MODULOS
	// (Microservicios)
	//
	// http://localhost:8014/Tienda/todo/{tiendaId}
	//
	// *************************************************************************************
	@GetMapping("/todo/{tiendaId}")
	public ResponseEntity<?> obtenerTodosLosModulos(@PathVariable int tiendaId) {
		Map<String, Object> modulos = service.obtenerTodosLosModulos(tiendaId);
		return ResponseEntity.status(HttpStatus.OK).body(modulos);
	}

}
