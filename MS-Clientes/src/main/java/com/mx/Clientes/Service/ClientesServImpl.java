package com.mx.Clientes.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Clientes.Dao.IClientesDao;
import com.mx.Clientes.Entity.Clientes;

@Service
public class ClientesServImpl implements IClientesService {

	@Autowired
	private IClientesDao dao;

	@Override
	public Clientes guardar(Clientes cliente) {
		return dao.save(cliente);
	}

	@Override
	public Clientes editar(Clientes cliente) {
		Clientes aux = this.buscar(cliente.getIdCliente());
		if (aux != null) {
			return dao.save(cliente);
		}
		return null;
	}

	@Override
	public Clientes eliminar(Long idCliente) {
		Clientes aux = this.buscar(idCliente);
		if (aux != null) {
			dao.deleteById(idCliente);
			return aux;
		}
		return null;
	}

	@Override
	public Clientes buscar(Long idCliente) {
		return dao.findById(idCliente).orElse(null);
	}

	@Override
	public List<Clientes> listar() {
		return dao.findAll(Sort.by(Direction.DESC, "idCliente"));
	}

	public List<Clientes> byTiendaId(int tiendaId) {
		return dao.findByTiendaId(tiendaId);
	}

}
