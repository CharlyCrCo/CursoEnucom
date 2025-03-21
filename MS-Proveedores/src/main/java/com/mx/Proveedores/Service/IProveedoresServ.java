package com.mx.Proveedores.Service;

import java.util.List;

import com.mx.Proveedores.Entity.Proveedores;

public interface IProveedoresServ {

	public Proveedores guardar(Proveedores proveedor);

	public Proveedores editar(Proveedores proveedor);

	public Proveedores eliminar(Long id);

	public Proveedores buscar(Long id);
	
	public List<Proveedores> listar();

}
