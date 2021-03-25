package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Producto implements Serializable {
	private static final Long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codigo;

	private String nombreProducto;

	private String descripcion;

	private String color;

	private Integer precioUnitario;

	private Integer stock;

	public Producto() {

	}

	public Producto(Long id, String codigo, String nombreProducto, String descripcion, String color,
			Integer precioUnitario, Integer stock) {
		this.id = id;
		this.codigo = codigo;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.color = color;
		this.precioUnitario = precioUnitario;
		this.stock = stock;
	}

}
