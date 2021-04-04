package org.pmoo.proyecto;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.Color.WHITE;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Esta es la clase principal del Juego, donde comenzara toda la ejecucion del juego
 * @author: Unai Elorriaga, Ruben Esgueva, Endika Hernandez y Carmela Garcia
 * @version: 1.0.0
 * @see <a href = "https://es.wikipedia.org/wiki/Juego_de_la_oca" />Juego de la Oca</a>
 */
public class Juego {
	private static Juego miJuego = null;
	private static int opcionTablero;
	/**
	 * Constructora de Juego.
	 */
	private Juego() {
		
	}
	/**
	 * @return Devuelve la unica instancia de Juego.
	 */
	public static Juego getJuego() {
		if (Juego.miJuego == null) {
			Juego.miJuego = new Juego();
		}
		return Juego.miJuego;
	}
	/**
	 * Limpia la consola de comandos o shell (clear screen).
	 */
	public void limpiarConsola() {
		try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (Exception e) {}
	}
	/**
	 * Termina la partida saliendo del juego por completo.
	 */
	public void terminarPartida() {
		System.exit(0);
	}
	/**
	 * @return Devuelve el numero seleccionado de la tematica del tablero.
	 */
	public static int getOpcionTablero() {
		return Juego.opcionTablero;
	}
	/**
	 * Configura el tablero en funcion de un numero de jugadores y una tematica de tablero, los cuales el usuario escogera por consola.
	 */
	public void configurarTablero() {
		Teclado teclado = Teclado.getTeclado();
		
		System.out.println(ansi().fg(WHITE).a("Numero de Jugadores posibles:\n").reset());
		System.out.println(ansi().fg(WHITE).a("\t(1) Dos Jugadores.").reset());
		System.out.println(ansi().fg(WHITE).a("\t(2) Tres Jugadores.").reset());
		System.out.println(ansi().fg(WHITE).a("\t(3) Cuatro Jugadores.\n").reset());
		System.out.print(ansi().fg(WHITE).a("¿Cuantos jugadores van ha jugar?").reset());
		int numJugadores = teclado.pedirOpcion(3)+1;
		
		for (int i=1; i<=numJugadores; i++) {
			ListaFichas.añadirFicha(new Ficha("Jugador" + i));
		}
		
		System.out.println(ansi().fg(WHITE).a("Modos de juego:\n").reset());
		System.out.println(ansi().fg(WHITE).a("\t(1) Tablero Clasico.").reset());
		System.out.println(ansi().fg(WHITE).a("\t(2) Tablero Personalizado.\n").reset());
		System.out.print(ansi().fg(WHITE).a("¿Que modo de juego deseas jugar?").reset());
		Juego.opcionTablero = teclado.pedirOpcion(2);
		
		try {
			BufferedReader fileReader = null;
			if (Juego.opcionTablero == 1) {
				fileReader = new BufferedReader(new FileReader("./tableros/TableroClasico.txt"));
			} else if (Juego.opcionTablero == 2) {
				fileReader = new BufferedReader(new FileReader("./tableros/TableroPersonalizado.txt"));
			}
			String strCurrentLine;
			while ((strCurrentLine = fileReader.readLine()) != null) {    
                String data[] = strCurrentLine.split("_");
                if (data[1] == "Muerte") {
                	ListaCasillas.añadirCasilla(new CasillaMuerte());
                } else if (data[1] == "Oca") {
                	ListaCasillas.añadirCasilla(new CasillaDesplazarYTirar(data[2]));
                } else if (data[1] == "Puente") {
                	ListaCasillas.añadirCasilla(new CasillaDesplazarYTirar(data[2]));
                } else if (data[1] == "Dado") {
                	ListaCasillas.añadirCasilla(new CasillaDesplazarYTirar(data[2]));
                } else if (data[1] == "Carcel") {
                	ListaCasillas.añadirCasilla(new CasillaEspera(data[2]));
                } else if (data[1] == "Pension") {
                	ListaCasillas.añadirCasilla(new CasillaEspera(data[2]));
                } else if (data[1] == "Pozo") {
                	ListaCasillas.añadirCasilla(new CasillaEspera(data[2]));
                } else {
                	ListaCasillas.añadirCasilla(new CasillaNormal());
                }
            }
			fileReader.close();
            Thread.sleep(1000);
            System.out.println();
            System.out.println(ansi().fg(GREEN).a("[\u2713] ¡Tablero creado con exito!").reset());
		} catch (Exception e) {
			
		}
	}
	
	private void jugarPartida() {
		this.configurarTablero();
		ListaFichas.jugar();
	}
	/**
	 * Metodo principal del juego, aqui es donde comienza todo la partida.
	 */
	public static void main(String[] args) {

	}

}
