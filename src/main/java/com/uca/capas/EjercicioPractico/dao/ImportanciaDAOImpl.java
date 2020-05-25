package com.uca.capas.EjercicioPractico.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.EjercicioPractico.domain.Importancia;

@Repository
public class ImportanciaDAOImpl  implements ImportanciaDAO{

	@PersistenceContext(unitName="EjercicioPractico")
	private EntityManager importanciaManager;
	
	@Override
	public List<Importancia> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.importancia");
		javax.persistence.Query query = importanciaManager.createNativeQuery(sb.toString(), Importancia.class);
		List<Importancia>resulset=query.getResultList();
		return resulset;
	}

	@Override
	public Importancia findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Importancia importancia = importanciaManager.find(Importancia.class, code);
		return importancia;
	}

	@Override
	public void save(Importancia c) throws DataAccessException {
		// TODO Auto-generated method stub
		importanciaManager.persist(c);
	}
	
	
}
