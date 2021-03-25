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

import com.mica.tienda.entidades.Persona;
import com.mica.tienda.servicios.PersonaServicios;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

	@Autowired
	private PersonaServicios personaServicios;

	/*
	 * @PostMapping(value = "/") public ResponseEntity<Persona>
	 * nuevoPersona(@RequestBody Persona car){
	 * 
	 * Persona persona = new Persona(); persona.setCarrito(car);
	 * personaServicios.saveAndFlush(persona); return ResponseEntity.ok(persona);
	 * 
	 * }
	 */

	@PostMapping(value = "/")
	public Persona save(@RequestBody Persona persona) {
		return this.personaServicios.save(persona);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long personaId) {
		Optional<Persona> oPersona = personaServicios.findbyid(personaId);
		if (!oPersona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oPersona);
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Persona personaDetails, @PathVariable Long personaId) {
		Optional<Persona> persona = personaServicios.findbyid(personaId);
		if (!persona.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		persona.get().setId(personaDetails.getId());
		persona.get().setNombre(personaDetails.getNombre());
		persona.get().setApellido(personaDetails.getApellido());
		persona.get().setDni(personaDetails.getDni());
		persona.get().setEmail(personaDetails.getEmail());
		persona.get().setTelefono(personaDetails.getTelefono());
		return ResponseEntity.status(HttpStatus.CREATED).body(personaServicios.save(persona.get()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long personaId) {
		if (!personaServicios.findbyid(personaId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		personaServicios.deletebyId(personaId);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Persona> readAll() {
		List<Persona> Personas = StreamSupport.stream(personaServicios.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Personas;
	}

}
