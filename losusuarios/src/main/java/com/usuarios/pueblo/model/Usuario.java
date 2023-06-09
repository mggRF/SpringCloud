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

@Entity
public class Usuario {

	@Id
	private String id_usuario;
	
	@Column(nullable=false, length = 50)
	private String us_nombre;
	
	@Column(nullable=false, length = 50)
	private String username;
	
	@Column(nullable=false, length = 50)
	private String password;
	
	@Column(nullable=false, length = 250)
	private String email;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String id_usuario, String us_nombre, String username, String password, String email) {
		super();
		this.id_usuario = id_usuario;
		this.us_nombre = us_nombre;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUs_nombre() {
		return us_nombre;
	}

	public void setUs_nombre(String us_nombre) {
		this.us_nombre = us_nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", us_nombre=" + us_nombre + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}
	
	
	
	
}
