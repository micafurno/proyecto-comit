package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carrito implements Serializable{
	private static final Long SerialVersionUID = 1L;

	@Id
	private Long id;
	
	private String codigo;
	private int precioTotal;
}
