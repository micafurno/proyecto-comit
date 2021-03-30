package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("USUARIO")
public class Usuario extends Persona implements Serializable {
	private static final Long SerialVersionUID = 1L;

	private String usuario;

	private String contraseña;

	private String direccion;

	private String provincia;

	private String localidad;

	private String codigoPostal;

	public Usuario() {
	}

	public Usuario(String usuario, String contraseña, String direccion, String provincia, String localidad,
			String codigoPostal) {

		this.usuario = usuario;
		this.contraseña = contraseña;
		this.direccion = direccion;
		this.provincia = provincia;
		this.localidad = localidad;
		this.codigoPostal = codigoPostal;
	}

}
