package com.mica.tienda.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mica.tienda.entidades.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
