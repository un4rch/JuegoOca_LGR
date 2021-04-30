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
		/*  JUnit 7 : Al tirar el dado caer en una Oca, avanzar a la casilla de Victoria y ganar. 
		El boolean de la Ficha heGandado pasa a True. Se imprime por pantalla un texto que indica que el jugador ha sido ganador,  y finaliza el juego. */
		
	    fichAct = new Ficha("Ficha de prueba");
		fichAct.sobreescribirPosicion(55);
		System.out.println("Por favor, ingrese un 4 por el teclado.");
		fichAct.jugar();
		assertEquals(fichAct.getPosicion(),63);
		assertEquals(fichAct.getHeGanado(),true);
		
		
		
	/* JUnit 8: Al tirar el dado caer en una Oca, al volver a tirar caer en otra Oca. 
		Se desplaza a la siguiente Oca, vuelve a tirar el dado, cumple la función de la casilla en la que caiga, imprime un mensaje por pantalla y finaliza su turno.*/
		
		fichAct = new Ficha("Ficha de prueba");
		fichAct.sobreescribirPosicion(3);
		System.out.println("Por favor, ingrese en orden, un 2 y un 6 por el teclado.");
		fichAct.jugar();
		assertEquals(fichAct.getPosicion(),15);

		    
		    
	/* JUnit 9: Al tirar el dado caer en una Oca, al volver a tirar caer en los Dados. ASCENDENTE
		Se desplaza a los otros Dados, vuelve a tirar el dado, cumple la función de la casilla en la que caiga, imprime un mensaje por pantalla y finaliza su turno.*/
		
		fichAct = new Ficha("Ficha de prueba");
		fichAct.sobreescribirPosicion(15);
		System.out.println("Por favor, ingrese en orden, un 3 , un 3 y un 4 por el teclado.");
		fichAct.jugar();
		assertEquals(fichAct.getPosicion(),57);

		
		
	/* JUnit 9': Al tirar el dado caer en una Oca, al volver a tirar caer en los Dados. DESCENDENTE
		Se desplaza a los otros Dados, vuelve a tirar el dado, cumple la función de la casilla en la que caiga, imprime un mensaje por pantalla y finaliza su turno.*/
		
		fichAct = new Ficha("Ficha de prueba");
		fichAct.sobreescribirPosicion(43);
		System.out.println("Por favor, ingrese en orden, un 2 , un 3 y un 4 por el teclado.");
		fichAct.jugar();
		assertEquals(fichAct.getPosicion(),30);	
		
		
		
	/* JUnit 10: Al tirar el dado caer en una Oca, al volver a tirar caer en el Puente.  DESCENDENTE
		Se desplaza a la otra casilla Puente, vuelve a tirar el dado, cumple la función de la casilla en la que caiga, imprime un mensaje por pantalla y finaliza su turno.*/
		
		fichAct = new Ficha("Ficha de prueba");
		fichAct.sobreescribirPosicion(1);
		System.out.println("Por favor, ingrese en orden, un 4 un 3 y un 4 por el teclado.");
		fichAct.jugar();
		assertEquals(fichAct.getPosicion(),10);	
		
				
		
	/*  JUnit 11: Al tirar el dado caer en una Oca, al volver a tirar caer en la Pensión. 
		Se muestra un mensaje por pantalla indicando la situación y se le aumenta al jugador sus turnos de espera en 1.*/
		
		fichAct = new Ficha("Ficha de prueba");
		fichAct.sobreescribirPosicion(3);
		System.out.println("Por favor, ingrese en orden, un 6 y un 5 por el teclado.");
		fichAct.jugar();
		assertEquals(fichAct.getPosicion(),19);	
		assertEquals(fichAct.getTurnosEspera(),1);
		
		
		
	/*  JUnit 12: Al tirar el dado caer en una Oca, al volver a tirar caer en la Cárcel. 
		Se cambiará el atributo de turnosEspera de la ficha en 3, imprime un mensaje por pantalla y finaliza su turno.*/
		
		fichAct = new Ficha("Ficha de prueba");
		fichAct.sobreescribirPosicion(39);
		System.out.println("Por favor, ingrese en orden, un 6 y un 6 por el teclado.");
		fichAct.jugar();
		assertEquals(fichAct.getPosicion(),56);	
		assertEquals(fichAct.getTurnosEspera(),3);
		
		
		
	/*  JUnit 13: Al tirar el dado caer en una Oca, al volver a tirar caer en el Pozo.
		Se cambiará el atributo de turnosEspera de la ficha a 2, imprime un mensaje por pantalla y finaliza su turno.*/
		
		fichAct = new Ficha("Ficha de prueba");
		fichAct.sobreescribirPosicion(17);
		System.out.println("Por favor, ingrese en orden, un 6 y un 4 por el teclado.");
		fichAct.jugar();
		assertEquals(fichAct.getPosicion(),31);	
		assertEquals(fichAct.getTurnosEspera(),2);
		
		
		
	/*  JUnit 14: Al tirar el dado caer en una Oca, al volver a tirar caer en la Muerte.
		El jugador volverá a la primera casilla,imprime un mensaje por pantalla y finaliza su turno.*/

		fichAct = new Ficha("Ficha de prueba");
		fichAct.sobreescribirPosicion(46);
		System.out.println("Por favor, ingrese en orden, un 4 y un 4 por el teclado.");
		fichAct.jugar();
		assertEquals(fichAct.getPosicion(),1);	


		
	/*  JUnit 15: Al tirar el dado caer en un Puente, al volver a tirar caer en una Oca. ASENDENTE
		Se desplaza a la siguiente Oca, vuelve a tirar el dado, cumple la función de la casilla en la que caiga, imprime un mensaje por pantalla y finaliza su turno.*/
		
		fichAct = new Ficha("Ficha de prueba");
		fichAct.sobreescribirPosicion(1);
		System.out.println("Por favor, ingrese en orden, un 5 , un 6 y un 5 por el teclado.");
		fichAct.jugar();
		assertEquals(fichAct.getPosicion(),28);	
		
		
		
	/*  JUnit 16: Al tirar el dado caer en un Puente, al volver a tirar caer en los Dados. 
	    !! EL DADO DEBERÍA SACAR 14 en tablero clásico
		Se desplaza a los otros Dados, vuelve a tirar el dado, cumple la función de la casilla en la que caiga, imprime un mensaje por pantalla y finaliza su turno.*/
		
		
	/*  JUnit 17: Al tirar el dado caer en un Puente, al volver a tirar caer en otro Puente.
		Se desplaza a la otra casilla Puente, vuelve a tirar el dado, cumple la función de la casilla en la que caiga, imprime un mensaje por pantalla y finaliza su turno.*/
		
		fichAct = new Ficha("Ficha de prueba");
		fichAct.sobreescribirPosicion(10);
		System.out.println("Por favor, ingrese en orden, un 2 , un 6 y un 5 por el teclado.");
		fichAct.jugar();
		assertEquals(fichAct.getPosicion(),11);	
		
		
		
	/*  JUnit 18: Al tirar el dado caer en un Puente, al volver a tirar caer en la Posada.
	    !! EL DADO DEBERÍA SACAR 7 en tablero clásico
		Se cambiará el atributo de turnosEspera de la ficha a 1, imprime un mensaje por pantalla y finaliza su turno.*/
		
		
	/*  JUnit 19: Al tirar el dado caer en un Puente, al volver a tirar caer en la Cárcel.
		!! EL DADO DEBERÍA SACAR 44 en tablero clásico
		Se cambiará el atributo de turnosEspera de la ficha a 3, imprime un mensaje por pantalla y finaliza su turno.*/
		
		
	/*  JUnit 20: Al tirar el dado caer en un Puente, al volver a tirar caer en el Pozo. 
	   !! EL DADO DEBERÍA SACAR 19 en tablero clásico
		Se cambiará el atributo de turnosEspera de la ficha a 2, imprime un mensaje por pantalla y finaliza su turno.*/

		
	/*  JUnit 22 : Al tirar el dado caer en unos Dados, al volver a tirar caer en una Oca. 
		El jugador se desplaza a la siguiente Oca y vuelve a tirar el dado para avanzar, se cumple la función que corresponda a la casilla en su nueva, 
		imprime por pantalla un mensaje indicando todas las casillas en las que ha caído y finaliza su turno.*/

	    fichAct = new Ficha("Ficha de prueba");
	    fichAct.sobreescribirPosicion(24);
	    System.out.println("Por favor, ingrese en orden, un 2, un 1 y un 1 por el teclado.");
	    fichAct.jugar();
	    assertEquals(fichAct.getPosicion(),60);
	    
	    
	    
	/*  JUnit 26 : Al tirar el dado caer en unos Dados, al volver a tirar caer en la Cárcel. 
		Se cambiará el atributo de turnosEspera de la ficha a 3, imprime un mensaje por pantalla y finaliza su turno.*/
	    
	    fichAct = new Ficha("Ficha de prueba");
	    fichAct.sobreescribirPosicion(24);
	    System.out.println("Por favor, ingrese en orden, un 2 y un 3 por el teclado.");
	    fichAct.jugar();
	    assertEquals(fichAct.getTurnosEspera(),3);
	    
	    
	    
	/*  JUnit 27: Al tirar el dado caer en unos Dados, al volver a tirar caer en el Pozo. 
	    Se cambiará el atributo de turnosEspera de la ficha a 2, imprime un mensaje por pantalla y finaliza su turno.*/

	    fichAct = new Ficha("Ficha de prueba");
	    fichAct.sobreescribirPosicion(51);
	    System.out.println("Por favor, ingrese en orden, un 2 y un 5 por el teclado.");
	    fichAct.jugar();
	    assertEquals(fichAct.getTurnosEspera(),2);
	    
	    
	    
	/*  JUnit 28: Al tirar el dado caer en unos Dados, al volver a tirar caer en la Muerte. 
	    El jugador vuelve a la primera casilla, se imprime un mensaje por pantalla indicando en que casillas ha caído y finaliza su turno.*/
	    
	    fichAct = new Ficha("Ficha de prueba");
	    fichAct.sobreescribirPosicion(24);
	    System.out.println("Por favor, ingrese en orden, un 2 y un 5 por el teclado.");
	    fichAct.jugar();
	    assertEquals(fichAct.getPosicion(),1);
	    
	    
	    
	/*  JUnit 29: Al tirar el dado caer en la Muerte. 
		El jugador vuelve a la primera casilla, se imprime un mensaje por pantalla indicando en que casillas ha caído y finaliza su turno.*/
	    
	    fichAct = new Ficha("Ficha de prueba");
	    fichAct.sobreescribirPosicion(52);
	    System.out.println("Por favor, ingrese un 6 por el teclado.");
	    fichAct.jugar();
	    assertEquals(fichAct.getPosicion(),1);
	    
	    
	    
	/*  JUnit 30: Al tirar el dado caer en la Victoria. 
		El boolean de la Ficha heGandado pasa a True. Se imprime por pantalla un texto que indica que el jugador ha sido ganador,  y finaliza el juego.*/ 
	 
	    fichAct = new Ficha("Ficha de prueba");
	    fichAct.sobreescribirPosicion(57);
	    System.out.println("Por favor, ingrese un 6 por el teclado.");
	    fichAct.jugar();
	    assertEquals(fichAct.getPosicion(),63);
	    assertEquals(fichAct.getHeGanado(),true);
	   
	    
	   
	/*  JUnit 31: Al tirar el dado caer en la Cárcel. 
	    La ficha del jugador que cae en esta casilla aumenta los turnos de espera a 3 y se imprime por pantalla un texto que indica lo sucedido */
	    
	    fichAct = new Ficha("Ficha de prueba");
	    fichAct.sobreescribirPosicion(51);
	    System.out.println("Por favor, ingrese un 5 por el teclado.");
	    fichAct.jugar();
	    assertEquals(fichAct.getTurnosEspera(),3);
	    
	    
	    
	/*  JUnit 32: Al tirar el dado caer en el Pozo. 
	    La ficha del jugador que cae en esta casilla aumenta los turnos de espera a 2 y se imprime por pantalla un texto que indica lo sucedido*/

	    fichAct = new Ficha("Ficha de prueba");
	    fichAct.sobreescribirPosicion(30);
	    System.out.println("Por favor, ingrese un 1 por el teclado.");
	    fichAct.jugar();
	    assertEquals(fichAct.getTurnosEspera(),2);
	    
	    

	/*  JUnit 33: Al tirar el dado caer en la Posada. 
	    La ficha del jugador que cae en esta casilla aumenta los turnos de espera a 1 y se imprime por pantalla un texto que indica lo sucedido*/
	  
	    fichAct = new Ficha("Ficha de prueba");
	    fichAct.sobreescribirPosicion(17);
	    System.out.println("Por favor, ingrese un 2 por el teclado.");
	    fichAct.jugar();
	    assertEquals(fichAct.getTurnosEspera(),1);
	        
	    

	/*  JUnit 34:Tirar el dado cerca de la casilla Victoria y pasarse del valor necesario. 
	    La ficha del jugador rebota en la última casilla y retrocede tantas casillas como números hasta cubrir el valor obtenido del dado (retrodecer)*/

	    fichAct = new Ficha("Ficha de prueba");
	    fichAct.sobreescribirPosicion(62);
	    System.out.println("Por favor, ingrese un 3 por el teclado.");
	    fichAct.jugar();
	    assertEquals(fichAct.getPosicion(),61);
	    assertEquals(fichAct.getHeGanado(),false);
	}
 
}
