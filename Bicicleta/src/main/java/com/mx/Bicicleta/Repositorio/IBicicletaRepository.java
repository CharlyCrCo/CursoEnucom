package com.mx.Bicicleta.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.Bicicleta.Dominio.Bicicleta;

@Repository
public interface IBicicletaRepository extends CrudRepository<Bicicleta, Integer> {

}

