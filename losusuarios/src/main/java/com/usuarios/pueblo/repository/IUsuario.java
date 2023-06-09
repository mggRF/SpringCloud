package com.usuarios.pueblo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarios.pueblo.model.Usuario;



public interface IUsuario extends JpaRepository<Usuario, String>{


}
