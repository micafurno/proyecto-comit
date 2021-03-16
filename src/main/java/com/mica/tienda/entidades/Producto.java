package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producto implements Serializable{
	private static final Long SerialVersionUID = 1L;

	
	@Id
	private Long id;
	
	private String codigo;
	private String nombreProducto;
	private String descripcion;
	private String color;
	private int precioUnitario;
	private int stock;
}

