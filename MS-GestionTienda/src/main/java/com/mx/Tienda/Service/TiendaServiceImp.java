package com.mx.Tienda.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Tienda.Entity.Tienda;
import com.mx.Tienda.FeignClients.IClientesFeign;
import com.mx.Tienda.FeignClients.IProductosFeign;
import com.mx.Tienda.FeignClients.IProveedoresFeign;
import com.mx.Tienda.Models.Clientes;
import com.mx.Tienda.Models.Productos;
import com.mx.Tienda.Models.Proveedores;
import com.mx.Tienda.Repository.ITiendaRepository;

@Service
@SuppressWarnings("unchecked")
public class TiendaServiceImp implements ITiendaService {

	// ------------------------------- Inyeccion de depentencias
	@Autowired
	private ITiendaRepository dao;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private IClientesFeign clientesFC;

	@Autowired
	private IProductosFeign productosFC;

	@Autowired
	private IProveedoresFeign proveedoresFC;

	// --------------------------------Servicios de TIENDA
	@Override
	public List<Tienda> listar() {
		return dao.findAll(Sort.by(Direction.ASC, "idTienda"));
	}

	@Override
	public Tienda buscar(int idTienda) {
		return dao.findById(idTienda).orElse(null);
	}

	@Override
	public Tienda guardar(Tienda tienda) {
		return dao.save(tienda);
	}

	// --------------------------------- Servicios de CLIENTES

	// Metodos con FeignClient
	public Clientes saveCliente(Clientes cliente) {
		return clientesFC.save(cliente);
	}

	public List<Clientes> getClientes(int tiendaId) {
		return clientesFC.getClientesByTiendaId(tiendaId);
	}

	// Metodos con RestTemplate
	public Clientes saveClienteRT(Clientes cliente) {
		ResponseEntity<Clientes> response = restTemplate.postForEntity("http://localhost:8013/Clientes", cliente,
				Clientes.class);

		return response.getBody();
	}

	public List<Clientes> getClientesRT(int tiendaId) {

		return restTemplate.postForObject("http://localhost:8013/Clientes/tienda/" + tiendaId, null, List.class);

	}

	// --------------------------------- Servicios de PRODUCTOS

	// Metodos con FeignClient
	public Productos saveProducto(Productos producto) {
		return productosFC.save(producto);
	}

	public List<Productos> getProductos(int tiendaId) {
		return productosFC.getProductosByTiendaId(tiendaId);
	}

	// Metodos con RestTemplate
	public Productos saveProductoRT(Productos producto) {
		ResponseEntity<Productos> response = restTemplate.postForEntity("http://localhost:8010/Productos", producto,
				Productos.class);

		return response.getBody();
	}

	public List<Productos> getProductosRT(int tiendaId) {
		return restTemplate.getForObject("http://localhost:8010/Productos/tienda/" + tiendaId, List.class);
	}

	// --------------------------------- Servicios de PROVEEDORES

	// Metodos con FeignClient
	public Proveedores saveProveedor(Proveedores proveedor) {
		return proveedoresFC.save(proveedor);
	}

	public List<Proveedores> getProveedores(int tiendaId) {
		return proveedoresFC.getProveedoresByTiendaId(tiendaId);
	}

	// Metodos con RestTemplate
	public Proveedores saveProveedorRT(Proveedores proveedor) {
		ResponseEntity<Proveedores> response = restTemplate.postForEntity("http://localhost:8011/Proveedores",
				proveedor, Proveedores.class);

		return response.getBody();
	}

	public List<Proveedores> getProveedoresRT(int tiendaId) {

		return restTemplate.postForObject("http://localhost:8011/Proveedores/tienda/" + tiendaId, null, List.class);

	}

	// *************************************************************************************
	// Metodo para obtener toda la relacin de la TIENDA y sus MODULOS
	// (Microservicios)
	// *************************************************************************************

	public Map<String, Object> obtenerTodosLosModulos(int tiendaId) {

		Map<String, Object> resultado = new HashMap<>();

		// Constultar y validar la TIENDA
		Tienda tienda = this.buscar(tiendaId);
		if (tienda == null) {
			resultado.put("Mensaje", "La tienda con ID: " + tiendaId + " no existe.");
			return resultado;
		}

		resultado.put("Tienda", tienda);

		// Consultar y validar los Clientes
		List<Clientes> clientes = this.getClientesRT(tiendaId);
		if (clientes == null || clientes.isEmpty()) {
			resultado.put("Clientes", "La tienda no tiene clientes.");
		} else {
			resultado.put("Clientes", clientes);
		}

		// Consultar y validar los Productos
		List<Productos> productos = this.getProductos(tiendaId);
		if (productos == null || productos.isEmpty()) {
			resultado.put("Productos", "La tienda no tiene productos.");
		} else {
			resultado.put("Productos", productos);
		} 

		// Constular y valirdar los Proveedores
		List<Proveedores> proveedores = this.getProveedoresRT(tiendaId);
		if (proveedores == null || proveedores.isEmpty()) {
			resultado.put("Proveedores", "La tienda no tiene proveedores.");
		} else {
			resultado.put("Proveedores", proveedores);
		}

		return resultado;

	}

}
