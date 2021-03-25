package com.mica.tienda.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Carrito implements Serializable {
	private static final Long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany
	private List<Producto> productos = new ArrayList<>();
	private Integer precioTotal = 0;
	@OneToOne(cascade = CascadeType.ALL)
	private Persona persona;

	public Carrito() {

	}

	public Carrito(Long id, List<Producto> productos, Integer precioTotal, Persona persona) {
		this.id = id;
		this.productos = productos;
		this.precioTotal = precioTotal;
		this.persona = persona;
	}

}
