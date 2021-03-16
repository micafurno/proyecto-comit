package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item extends Producto implements Serializable{
	
	@Id
	private Long id;

}
