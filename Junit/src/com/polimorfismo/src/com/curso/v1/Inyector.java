package com.polimorfismo.src.com.curso.v1;

import java.math.BigDecimal;

public class Inyector {
	
	//Se implemento el uso de un inyector de dependencias para asi evitar crear un objeto de tipo precio cada que se 
	//crea un nuevo pedido, con esto, se inyecta el precio segun el combustible elegido en la clase principal
	
	public static void inyectarPrecio(CobroCombustible tipo, BigDecimal precio) {
		tipo.precioCombustible = precio;
		
		
	}

}
