package com.mica.tienda.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mica.tienda.entidades.Persona;
import com.mica.tienda.repositorios.PersonaRepository;

@Service
public class PersonaServiciosImpl implements PersonaServicios {
	@Autowired
	private PersonaRepository personarepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> findAll() {
		return personarepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Persona> findAll(Pageable pageable) {
		return personarepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> findbyid(Long id) {
		return personarepository.findById(id);
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		return personarepository.save(persona);
	}

	@Transactional
	@Override
	public void deletebyId(Long id) {
		personarepository.deleteById(id);
	}
	/*
	 * @Override public <S extends Persona> S saveAndFlush(Persona persona) { //
	 * TODO Auto-generated method stub return (S) persona; }
	 */

}
