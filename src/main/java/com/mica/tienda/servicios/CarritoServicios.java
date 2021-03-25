package com.mica.tienda.servicios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mica.tienda.entidades.Carrito;

public interface CarritoServicios {

	public Iterable<Carrito> findAll();

	public Page<Carrito> findAll(Pageable pageable);

	public Optional<Carrito> findbyid(Long id);

	public Carrito save(Carrito carrito);

	public void deletebyId(Long id);
//	<S extends Carrito> S saveAndFlush(Carrito carrito);

}
