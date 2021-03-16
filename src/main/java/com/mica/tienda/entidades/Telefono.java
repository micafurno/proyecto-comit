
package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Telefono implements Serializable {
	private static final Long SerialVersionUID = 1L;

	@Id
	private Integer codArea;
	@Id
	private Integer numero;
	private Boolean isCelular = false;
	
}
