package com.mica.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mica.tienda.entidades.Administrador;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

}
