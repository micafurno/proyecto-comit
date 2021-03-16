package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Id;

public class Item extends Producto implements Serializable{
	
	@Id
	private Long id;

}
