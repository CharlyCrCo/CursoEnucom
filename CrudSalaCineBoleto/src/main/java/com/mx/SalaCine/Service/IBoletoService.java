package com.mx.SalaCine.Service;

import java.util.List;

import com.mx.SalaCine.Entity.Boleto;

public interface IBoletoService {

	public Boleto guardar(Boleto boleto);

	public Boleto editar(Boleto boleto);

	public Boleto eliminar(Boleto boleto);

	public Boleto buscar(Boleto boleto);

	public List<Boleto> listar();
}
