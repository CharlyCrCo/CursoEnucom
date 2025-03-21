package com.mx.Tienda.Service;

import java.util.List;

import com.mx.Tienda.Entity.Tienda;

public interface ITiendaService {

	public List<Tienda> listar();

	public Tienda buscar(int idTienda);

	public Tienda guardar(Tienda tienda);
}
