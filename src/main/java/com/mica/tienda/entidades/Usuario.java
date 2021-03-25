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
public class Usuario extends Persona implements Serializable {
	private static final Long SerialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String usuario;

	private String contraseña;

	private String direccion;

	private String provincia;

	private String localidad;

	private String codigoPostal;

	public Usuario() {
	}

	public Usuario(Long id, String usuario, String contraseña, String direccion, String provincia, String localidad,
			String codigoPostal) {
		this.id = id;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.direccion = direccion;
		this.provincia = provincia;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
	}

}
