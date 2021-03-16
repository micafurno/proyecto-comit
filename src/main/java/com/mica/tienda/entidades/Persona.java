package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javassist.SerialVersionUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
@ToString
@Entity
@Table(name = "personas")
public class Persona implements Serializable {
	private static final Long SerialVersionUID = 1L;

	@Id
	private Long Id;
	
	private String nombre;
	private String apellido;
	private String email;
	private int dni;
	
}
