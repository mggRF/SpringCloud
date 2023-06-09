package com.usuarios.pueblo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.usuarios.pueblo.model.Usuario;
import com.usuarios.pueblo.service.UsuarioService;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioTest {

	@Autowired
	private UsuarioService cDao;
	
	@Test
	public void testGuarda() {
		Usuario usuario = new Usuario();
		usuario.setId_usuario(0l);
		usuario.setCi_nombre("Las pruebas");
		boolean guardado = cDao.insert(usuario);
		assertTrue(guardado);
	}
	
}
