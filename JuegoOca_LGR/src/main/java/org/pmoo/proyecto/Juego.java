package org.pmoo.proyecto;

import java.lang.Integer;
import java.lang.Thread;
import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

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
        ListaCasillas listaCasillas = ListaCasillas.getListaCasillas();
        
        System.out.println(ansi().fg(WHITE).a("Numero de Jugadores posibles:\n").reset());
        System.out.println(ansi().fg(WHITE).a("\t(1) Un Jugador.").reset());
        System.out.println(ansi().fg(WHITE).a("\t(2) Dos Jugadores.").reset());
        System.out.println(ansi().fg(WHITE).a("\t(3) Tres Jugadores.").reset());
        System.out.println(ansi().fg(WHITE).a("\t(4) Cuatro Jugadores.\n").reset());
        System.out.print(ansi().fg(CYAN).a("¿Cuantos jugadores van ha jugar?").reset());
        int numJugadores = teclado.pedirOpcion(4);
        
        for (int i=1; i<=numJugadores; i++) {
            ListaFichas.getListaFichas().anadirFicha(new Ficha("Jugador" + i));
        }
        
        System.out.println(ansi().fg(WHITE).a("\nModos de juego:\n").reset());
        System.out.println(ansi().fg(WHITE).a("\t(1) Tablero Clasico.").reset());
        System.out.println(ansi().fg(WHITE).a("\t(2) Tablero Personalizado.\n").reset());
        System.out.print(ansi().fg(CYAN).a("¿Que modo de juego deseas jugar?").reset());
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
                if (data[0].equals("Muerte")) {
                    listaCasillas.anadirCasilla(new Muerte("Has caido en la Muerte e iras de vuelta al Inicio"));
                } else if (data[0].equals("Oca")) {
                    listaCasillas.anadirCasilla(new DesplazarYTirar("De oca a oca y tiro porque me toca", Integer.parseInt(data[1])));
                } else if (data[0].equals("Puente")) {
                    listaCasillas.anadirCasilla(new DesplazarYTirar("De puente a puente y tiro porque me lleva la corriente", Integer.parseInt(data[1])));
                } else if (data[0].equals("Dado")) {
                    listaCasillas.anadirCasilla(new DesplazarYTirar("De dado a dado y tiro porque me ha tocado", Integer.parseInt(data[1])));
                } else if (data[0].equals("Carcel")) {
                    listaCasillas.anadirCasilla(new Espera("Has caido en la carcel y tendrás que esperar 3 turnos", Integer.parseInt(data[1])));
                } else if (data[0].equals("Pension")) {
                    listaCasillas.anadirCasilla(new Espera("Has caido en la pension y tendras que esperar 1 turno", Integer.parseInt(data[1])));
                } else if (data[0].equals("Pozo")) {
                    listaCasillas.anadirCasilla(new Espera("Has caido en el pozo y tendras que esperar 2 turnos", Integer.parseInt(data[1])));
                } else if (data[0].equals("Victoria")) {
                    listaCasillas.anadirCasilla(new Victoria("Has caido en la victoria, felicidades, has ganado"));
                } else {
                    listaCasillas.anadirCasilla(new Normal("Has caido en una casilla normal, no ocurre nada"));
                }
            }
            fileReader.close();
            System.out.println();
            System.out.println(ansi().fg(GREEN).a("[*] ¡Tablero creado con exito!").reset());
            Thread.sleep(1500);
        } catch (Exception e) {
            
        }
    }
    
    public void jugarPartida() {
    	System.out.println(ansi().fg(BLUE).a(""));
        System.out.println("\t\t\t\t\t\t __                   _____                      ");
        System.out.println("\t\t\t\t\t\t/\\ \\                 /\\  __`\\                    ");
        System.out.println("\t\t\t\t\t\t\\ \\ \\         __     \\ \\ \\/\\ \\    ___     __     ");
        System.out.println("\t\t\t\t\t\t \\ \\ \\  __  /'__`\\    \\ \\ \\ \\ \\  /'___\\ /'__`\\   ");
        System.out.println("\t\t\t\t\t\t  \\ \\ \\L\\ \\/\\ \\L\\.\\_   \\ \\ \\_\\ \\/\\ \\__//\\ \\L\\.\\_ ");
        System.out.println("\t\t\t\t\t\t   \\ \\____/\\ \\__/.\\_\\   \\ \\_____\\ \\____\\ \\__/.\\_\\");
        System.out.println("\t\t\t\t\t\t    \\/___/  \\/__/\\/_/    \\/_____/\\/____/\\/__/\\/_/");
        System.out.println(ansi().fg(BLUE).a("\n\n").reset());
        
        System.out.println("Bienvenidos al juego de La Oca, antes de comenzar a jugar haremos unas pequeñas configuraciones...\n");
        
        this.configurarTablero();
        ListaFichas.getListaFichas().jugar();
    }
    /**
     * Metodo principal del juego, aqui es donde comienza todo la partida.
     */
    public static void main(String[] args) {
    	ListaFichas.getListaFichas().limpiarConsola();
        Juego.getJuego().jugarPartida();
    }

}
