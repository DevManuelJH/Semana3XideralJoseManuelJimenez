package com.polimorfismo.src.com.curso.v1;

import java.time.LocalDate;

//La razon de este singleton es porque la fecha es una variable que se mantendra siempre igual, entonces
// no tiene sentido crear un objeto nuevo en cada clase

public class Singleton {
	
	//Creamos nuestros atributos de clase
	private static Singleton instance; //en este atributo se nos regresara nuestro singleton
	public static String fechaActual;
	
	//Creamos un metodo que recibira una fecha convertida a string y se la asignara a nuestro singleton
	private Singleton(String fecha) {
		fechaActual = fecha;
		
	}
	//Creamos nuestro metodo get donde se hara toda la operación
	public static Singleton getInstance() {
		LocalDate fecha = LocalDate.now(); //Creamos una variable de tipo fecha que apunte a la fecha actual
		String fechaS = fecha.toString(); // Creamos la variable fechaS y le pasamos el valor toString del objeto de la fecha actual
		if (instance == null) { //preguntamos si la instancia es == null
			instance = new Singleton(fechaS); //si es null a instancia le decimos que apunte al constructor y le pasamos el String fecha
		}
		return instance; //regresamos la instancia ya apuntando a fecha.
		}
	}
	


