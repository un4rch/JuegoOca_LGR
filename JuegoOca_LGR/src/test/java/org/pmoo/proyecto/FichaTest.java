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
	
	

	
    Ficha fichAct = new Ficha("Ficha de prueba");       

    fichAct.sobreescribirPosicion(24);
    System.out.println("Por favor, ingrese en orden, un 2, un 1 y un 1 por el teclado.");
    fichAct.jugar();
    assertEquals(fichAct.getPosicion(),60);
    
    fichAct = new Ficha("Ficha de prueba");
    fichAct.sobreescribirPosicion(24);
    System.out.println("Por favor, ingrese en orden, un 2 y un 3 por el teclado.");
    fichAct.jugar();
    assertEquals(fichAct.getTurnosEspera(),3);
    
    fichAct = new Ficha("Ficha de prueba");
    fichAct.sobreescribirPosicion(51);
    System.out.println("Por favor, ingrese en orden, un 2 y un 5 por el teclado.");
    fichAct.jugar();
    assertEquals(fichAct.getTurnosEspera(),2);
    
    fichAct = new Ficha("Ficha de prueba");
    fichAct.sobreescribirPosicion(24);
    System.out.println("Por favor, ingrese en orden, un 2 y un 5 por el teclado.");
    fichAct.jugar();
    assertEquals(fichAct.getPosicion(),1);
    
    fichAct = new Ficha("Ficha de prueba");
    fichAct.sobreescribirPosicion(51);
    System.out.println("Por favor, ingrese un 5 por el teclado.");
    fichAct.jugar();
    assertEquals(fichAct.getTurnosEspera(),3);
    
    fichAct = new Ficha("Ficha de prueba");
    fichAct.sobreescribirPosicion(30);
    System.out.println("Por favor, ingrese un 1 por el teclado.");
    fichAct.jugar();
    assertEquals(fichAct.getTurnosEspera(),2);
    
    fichAct = new Ficha("Ficha de prueba");
    fichAct.sobreescribirPosicion(17);
    System.out.println("Por favor, ingrese un 2 por el teclado.");
    fichAct.jugar();
    assertEquals(fichAct.getTurnosEspera(),1);
    
    fichAct = new Ficha("Ficha de prueba");
    fichAct.sobreescribirPosicion(62);
    System.out.println("Por favor, ingrese un 3 por el teclado.");
    fichAct.jugar();
    assertEquals(fichAct.getPosicion(),61);
    assertEquals(fichAct.getHeGanado(),false);


}
