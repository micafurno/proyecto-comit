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

import com.mica.tienda.entidades.Administrador;
import com.mica.tienda.servicios.AdministradorServicios;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorController {

	@Autowired
	private AdministradorServicios administradorServicios;

	/*
	 * @PostMapping(value = "/") public ResponseEntity<Administrador>
	 * nuevoAdministrador(@RequestBody Persona per){
	 * 
	 * Administrador administrador = new Administrador();
	 * administrador.setPersona(per);
	 * administradorServicios.saveAndFlush(administrador); return
	 * ResponseEntity.ok(administrador);
	 * 
	 * }
	 */

	@PostMapping(value = "/")
	public Administrador save(@RequestBody Administrador administrador) {
		return this.administradorServicios.save(administrador);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long administradorId) {
		Optional<Administrador> oAdministrador = administradorServicios.findbyid(administradorId);
		if (!oAdministrador.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oAdministrador);
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Administrador administradorDetails,
			@PathVariable Long administradorId) {
		Optional<Administrador> administrador = administradorServicios.findbyid(administradorId);
		if (!administrador.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		administrador.get().setId(administradorDetails.getId());
		administrador.get().setNombre(administradorDetails.getNombre());
		administrador.get().setApellido(administradorDetails.getApellido());
		administrador.get().setDni(administradorDetails.getDni());
		administrador.get().setEmail(administradorDetails.getEmail());
		administrador.get().setTelefono(administradorDetails.getTelefono());
		return ResponseEntity.status(HttpStatus.CREATED).body(administradorServicios.save(administrador.get()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long administradorId) {
		if (!administradorServicios.findbyid(administradorId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		administradorServicios.deletebyId(administradorId);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Administrador> readAll() {
		List<Administrador> Administradores = StreamSupport
				.stream(administradorServicios.findAll().spliterator(), false).collect(Collectors.toList());
		return Administradores;
	}

}
