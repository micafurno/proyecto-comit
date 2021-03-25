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

import com.mica.tienda.entidades.Producto;
import com.mica.tienda.servicios.ProductoServicios;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoServicios productoServicios;

	/*
	 * @PostMapping(value = "/") public ResponseEntity<Producto>
	 * nuevoProducto(@RequestBody Persona per){
	 * 
	 * Producto producto = new Producto(); producto.setPersona(per);
	 * productoServicios.saveAndFlush(producto); return ResponseEntity.ok(producto);
	 * 
	 * }
	 */

	@PostMapping(value = "/")
	public Producto save(@RequestBody Producto producto) {
		return this.productoServicios.save(producto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long productoId) {
		Optional<Producto> oProducto = productoServicios.findbyid(productoId);
		if (!oProducto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oProducto);
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Producto productoDetails, @PathVariable Long productoId) {
		Optional<Producto> producto = productoServicios.findbyid(productoId);
		if (!producto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		producto.get().setId(productoDetails.getId());
		producto.get().setCodigo(productoDetails.getCodigo());
		producto.get().setNombreProducto(productoDetails.getNombreProducto());
		producto.get().setDescripcion(productoDetails.getDescripcion());
		producto.get().setColor(productoDetails.getColor());
		producto.get().setPrecioUnitario(productoDetails.getPrecioUnitario());
		producto.get().setStock(productoDetails.getStock());

		return ResponseEntity.status(HttpStatus.CREATED).body(productoServicios.save(producto.get()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long productoId) {
		if (!productoServicios.findbyid(productoId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productoServicios.deletebyId(productoId);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Producto> readAll() {
		List<Producto> Productos = StreamSupport.stream(productoServicios.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Productos;
	}
}
