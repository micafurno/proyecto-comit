package com.mica.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mica.tienda.entidades.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
