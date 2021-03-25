package com.mica.tienda.servicios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mica.tienda.entidades.Producto;

public interface ProductoServicios {

	public Iterable<Producto> findAll();

	public Page<Producto> findAll(Pageable pageable);

	public Optional<Producto> findbyid(Long id);

	public Producto save(Producto producto);

	public void deletebyId(Long id);
//	<S extends Producto> S saveAndFlush(Producto producto);

}
