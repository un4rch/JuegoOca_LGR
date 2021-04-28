package org.pmoo.proyecto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TecladoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testPedirOpcion() {
		AssertNotNull(Teclado.getTeclado());
		System.out.println("Se va a introducir un valor negativo, después un valor mayor que 4 y finalmente un valor entre 1 y 4");
		Teclado.getTeclado().pedirOpcion(4);
		System.out.println("Se va introducir un valor negativo, después un valor mayor que 2 y finalmente un valor entre 1 y 2");
		Teclado.getTeclado().pedirOpcion(2);
		System.out.println("Se va a introducir un char y después un valor entre uno y dos");
		Teclado.getTeclado().pedirOpcion(2);
		System.out.println("Prueba sobre terminar la partida");
		System.out.println("Esta prueba no se realiza ya que se puede comprobar mucho más facilmente ejecutando directamente el programa");
	}
}
