package com.usuarios.pueblo.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.usuarios.pueblo.exception.DAOException;
import com.usuarios.pueblo.exception.DomainException;


@Service
public interface  IServicio<T, S> {

	public boolean insert(T t);
	public boolean update(T t) throws DomainException, DAOException ;
	public boolean deleteById(S s);
	public List<T> listAll();
	public Optional<T>leerUno(S s);
}
