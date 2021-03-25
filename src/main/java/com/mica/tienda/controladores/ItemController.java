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

import com.mica.tienda.entidades.Item;
import com.mica.tienda.servicios.ItemServicios;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private ItemServicios itemServicios;

	/*
	 * @PostMapping(value = "/") public ResponseEntity<Item> nuevoItem(@RequestBody
	 * Persona per){
	 * 
	 * Item item = new Item(); item.setPersona(per);
	 * itemServicios.saveAndFlush(item); return ResponseEntity.ok(item);
	 * 
	 * }
	 */

	@PostMapping(value = "/")
	public Item save(@RequestBody Item item) {
		return this.itemServicios.save(item);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long itemId) {
		Optional<Item> oItem = itemServicios.findbyid(itemId);
		if (!oItem.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oItem);
	}

	@PostMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Item itemDetails, @PathVariable Long itemId) {
		Optional<Item> item = itemServicios.findbyid(itemId);
		if (!item.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		item.get().setId(itemDetails.getId());
		item.get().setCodigo(itemDetails.getCodigo());
		item.get().setNombreProducto(itemDetails.getNombreProducto());
		item.get().setColor(itemDetails.getColor());
		item.get().setDescripcion(itemDetails.getDescripcion());
		item.get().setPrecioUnitario(itemDetails.getPrecioUnitario());
		item.get().setStock(itemDetails.getStock());

		return ResponseEntity.status(HttpStatus.CREATED).body(itemServicios.save(item.get()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long itemId) {
		if (!itemServicios.findbyid(itemId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		itemServicios.deletebyId(itemId);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<Item> readAll() {
		List<Item> Items = StreamSupport.stream(itemServicios.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return Items;
	}

}
