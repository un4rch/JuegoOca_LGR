package org.pmoo.proyecto;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class FichaTest {

	Ficha fichAct;

	@Before
	public void setUp() throws Exception {
		System.out.println("Por favor, ingrese un 1 cuando se le pida el tablero y 2 cuando se pida el nº de jugadores");
		Juego.getJuego().configurarTablero();
		fichAct = new Ficha("Ficha de prueba");
	}

	@After
	public void tearDown() throws Exception {
		ListaCasillas.getListaCasillas().resetearTablero();
		fichAct = null;
	}

	@Test
	public void test() {

	}
}
