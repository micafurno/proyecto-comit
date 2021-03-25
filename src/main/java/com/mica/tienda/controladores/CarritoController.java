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

import com.mica.tienda.entidades.Carrito;
import com.mica.tienda.servicios.CarritoServicios;

@RestController
@RequestMapping("/api/carritos")
public class CarritoController {

	@Autowired
	private CarritoServicios carritoServicios;

	/*
	 * @PostMapping(value = "/") public ResponseEntity<Carrito>
	 * nuevoCarrito(@RequestBody Persona per){
	 * 
	 * Carrito carrito = new Carrito(); carrito.setPersona(per);
	 * carritoServicios.saveAndFlush(carrito); return ResponseEntity.ok(carrito);
	 * 
	 * }
	 */

	@PostMapping(value = "/")
	public Carrito save(@RequestBody Carrito carrito) {
		return this.carritoServicios.save(carrito);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long carritoId) {
		Optional<Carrito> oCarrito = carritoServicios.findbyid(carritoId);
		if (!oCarrito.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oCarrito);
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Carrito carritoDetails, @PathVariable Long carritoId) {
		Optional<Carrito> carrito = carritoServicios.findbyid(carritoId);
		if (!carrito.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		carrito.get().setId(carritoDetails.getId());
		carrito.get().setPersona(carritoDetails.getPersona());
		carrito.get().setPrecioTotal(carritoDetails.getPrecioTotal());
		carrito.get().setProductos(carritoDetails.getProductos());
		return ResponseEntity.status(HttpStatus.CREATED).body(carritoServicios.save(carrito.get()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long carritoId) {
		if (!carritoServicios.findbyid(carritoId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		carritoServicios.deletebyId(carritoId);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Carrito> readAll() {
		List<Carrito> Carritos = StreamSupport.stream(carritoServicios.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Carritos;
	}

}
