package com.usuarios.pueblo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usuarios.pueblo.exception.DAOException;
import com.usuarios.pueblo.exception.DomainException;
import com.usuarios.pueblo.model.EntradaRec;
import com.usuarios.pueblo.model.Usuario;
import com.usuarios.pueblo.repository.IUsuario;
import com.usuarios.pueblo.service.interfaces.IServicio;
import com.usuarios.pueblo.service.util.Rutinas;

@Service
public class UsuarioService implements IServicio<Usuario, String> {
	final String URL_CINE = "http://localhost:8001/api/entrada/leerporid";
	
	@Autowired
	private IUsuario usuarioRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean insert(Usuario usuario) {
		System.out.println(usuario);
		return usuarioRepository.save(usuario) != null;
	}
	@Override
	public List<Usuario> listAll() {
		return  usuarioRepository.findAll();
	}

	@Override
	public boolean update(Usuario usuario) throws DomainException, DAOException {

		Optional<Usuario> usuarioDBO = usuarioRepository.findById(usuario.getId_usuario());
		if (usuarioDBO.isEmpty()) {
			throw new DAOException("El registro ya no existe");
		}
		Usuario usuarioDB = usuarioDBO.get();
		
		usuarioDB.setId_usuario(Rutinas.nuevoSiNoVacio(usuarioDB.getId_usuario(), usuario.getId_usuario()));
		usuarioDB.setUs_nombre(Rutinas.nuevoSiNoVacio(usuarioDB.getUs_nombre(), usuario.getUs_nombre()));
		usuarioDB.setUsername(Rutinas.nuevoSiNoVacio(usuarioDB.getUsername(), usuario.getUsername()));
		usuarioDB.setPassword(Rutinas.nuevoSiNoVacio(usuarioDB.getPassword(), usuario.getPassword()));

		

		return usuarioRepository.save(usuarioDB) != null;
	}

	@Override
	public boolean deleteById(String id_usuario) {
		 usuarioRepository.deleteById(id_usuario);
		 return true;

	}


	public List<EntradaRec> leerEntradas(String idCliente){
		return  restTemplate.getForObject(URL_CINE + "/" + idCliente, List.class);
	}

	@Override
	public Optional<Usuario> leerUno(String id_usuario) {
		return usuarioRepository.findById(id_usuario);
	}

}
