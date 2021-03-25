package com.mica.tienda.controladores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mica.tienda.entidades.Usuario;
import com.mica.tienda.servicios.UsuarioServicios;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioServicios usuarioServicios;

	/*
	 * @PostMapping(value = "/") public ResponseEntity<Usuario>
	 * nuevoUsuario(@RequestBody Persona per){
	 * 
	 * Usuario usuario = new Usuario(); carrito.setPersona(per);
	 * carritoServicios.saveAndFlush(usuario); return ResponseEntity.ok(usuario);
	 * 
	 * }
	 */

	@PostMapping(value = "/")
	public Usuario save(@RequestBody Usuario usuario) {
		return this.usuarioServicios.save(usuario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long usuarioId) {
		Optional<Usuario> oUsuario = usuarioServicios.findbyid(usuarioId);
		if (!oUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUsuario);
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuarioDetails, @PathVariable Long usuarioId) {
		Optional<Usuario> usuario = usuarioServicios.findbyid(usuarioId);
		if (!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuario.get().setId(usuarioDetails.getId());
		usuario.get().setNombre(usuarioDetails.getNombre());
		usuario.get().setApellido(usuarioDetails.getApellido());
		usuario.get().setDni(usuarioDetails.getDni());
		usuario.get().setEmail(usuarioDetails.getEmail());
		usuario.get().setTelefono(usuarioDetails.getTelefono());
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServicios.save(usuario.get()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long usuarioId) {
		if (!usuarioServicios.findbyid(usuarioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		usuarioServicios.deletebyId(usuarioId);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Usuario> readAll() {
		List<Usuario> Usuarios = StreamSupport.stream(usuarioServicios.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Usuarios;
	}
}
