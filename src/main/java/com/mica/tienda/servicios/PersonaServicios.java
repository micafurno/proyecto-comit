package com.mica.tienda.servicios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mica.tienda.entidades.Persona;

public interface PersonaServicios {

	public Iterable<Persona> findAll();

	public Page<Persona> findAll(Pageable pageable);

	public Optional<Persona> findbyid(Long id);

	public Persona save(Persona persona);

	public void deletebyId(Long id);
//	<S extends Persona> S saveAndFlush(Persona persona);

}
