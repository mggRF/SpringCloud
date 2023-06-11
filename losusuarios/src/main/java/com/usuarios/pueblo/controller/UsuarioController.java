package com.usuarios.pueblo.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuarios.pueblo.exception.ControllerException;
import com.usuarios.pueblo.exception.DAOException;
import com.usuarios.pueblo.exception.DomainException;
import com.usuarios.pueblo.model.EntradaDTO;
import com.usuarios.pueblo.model.EntradaRec;
import com.usuarios.pueblo.model.Usuario;
import com.usuarios.pueblo.service.UsuarioService;
import com.usuarios.pueblo.service.interfaces.IServicio;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService cDao;

	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> leerUno(@PathVariable("id") String id) throws ControllerException {
		String mensaje = "";
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		if (id != null) {
			try {
				Optional<Usuario> usuarioDB = (Optional<Usuario>) cDao.leerUno(id);

				if (usuarioDB.isPresent()) {
					map.put("status", 1);
					map.put("data", usuarioDB.get());
					return new ResponseEntity<>(map, HttpStatus.OK);
				} else {
					mensaje = "No existen datos";
				}
			} catch (NumberFormatException nfe) {
				mensaje = "Formato erroneo";
			}
		} else {
			mensaje = "Formato erroneo";
		}
		throw new ControllerException(mensaje);

	}

	@GetMapping({ "", "/" })
	public ResponseEntity<Map<String, Object>> leerTodos() throws ControllerException {

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		List<Usuario> cat = cDao.listAll();
		if (!cat.isEmpty()) {
			map.put("status", 1);
			map.put("data", cat);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			throw new ControllerException("No existen datos");
//			map.clear();
//			map.put("status", 0);
//			map.put("message", "No existen datos");
//			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> alta(@RequestBody Usuario c)
			throws DomainException, ControllerException { // ID,NOMBRE,DESCRIPCION

//		throw new DomainException("Mensaje de pruebas");
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		if (cDao.insert(c)) {
			map.put("status", 1);
			map.put("message", "Registro salvado");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			throw new ControllerException("Error al hacer la insercion");
		}
	}

	@PutMapping
	public ResponseEntity<Map<String, Object>> modificacion(@RequestBody Usuario c)
			throws ControllerException, DomainException, DAOException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		if (cDao.update(c)) {
			map.put("status", 1);
			map.put("message", "Error al actualizar");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			throw new ControllerException("Error al hacer la modificacion");

		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Object>> eliminar(@PathVariable("id") String ids) throws ControllerException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		if (ids != null) {
			try {
				String id = ids;
				Optional<Usuario> usuarioDB = cDao.leerUno(id);
				cDao.deleteById(usuarioDB.get().getId_usuario());
				map.put("status", 1);
				map.put("message", "Registro borrado");
				return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			} catch (Exception ex) {
				throw new ControllerException("Error al borrar");

			}
		}
		throw new ControllerException("No existe registro al borrar");
	}

	@GetMapping("/error")
	public ResponseEntity<Map<String, Object>> error() throws DomainException, ControllerException {

		throw new DomainException("Mensaje de pruebas");
	}

	@CircuitBreaker(name = "miInstancia", fallbackMethod = "fallbackleerPorId")
	@GetMapping("/leerporid/{idCliente}")
	public ResponseEntity<Map<String, Object>> leerPorId(@PathVariable("idCliente") String idCliente)
			throws ControllerException {
		String mensaje = "";
		if (idCliente != null) {
			try {
				Optional<Usuario> usuarioDB = cDao.leerUno(idCliente);
				if (usuarioDB.isPresent()) {
					Map<String, Object> map = new LinkedHashMap<String, Object>();
					List<EntradaRec> users = cDao.leerEntradas(idCliente);
					if (!users.isEmpty()) {
						map.put("status", 1);
						map.put("data", users);
						return new ResponseEntity<>(map, HttpStatus.OK);
					} else {
						throw new ControllerException("No existen datos");

					}
				}
			} catch (NumberFormatException nfe) {
				mensaje = "Formato erroneo";
			}
		} else {
			mensaje = "Formato erroneo";
		}
		throw new ControllerException(mensaje);
	}

	@CircuitBreaker(name = "miInstancia", fallbackMethod = "fallbackAnotaEntrada")
	@PostMapping("/anotaentrada")
	public ResponseEntity<EntradaRec> anotaentrada(@RequestBody EntradaDTO c) {
		if (cDao.leerUno(c.getIdCliente()).isPresent()) {
			EntradaRec nuevaEntrada = cDao.anotaEntrada(c);
			return ResponseEntity.ok(nuevaEntrada);
		}
		return ResponseEntity.notFound().build();
	}

	private ResponseEntity<Map<String, Object>> fallbackleerPorId(@PathVariable("idCliente") String idCliente, RuntimeException e)
			throws ControllerException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("status", 0);
		map.put("data", "No se puede informar de Cines en este momento");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> fallbackAnotaEntrada(@RequestBody EntradaDTO c, RuntimeException e) {
		e.printStackTrace();
		return ResponseEntity.ok("No se puede acceder a cnes en este momento");
	}
}
