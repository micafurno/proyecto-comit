package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public abstract class Persona implements Serializable {
	private static final Long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String nombre;

	private String apellido;

	private String email;

	private Integer dni;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Telefono telefono;

	public Persona() {

	}

	public Persona(Long id, String nombre, String apellido, String email, Integer dni, Telefono telefono) {
		Id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.dni = dni;
		this.telefono = telefono;
	}

}
