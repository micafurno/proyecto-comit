package com.mica.tienda;

import com.mica.tienda.entidades.Persona;
import com.mica.tienda.entidades.Producto;

public class MainApplication {

	public static void main(String[] args) {
		
		Persona per = Persona.builder()
				.setApellido("Furno")
				.setNombre("Micaela")
				.setEmail("miqui.furno@gmail.com")
				.setDni(39393999)
				.build();

		Producto prod = Producto.builder()
								.setCodigo("S16")
								.setNombreProducto("Krishna Leela")
								.setPrecioUnitario(460)
								.setStock(5)
								.build();
		
System.out.println(per.toString());
System.out.println(prod.toString());


	}
	
	
	

}
