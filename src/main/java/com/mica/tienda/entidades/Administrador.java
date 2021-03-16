package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Administrador implements Serializable {
	
	@Id
	private Long id;

}
