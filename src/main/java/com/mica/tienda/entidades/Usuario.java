package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Usuario extends Persona implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String usuario;
	private String contraseña;
	private String direccion;
	private String provincia;
	private String localidad;
	private String codigoPostal;

	
}
