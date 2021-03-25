package com.mica.tienda.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mica.tienda.entidades.Item;
import com.mica.tienda.repositorios.ItemRepository;

@Service
public class ItemServiciosImpl implements ItemServicios {
	@Autowired
	private ItemRepository itemrepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Item> findAll() {
		return itemrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Item> findAll(Pageable pageable) {
		return itemrepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Item> findbyid(Long id) {
		return itemrepository.findById(id);
	}

	@Override
	@Transactional
	public Item save(Item item) {
		return itemrepository.save(item);
	}

	@Transactional
	@Override
	public void deletebyId(Long id) {
		itemrepository.deleteById(id);
	}
	/*
	 * @Override public <S extends Item> S saveAndFlush(Item item) { // TODO
	 * Auto-generated method stub return (S) item; }
	 */

}
