package com.polimorfismo.src.com.curso.v1;
//creamos una interfas para unicamente declarar los metodos que vamos a sobreescribir en el sistema
public interface ICobroCombustible {
	//Declaramos el metodo cobrar, que sera usado para todas las clase que sean contenedor de un tipo de
	//combustible, Diesel, Magna y premium
	String cobrar();
	
}
