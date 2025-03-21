package com.mx.Proveedores.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Proveedores.Dao.IProveedoresDao;
import com.mx.Proveedores.Entity.Proveedores;

@Service
public class ProveedoresServImpl implements IProveedoresServ {

	@Autowired
	private IProveedoresDao dao;

	@Override
	public Proveedores guardar(Proveedores proveedor) {
		return dao.save(proveedor);
	}

	@Override
	public Proveedores editar(Proveedores proveedor) {
		Proveedores aux = this.buscar(proveedor.getId());
		if (aux != null) {
			return dao.save(proveedor);
		}
		return null;
	}

	@Override
	public Proveedores eliminar(Long id) {
		Proveedores aux = this.buscar(id);
		if (aux != null) {
			dao.deleteById(id);
			return aux;
		}
		return null;
	}

	@Override
	public Proveedores buscar(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Proveedores> listar() {
		return dao.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
	
	public List<Proveedores> buscarPorTiendaId(int tiendaId) {
		return dao.findByTiendaId(tiendaId);
	}

}
