package org.pmoo.proyecto;

import java.lang.Integer;
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
        System.out.print(ansi().fg(WHITE).a("¿Cuantos jugadores van ha jugar?").reset());
        int numJugadores = teclado.pedirOpcion(4);
        
        for (int i=1; i<=numJugadores; i++) {
            ListaFichas.getListaFichas().anadirFicha(new Ficha("Jugador" + i));
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
                if (data[0] == "Muerte") {
                    listaCasillas.anadirCasilla(new Muerte("Soy Casilla Muerte"));
                } else if (data[0] == "Oca") {
                    listaCasillas.anadirCasilla(new DesplazarYTirar("", Integer.parseInt(data[1])));
                } else if (data[0] == "Puente") {
                    listaCasillas.anadirCasilla(new DesplazarYTirar("",Integer.parseInt(data[1])));
                } else if (data[0] == "Dado") {
                    listaCasillas.anadirCasilla(new DesplazarYTirar("",Integer.parseInt(data[1])));
                } else if (data[0] == "Carcel") {
                    listaCasillas.anadirCasilla(new Espera("",Integer.parseInt(data[1])));
                } else if (data[0] == "Pension") {
                    listaCasillas.anadirCasilla(new Espera("",Integer.parseInt(data[1])));
                } else if (data[0] == "Pozo") {
                    listaCasillas.anadirCasilla(new Espera("",Integer.parseInt(data[1])));
                } else if (data[0] == "Victoria") {
                    listaCasillas.anadirCasilla(new Victoria("Soy Casilla Victoria"));
                } else {
                    listaCasillas.anadirCasilla(new Normal("Soy Casilla Normal"));
                }
            }
            fileReader.close();
            Thread.sleep(1000);
            System.out.println();
            System.out.println(ansi().fg(GREEN).a("[\u2713] ¡Tablero creado con exito!").reset());
        } catch (Exception e) {
            
        }
    }
    
    public void jugarPartida() {
        this.configurarTablero();
        ListaFichas.getListaFichas().jugar();
    }
    /**
     * Metodo principal del juego, aqui es donde comienza todo la partida.
     */
    public static void main(String[] args) {

    }

}
