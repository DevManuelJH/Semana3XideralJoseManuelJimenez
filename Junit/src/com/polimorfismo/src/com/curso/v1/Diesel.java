package com.polimorfismo.src.com.curso.v1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Diesel extends CobroCombustible { // La clase Diesel hereda de la clase CobroCombustible

	
	// Dentro del constructor de Diesel llamamos a los atributos heredados por la
	// clase padre con super
	public Diesel(BigDecimal litrosCombustible, BigDecimal pagoCombustible,
			String fechaCompraCombustible) {

		super(litrosCombustible, pagoCombustible, pagoCombustible, fechaCompraCombustible);
	}


	// sobreescribimos el metodo cobrar declarado en la interfaz, si bien esta clase
	// no implementa directamente
	// la interfaz, si es posible heredar este metodo ya que hereda de la clase
	// padre, donde nuestra interfaz si
	// esta implentada
	@Override
	public String cobrar() {
		BigDecimal total = litrosCombustible.multiply(precioCombustible);
		BigDecimal cambio = pagoCombustible.subtract(total);
		int resultado = total.compareTo(pagoCombustible);
		if (resultado > 0) {
			System.out.println("______________________________________");
			return "¡CREDITO INSUFICIENTE <<COMPRA CANCELADA>>";
		} else {
			return "¡GRACIAS POR SU COMPRA!";

		}
	}
}
