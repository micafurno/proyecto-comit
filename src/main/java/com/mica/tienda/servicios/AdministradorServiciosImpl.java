package com.mica.tienda.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mica.tienda.entidades.Administrador;
import com.mica.tienda.repositorios.AdministradorRepository;

@Service
public class AdministradorServiciosImpl implements AdministradorServicios {
	@Autowired
	private AdministradorRepository administradorrepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Administrador> findAll() {
		return administradorrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Administrador> findAll(Pageable pageable) {
		return administradorrepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Administrador> findbyid(Long id) {
		return administradorrepository.findById(id);
	}

	@Override
	@Transactional
	public Administrador save(Administrador administrador) {
		return administradorrepository.save(administrador);
	}

	@Transactional
	@Override
	public void deletebyId(Long id) {
		administradorrepository.deleteById(id);
	}
	/*
	 * @Override public <S extends Administrador> S saveAndFlush(Administrador
	 * administrador) { // TODO Auto-generated method stub return (S) administrador;
	 * }
	 */

}
