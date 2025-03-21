package com.mx.SalaCine.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.SalaCine.Dao.ISalaDao;
import com.mx.SalaCine.Entity.Sala;

@Service
@Transactional
/*
 * @Transactional: Asegura la integridad de los datos al manejar transacciones
 * automaticamente. - Si ocurre un error, se hace rollback automaticamente.
 */
public class SalaServiceImpl implements ISalaService {

	// Inyeccion de dependencias
	@Autowired
	private ISalaDao dao;

	// @Transactional
	@Override
	public Sala guardar(Sala sala) {
		return dao.save(sala);
	}

	// @Transactional
	@Override
	public Sala editar(Sala sala) {
		Sala aux = this.buscar(sala);
		if (aux != null) {
			dao.save(sala);
		}
		return null;
	}

	// @Transactional
	@Override
	public Sala eliminar(Sala sala) {
		Sala aux = this.buscar(sala);
		if (aux != null) {
			dao.delete(sala);
			return aux;
		}
		return null;
	}

	@Override
	public Sala buscar(Sala sala) {
		return dao.findById(sala.getIdSala()).orElse(null);
	}

	@Override
	public List<Sala> listar() {
		return dao.findAll(Sort.by(Direction.ASC, "idSala"));
	}

	// Metodos personalizados

	public List<Sala> buscarPorCategoria1(String categoria) {
		return dao.findByCategoria(categoria);
	}

	public List<Sala> buscarPorCategoria2(String categoria) {
		return dao.findByCategoriaIgnoringCaseOrderByIdSala(categoria);
	}

}
