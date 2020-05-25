package com.uca.capas.EjercicioPractico.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.EjercicioPractico.dao.ContribuyenteDAO;
import com.uca.capas.EjercicioPractico.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {
	
	@Autowired
	ContribuyenteDAO contribuyenteDAO;
	
	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.findAll();
	}

	@Override
	public Contribuyente findOne(Integer c_contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.findOne(c_contribuyente);
	}

	@Override
	@Transactional
	public void save(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		contribuyenteDAO.save(contribuyente);
	}

	@Override
	@Transactional
	public void delete(Integer c_contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub
		contribuyenteDAO.delete(c_contribuyente);
	}

}
