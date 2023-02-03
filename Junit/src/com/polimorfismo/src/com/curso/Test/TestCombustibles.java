package com.polimorfismo.src.com.curso.Test;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.Test;

import com.polimorfismo.src.com.curso.v1.CobroCombustible;
import com.polimorfismo.src.com.curso.v1.Diesel;
import com.polimorfismo.src.com.curso.v1.Inyector;

public class TestCombustibles {
    
	@Test
    public void testCobrarCreditoInsuficiente() {
        BigDecimal litrosCombustible = new BigDecimal(10);
        BigDecimal pagoCombustible = new BigDecimal(500);
        String fechaCompraCombustible = "02-02-2023";
        CobroCombustible diesel = new Diesel(litrosCombustible, pagoCombustible, fechaCompraCombustible);
        Inyector.inyectarPrecio(diesel, new BigDecimal(23.63));
        String result = diesel.cobrar();

        assertEquals("¡CREDITO INSUFICIENTE <<COMPRA CANCELADA>>", result);
    }

    @Test
    public void testCobrarCreditoSuficiente() {
        BigDecimal litrosCombustible = new BigDecimal(10);
        BigDecimal pagoCombustible = new BigDecimal(500);
        String fechaCompraCombustible = "02-02-2023";
        CobroCombustible diesel = new Diesel(litrosCombustible, pagoCombustible, fechaCompraCombustible);
        Inyector.inyectarPrecio(diesel, new BigDecimal(23.63));
        String result = diesel.cobrar();

        assertEquals("¡GRACIAS POR SU COMPRA!", result);
    }
}

