package com.mica.tienda.servicios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mica.tienda.entidades.Item;

public interface ItemServicios {

	public Iterable<Item> findAll();

	public Page<Item> findAll(Pageable pageable);

	public Optional<Item> findbyid(Long id);

	public Item save(Item item);

	public void deletebyId(Long id);
//	<S extends Item> S saveAndFlush(Item item);

}
