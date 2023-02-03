package com.polimorfismo.src.com.curso.v1;

import java.math.BigDecimal;
import java.util.ArrayList;
/*El siguiente programa, emula el sistema de una gasolinera, que como resultado final, nos dara una lista
 * de todos los tickets generados a los largo del día*/
public class Principal {


	public static void main(String[] args) {
		
		
		Singleton fecha = Singleton.getInstance(); //instanciamos una variable de tipo singleton para poder acceder a nuestro singleton
		ArrayList<CobroCombustible> listaPedidos = new ArrayList<>();//declaramos un lista de tipo ArrayList
		//le agregamos a la lista los objetos creados que pueden ser de 3 tipos
        CobroCombustible diesel = new Diesel(new BigDecimal(10), new BigDecimal(500), fecha.fechaActual);
        CobroCombustible magna = new GasolinaMagna(new BigDecimal(10), new BigDecimal(500), fecha.fechaActual);
        CobroCombustible premium = new GasolinaPremium(new BigDecimal(10), new BigDecimal(100), fecha.fechaActual);
        
		listaPedidos.add(diesel);
		listaPedidos.add(magna);
		listaPedidos.add(premium);
		listaPedidos.add(diesel);
		
		
        //Aqui se manda a llamar el metodo de nuestra clase inyector, que recibe una referencia de tipo CobroCombustible
		//Y segun la referencia seleccionada inyecta el precio que solo se modifica una vez y asi se ahorra espacio en memoria

		
		//precios gasolina
		
		Inyector.inyectarPrecio(magna, new BigDecimal(19.80));
		Inyector.inyectarPrecio(premium, new BigDecimal(21.33));
		
		//invocamos nuestro metodo para mostrar lista
		//se manda a llamar directo de la clase ya que es un metodo estatico
		MostrarPedidos.generarPedido(listaPedidos);
		
	}
	
}
