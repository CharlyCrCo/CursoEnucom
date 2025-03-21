package com.mx.Productos.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Productos.Dao.IProductosDao;
import com.mx.Productos.Entity.Productos;

@Service
public class ProductosServiceImpl implements IProductosService {

	// Inyeccion de dependencias
	@Autowired
	private IProductosDao dao;

	@Override
	public Productos guardar(Productos producto) {
		return dao.save(producto);
	}

	@Override
	public Productos editar(Productos producto) {
		Productos aux = this.buscar(producto.getIdProducto());
		if (aux != null) {
			return dao.save(producto);
		}
		return null;
	}

	@Override
	public Productos eliminar(Long idProducto) {
		Productos aux = this.buscar(idProducto);
		if (aux != null) {
			dao.deleteById(idProducto);
		}
		return aux;
	}

	@Override
	public Productos buscar(Long idProducto) {
		return dao.findById(idProducto).orElse(null);
	}

	@Override
	public List<Productos> listar() {
		return dao.findAll(Sort.by(Direction.DESC, "idProducto"));
	}

	public List<Productos> byTiendaId(int tiendaId) {
		return dao.findByTiendaId(tiendaId);
	}

}
