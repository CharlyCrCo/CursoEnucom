package com.mx.Bicicleta.Servicio;

import java.util.List;

import com.mx.Bicicleta.Dominio.Bicicleta;

public interface IBicicletaService {

	public void guardar(Bicicleta bici);

	public void editar(Bicicleta bici);

	public void eliminar(int idBici);

	public Bicicleta buscar(int idBici);

	public List<Bicicleta> listar();
}
