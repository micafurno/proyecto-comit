package com.mica.tienda;

import com.mica.tienda.entidades.Persona;

public class MainApplication {

	public static void main(String[] args) {
		
		Persona per = Persona.builder()
				.setApellido("Furno")
				.setNombre("Micaela")
				.setEmail("miqui.furno@gmail.com")
				.setDni(39393999)
				.build();
			
System.out.println(per.toString());

	}
	

}
