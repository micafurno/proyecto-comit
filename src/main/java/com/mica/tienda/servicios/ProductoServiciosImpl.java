package com.mica.tienda.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mica.tienda.entidades.Producto;
import com.mica.tienda.repositorios.ProductoRepository;

@Service
public class ProductoServiciosImpl implements ProductoServicios {

	@Autowired
	private ProductoRepository productorepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findAll() {
		return productorepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {
		return productorepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findbyid(Long id) {
		return productorepository.findById(id);
	}

	@Override
	@Transactional
	public Producto save(Producto producto) {
		return productorepository.save(producto);
	}

	@Transactional
	@Override
	public void deletebyId(Long id) {
		productorepository.deleteById(id);
	}
	/*
	 * @Override public <S extends Producto> S saveAndFlush(Producto producto) { //
	 * TODO Auto-generated method stub return (S) producto; }
	 */

}
