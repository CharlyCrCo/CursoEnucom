package com.mx.Clientes.Service;

import java.util.List;

import com.mx.Clientes.Entity.Clientes;

public interface IClientesService {

	public Clientes guardar(Clientes cliente);

	public Clientes editar(Clientes cliente);

	public Clientes eliminar(Long idCliente);

	public Clientes buscar(Long idCliente);

	public List<Clientes> listar();

}
