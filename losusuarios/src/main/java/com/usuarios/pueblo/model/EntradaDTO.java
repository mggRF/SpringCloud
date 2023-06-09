package com.usuarios.pueblo.model;


import org.springframework.stereotype.Component;




public class EntradaDTO {

	
	private Long id_entrada;	
	private String ent_fecha;
	private Long id_cine;
	private int ent_cantidad;
	private String idCliente;
	public EntradaDTO() {
		super();
	}
	public EntradaDTO(Long id_entrada, String ent_fecha, Long id_cine, int ent_cantidad, String idCliente) {
		super();
		this.id_entrada = id_entrada;
		this.ent_fecha = ent_fecha;
		this.id_cine = id_cine;
		this.ent_cantidad = ent_cantidad;
		this.idCliente = idCliente;
	}
	public Long getId_entrada() {
		return id_entrada;
	}
	public void setId_entrada(Long id_entrada) {
		this.id_entrada = id_entrada;
	}
	public String getEnt_fecha() {
		return ent_fecha;
	}
	public void setEnt_fecha(String ent_fecha) {
		this.ent_fecha = ent_fecha;
	}
	public Long getId_cine() {
		return id_cine;
	}
	public void setId_cine(Long id_cine) {
		this.id_cine = id_cine;
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
		return "EntradaDTO [id_entrada=" + id_entrada + ", ent_fecha=" + ent_fecha + ", id_cine=" + id_cine
				+ ", ent_cantidad=" + ent_cantidad + ", idCliente=" + idCliente + "]";
	}
	
	 
}
