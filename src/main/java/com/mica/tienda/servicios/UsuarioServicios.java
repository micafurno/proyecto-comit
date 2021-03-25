package com.mica.tienda.servicios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mica.tienda.entidades.Usuario;

public interface UsuarioServicios {

	public Iterable<Usuario> findAll();

	public Page<Usuario> findAll(Pageable pageable);

	public Optional<Usuario> findbyid(Long id);

	public Usuario save(Usuario usuario);

	public void deletebyId(Long id);
//	<S extends Usuario> S saveAndFlush(Usuario usuario);
}
