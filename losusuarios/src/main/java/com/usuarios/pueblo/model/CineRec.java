package com.usuarios.pueblo.model;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


public class CineRec {

	private long id_cine;
	
	private String ci_nombre;
	
	private int ci_capacidad;
	
	
	public CineRec() {
		super();
	}
	public CineRec(long id_cine, String ci_nombre, int ci_capacidad) {
		super();
		this.id_cine = id_cine;
		this.ci_nombre = ci_nombre;
		this.ci_capacidad = ci_capacidad;
	}
	public long getId_cine() {
		return id_cine;
	}
	public void setId_cine(long id_cine) {
		this.id_cine = id_cine;
	}
	public String getCi_nombre() {
		return ci_nombre;
	}
	public void setCi_nombre(String ci_nombre) {
		this.ci_nombre = ci_nombre;
	}
	public int getCi_capacidad() {
		return ci_capacidad;
	}
	public void setCi_capacidad(int ci_capacidad) {
		this.ci_capacidad = ci_capacidad;
	}
	@Override
	public String toString() {
		return "Cine [id_cine=" + id_cine + ", ci_nombre=" + ci_nombre + ", ci_capacidad=" + ci_capacidad + "]";
	}
	
}
