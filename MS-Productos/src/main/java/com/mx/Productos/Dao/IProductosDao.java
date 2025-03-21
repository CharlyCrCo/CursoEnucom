package com.mx.Productos.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Productos.Entity.Productos;

@Repository
public interface IProductosDao extends JpaRepository<Productos, Long> {

	public List<Productos> findByTiendaId(int tiendaId);

}
