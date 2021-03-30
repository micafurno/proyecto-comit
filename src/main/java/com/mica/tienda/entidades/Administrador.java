package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@DiscriminatorValue("ADMINISTRADOR")
public class Administrador extends Persona implements Serializable {
	private static final Long SerialVersionUID = 1L;

	public Administrador() {
	}

}
