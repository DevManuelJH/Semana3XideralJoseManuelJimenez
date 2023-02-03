package com.polimorfismo.src.com.curso.Test;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import org.junit.Test;

import com.polimorfismo.src.com.curso.v1.Singleton;

public class TestSingleton {

  @Test
  public void testSingletonInstance() {
    Singleton instance1 = Singleton.getInstance();
    Singleton instance2 = Singleton.getInstance();
    assertEquals(instance1, instance2);
  }

  @Test
  public void testSingletonFechaActual() {
    Singleton instance = Singleton.getInstance();
    LocalDate fecha = LocalDate.now();
    fecha = fecha.plusDays(3);
    String fechaEsperada = fecha.toString();
    assertEquals(fechaEsperada, instance.fechaActual);
  }

}
