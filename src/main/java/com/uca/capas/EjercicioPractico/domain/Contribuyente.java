package com.uca.capas.EjercicioPractico.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table( schema = "public", name = "contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_contribuyente")
	public Integer c_contribuyente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_importancia")
	private Importancia importancia;
	
	@Size(message = "No debe pasarse de 30 caracteres", max = 30)
	@NotEmpty(message = "No debe estar vacio el campo")
	@Column(name = "s_nombre")
	public String s_nombre;
	
	@Size(message = "No debe pasarse de 30 caracteres", max = 30)
	@NotEmpty(message = "No debe estar vacio el campo")
	@Column(name = "s_apellido")
	public String s_apellido;
	
	@Size(message = "Debe ser de 14 digitos",min =14, max = 14)
	@NotEmpty(message = "No debe estar vacio el campo")
	@Column(name = "s_nit")
	public String s_nit;
	
	@Column(name = "f_fecha")
	public String f_fecha;
	
	Contribuyente() {}
	
	public Contribuyente(String f_fecha) {
		super();
		this.f_fecha = f_fecha;
	}

	public Integer getC_contribuyente() {
		return c_contribuyente;
	}

	public void setC_contribuyente(Integer c_contribuyente) {
		this.c_contribuyente = c_contribuyente;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	public String getS_nombre() {
		return s_nombre;
	}

	public void setS_nombre(String s_nombre) {
		this.s_nombre = s_nombre;
	}

	public String getS_apellido() {
		return s_apellido;
	}

	public void setS_apellido(String s_apellido) {
		this.s_apellido = s_apellido;
	}

	public String getS_nit() {
		return s_nit;
	}

	public void setS_nit(String s_nit) {
		this.s_nit = s_nit;
	}

	public String getF_fecha() {
		return f_fecha;
	}

	public void setF_fecha(String f_fecha) {
		this.f_fecha = f_fecha;
	}
	
}
