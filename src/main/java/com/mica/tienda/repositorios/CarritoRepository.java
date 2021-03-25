package com.mica.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mica.tienda.entidades.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {

}
