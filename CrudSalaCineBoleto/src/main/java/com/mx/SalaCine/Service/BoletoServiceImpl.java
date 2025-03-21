package com.mx.SalaCine.Service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.SalaCine.Dao.IBoletoDao;
import com.mx.SalaCine.Entity.Boleto;

@Service
@Transactional
public class BoletoServiceImpl implements IBoletoService {
	
	// inyeccion de dependencias
	@Autowired
	private IBoletoDao dao;
	

	@Override
	public Boleto guardar(Boleto boleto) {
		return dao.save(boleto);
	}

	@Override
	public Boleto editar(Boleto boleto) {
		Boleto aux = this.buscar(boleto);
		if(aux != null) {
			return dao.save(boleto);
		}
		return null;
	}

	@Override
	public Boleto eliminar(Boleto boleto) {
		Boleto aux = this.buscar(boleto);
		if(aux != null) {
			dao.delete(boleto);
			return aux;
		}
		return null;
	}

	@Override
	public Boleto buscar(Boleto boleto) {
		return dao.findById(boleto.getIdBoleto()).orElse(null);
	}

	@Override
	public List<Boleto> listar() {
		return dao.findAll(Sort.by(Direction.ASC, "idBoleto"));
	}
	
	// Metodos personalizados
	public List<Boleto> buscarPorPelicula(String nomPelicula){
		return dao.findByNomPelicula(nomPelicula);
	}
	
	public List<Boleto> buscarPorClasificacion(String clasificacion){
		return dao.findByClasificacion(clasificacion);
	}
	
	public List<Boleto> buscarPorPelicula2(String nomPelicula){
		return dao.findByNomPeliculaContainingIgnoringCaseOrderByIdBoleto(nomPelicula);
	}
	
}

















