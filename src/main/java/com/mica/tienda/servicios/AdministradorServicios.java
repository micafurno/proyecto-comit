package com.mica.tienda.servicios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mica.tienda.entidades.Administrador;

public interface AdministradorServicios {

	public Iterable<Administrador> findAll();

	public Page<Administrador> findAll(Pageable pageable);

	public Optional<Administrador> findbyid(Long id);

	public Administrador save(Administrador administrador);

	public void deletebyId(Long id);
//	<S extends Administrador> S saveAndFlush(Administrador administrador);
}
