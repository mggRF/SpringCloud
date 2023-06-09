package com.usuarios.pueblo.model;

import java.time.LocalDate;

public class EntradaRec {
	
	private long id_entrada;

	private LocalDate ent_fecha;
	
	private CineRec cine;
	
	private int ent_cantidad;
	
	private String idCliente;

	public EntradaRec() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntradaRec(LocalDate ent_fecha, CineRec cine, int ent_cantidad, String idCliente) {
		super();
		this.ent_fecha = ent_fecha;
		this.cine = cine;
		this.ent_cantidad = ent_cantidad;
		this.idCliente = idCliente;
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

	public CineRec getCine() {
		return cine;
	}

	public void setCine(CineRec cine) {
		this.cine = cine;
	}

	public int getEnt_cantidad() {
		return ent_cantidad;
	}

	public void setEnt_cantidad(int ent_cantidad) {
		this.ent_cantidad = ent_cantidad;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "EntradaRec [ent_fecha=" + ent_fecha + ", cine=" + cine + ", ent_cantidad=" + ent_cantidad
				+ ", idCliente=" + idCliente + "]";
	}
	
}
