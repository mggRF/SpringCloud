package com.cines.pueblo.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Entrada {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id_entrada;
	
	@Column(nullable=false)
	private LocalDate ent_fecha;
	
	@ManyToOne()
	@JoinColumn(name="id_cine")
	private Cine cine;
	
	@Column(nullable=false)
	private int ent_cantidad;
	
	@Column(nullable=false)
	private String idCliente;
	
	
	public Entrada() {
		super();
	}
	public Entrada(long id_entrada, LocalDate ent_fecha, Cine cine, int ent_cantidad) {
		super();
		this.id_entrada = id_entrada;
		this.ent_fecha = ent_fecha;
		this.cine = cine;
		this.ent_cantidad = ent_cantidad;
	}
	public long getId_entrada() {
		return id_entrada;
	}
	public void setId_entrada(long id_entrada) {
		this.id_entrada = id_entrada;
	}
	public LocalDate getEnt_fecha() {
		return ent_fecha;
	}
	public void setEnt_fecha(LocalDate ent_fecha) {
		this.ent_fecha = ent_fecha;
	}
	public Cine getCine() {
		return cine;
	}
	public void setCine(Cine cine) {
		this.cine = cine;
	}
	public int getEnt_cantidad() {
		return ent_cantidad;
	}
	public void setEnt_cantidad(int ent_cantidad) {
		this.ent_cantidad = ent_cantidad;
	}
	public String getidCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	@Override
	public String toString() {
		return "Entrada [id_entrada=" + id_entrada + ", ent_fecha=" + ent_fecha + ", cine=" + cine + ", ent_cantidad="
				+ ent_cantidad + ", idCliente=" + idCliente + "]";
	}
	
	
}
