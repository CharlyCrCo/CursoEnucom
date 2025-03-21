package com.mx.Automovil.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mx.Automovil.Dao.IAutomovilDao;
import com.mx.Automovil.Entity.Automovil;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AutomovilServiceImpl implements IAutomovilService {

	@Autowired
	private IAutomovilDao dao;
	
	@Override
	public Automovil guardar(Automovil auto) {
		return dao.save(auto);
	}

	@Override
	public Automovil editar(Automovil auto) {
		
		Automovil aux = this.buscar(auto.getIdAuto());
		if(aux != null) {
			return dao.save(auto);
		}
		return null;
	}

	@Override
	public Automovil eliminar(Automovil auto) {
		Automovil aux = this.buscar(auto.getIdAuto());
		if(aux != null) {
			dao.delete(auto);
			return aux;
		}
		return null;
	}

	@Override
	public Automovil buscar(Long idAuto) {
		return dao.findById(idAuto).orElse(null);
	}

	@Override
	public List<Automovil> listar() {
		return dao.findAll(Sort.by(Direction.ASC, "idAuto"));
	}

	// Metodo personalizado
	
	public List<Automovil> buscarPorMarca(String marca){
		return dao.findByMarca(marca);
	}
	
	
}
