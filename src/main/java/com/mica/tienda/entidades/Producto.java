package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
@ToString
@Data
@Entity
public class Producto implements Serializable{
	private static final Long SerialVersionUID = 1L;

	
	@Id
	private Long id;
	
	private String codigo;
	private String nombreProducto;
	private String descripcion;
	private String color;
	private int precioUnitario;
	private int stock;
	
	public String getStockDisponible() {
		if (stock > 0) {
			return("Stock disponible");
		}else{
			return("AGOTADO");
		}
	
	}
}

