package com.uca.capas.EjercicioPractico.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.EjercicioPractico.domain.Importancia;

public interface ImportanciaService {
	
	public List<Importancia>findAll() throws DataAccessException;
	
	public Importancia findOne(Integer code) throws DataAccessException;
	
	public void save(Importancia c) throws DataAccessException;
	
}
