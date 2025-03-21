package com.mx.Automovil.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.Automovil.Entity.Automovil;

@Repository
public interface IAutomovilDao extends JpaRepository<Automovil, Long> {

	@Query(nativeQuery = true,
			value = "SELECT * FROM AUTOMOVIL "
					+ "WHERE UPPER(MARCA) LIKE '%' || UPPER(:marca) || '%'")
	public List<Automovil> findByMarca(String marca);
}
