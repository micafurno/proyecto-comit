package com.mica.tienda.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mica.tienda.entidades.Usuario;
import com.mica.tienda.repositorios.UsuarioRepository;

@Service
public class UsuarioServiciosImpl implements UsuarioServicios {
	@Autowired
	private UsuarioRepository usuariorepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		return usuariorepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		return usuariorepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findbyid(Long id) {
		return usuariorepository.findById(id);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuariorepository.save(usuario);
	}

	@Transactional
	@Override
	public void deletebyId(Long id) {
		usuariorepository.deleteById(id);
	}
	/*
	 * @Override public <S extends Usuario> S saveAndFlush(Usuario usuario) { //
	 * TODO Auto-generated method stub return (S) usuario; }
	 */

}
