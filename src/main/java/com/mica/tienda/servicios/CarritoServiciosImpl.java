package com.mica.tienda.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mica.tienda.entidades.Carrito;
import com.mica.tienda.repositorios.CarritoRepository;

@Service
public class CarritoServiciosImpl implements CarritoServicios {
	@Autowired
	private CarritoRepository carritorepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrito> findAll() {
		return carritorepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Carrito> findAll(Pageable pageable) {
		return carritorepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Carrito> findbyid(Long id) {
		return carritorepository.findById(id);
	}

	@Override
	@Transactional
	public Carrito save(Carrito carrito) {
		return carritorepository.save(carrito);
	}

	@Transactional
	@Override
	public void deletebyId(Long id) {
		carritorepository.deleteById(id);
	}
	/*
	 * @Override public <S extends Carrito> S saveAndFlush(Carrito carrito) { //
	 * TODO Auto-generated method stub return (S) carrito; }
	 */

}
