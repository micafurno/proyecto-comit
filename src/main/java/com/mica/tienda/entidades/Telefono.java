
package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Telefono implements Serializable {
	private static final Long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer codArea;
	private Integer numero;

	public Telefono() {
	}

	public Telefono(Long id, Integer codArea, Integer numero) {
		this.id = id;
		this.codArea = codArea;
		this.numero = numero;
	}

}
