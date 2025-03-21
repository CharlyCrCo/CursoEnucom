package com.mx.Tienda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Tienda.Entity.Tienda;

public interface ITiendaRepository extends JpaRepository<Tienda, Integer> {

}
