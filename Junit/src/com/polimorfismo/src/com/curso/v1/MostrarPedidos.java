package com.polimorfismo.src.com.curso.v1;

import java.util.ArrayList;

//aplicacion de polimorfismo, al ser generarPedidos un metodo recurrente, no tiene caso crear uno para cada
//operacion, en este caso creamos una clase que alberga nuestro metodo generaPedido que sera llamada y reutilizado
//las veces que sea necesario.

public class MostrarPedidos {
	static void generarPedido(ArrayList<CobroCombustible> lista) {//creamos el metodo static de tipo Arraylist
		
		for (int x=0;x <lista.size();x++) { //Este ciclo nos permitira recorres el arreglo
			
			CobroCombustible cobro = lista.get(x); //creamos una referencia de tipo CobroCombustible y le pasamos la lista
			System.out.println("REGISTRO DE ORDEN NUMERO..." +(x+1)); //Indicara el numero de orden
			System.out.println(cobro); //Nos mostrara la lista
			System.out.println(cobro.cobrar()); //Ejecutara el metodo sobre escrito cobrar segun el tipo de combustible
			
		}
	}

}
