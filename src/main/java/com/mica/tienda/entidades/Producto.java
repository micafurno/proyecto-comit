package com.mica.tienda.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table (name = "Productos")
public class Producto implements Serializable{
	private static final Long SerialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	public void mostrarProducto() {
	System.out.println("Codigo: "+codigo);
	System.out.println("Producto: "+nombreProducto);
	System.out.println("Precio: $"+precioUnitario);
	}
}

