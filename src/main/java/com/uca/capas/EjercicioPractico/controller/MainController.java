package com.uca.capas.EjercicioPractico.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.EjercicioPractico.domain.Contribuyente;
import com.uca.capas.EjercicioPractico.domain.Importancia;
import com.uca.capas.EjercicioPractico.service.ContribuyenteService;
import com.uca.capas.EjercicioPractico.service.ImportanciaService;

@Controller
public class MainController {
	
	@Autowired
	private ContribuyenteService contribuyenteService;
	
	@Autowired
	private ImportanciaService importanciaService;
	
	@RequestMapping("/index")
	public ModelAndView init() {
		
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String f_fecha= formatter.format(date); 
		
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = new Contribuyente(f_fecha);
		mav.addObject("contribuyente", contribuyente);
		List<Importancia> importancias = null;
		
		importancias = importanciaService.findAll();
		mav.addObject("importancia", contribuyente.getImportancia());
		mav.addObject("importancias", importancias);
		mav.setViewName("index");
		
		return mav;		
	}
	
	@RequestMapping("/listadoContribuyentes")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		List<Importancia> importancias =importanciaService.findAll(); 
		try {
			mav.addObject("importancias", importancias);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		mav.setViewName("listadoContribuyentes");
		return mav;
	}
	
	@RequestMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("index");
		}
		else {
			contribuyenteService.save(contribuyente);
			mav.setViewName("exito");
		}	
		return mav;
	}
}
