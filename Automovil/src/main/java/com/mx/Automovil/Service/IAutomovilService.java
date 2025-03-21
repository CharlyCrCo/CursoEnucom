package com.mx.Automovil.Service;

import java.util.List;

import com.mx.Automovil.Entity.Automovil;

public interface IAutomovilService {

	public Automovil guardar(Automovil auto);

	public Automovil editar(Automovil auto);

	public Automovil eliminar(Automovil auto);

	public Automovil buscar(Long idAuto);

	public List<Automovil> listar();

}
