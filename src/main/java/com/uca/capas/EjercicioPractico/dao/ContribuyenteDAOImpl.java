package com.uca.capas.EjercicioPractico.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.EjercicioPractico.domain.Contribuyente;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO{

	@PersistenceContext(unitName = "EjercicioPractico")
	private EntityManager entityManager;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.contribuyente");
		javax.persistence.Query q = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente> resultset = q.getResultList();
		
		return resultset;
	}

	@Override
	public Contribuyente findOne(Integer c_contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		Contribuyente contribuyente = entityManager.find(Contribuyente.class, c_contribuyente);
		return contribuyente;
	}

	@Override
	public void save(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			if(contribuyente.getC_contribuyente() == null) {
				entityManager.persist(contribuyente);
			}else {
				entityManager.merge(contribuyente);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer c_contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		Contribuyente contribuyente = entityManager.find(Contribuyente.class, c_contribuyente);
		entityManager.remove(contribuyente);
	}

}
