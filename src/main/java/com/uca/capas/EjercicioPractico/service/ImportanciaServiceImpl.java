package com.uca.capas.EjercicioPractico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.EjercicioPractico.dao.ImportanciaDAO;
import com.uca.capas.EjercicioPractico.domain.Importancia;

@Service
public class ImportanciaServiceImpl implements ImportanciaService {
	
	@Autowired
	ImportanciaDAO importanciaDAO;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return importanciaDAO.findAll();
	}

	@Override
	public Importancia findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return importanciaDAO.findOne(code);
	}

	@Override
	public void save(Importancia c) throws DataAccessException {
		// TODO Auto-generated method stub
		importanciaDAO.save(c);
	}

}
