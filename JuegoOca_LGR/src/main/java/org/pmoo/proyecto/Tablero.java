package org.pmoo.proyecto;

import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.*;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuilder;
//import org.apache.commons.lang3.StringUtils;

public class Tablero {
    //Atributos
    private static Tablero miTablero = null;
    
    //Constructora
    /**
     * Crea una instancia de Tablero.
     */
    private Tablero() {
        
    }
    
    //Otros Metodos
    /**
     * @return Devuelve la unica instancia de tablero.
     */
    public static Tablero getTablero() {
        if (Tablero.miTablero == null){
            Tablero.miTablero = new Tablero();
        }
        return Tablero.miTablero;
    }
    /**
     * Imprime el tablero en formato UTF-8 para poder mostrar caracteres especiales y ademas usa la dependencia Jansi para poder imprimir colores Ansi por consola.
     */
    public void imprimirTablero () {
        try {
            PrintStream outStream = new PrintStream(System.out, true, "UTF-8");
            
            String posicionesNormal = this.impPosicionesCasillas("Normal", Juego.getOpcionTablero());
            String posicionesMuerte = this.impPosicionesCasillas("Muerte", Juego.getOpcionTablero());
            String posicionesOca = this.impPosicionesCasillas("Oca", Juego.getOpcionTablero());
            String posicionesPuente = this.impPosicionesCasillas("Puente", Juego.getOpcionTablero());
            String posicionesDado = this.impPosicionesCasillas("Dado", Juego.getOpcionTablero());
            String posicionesCarcel = this.impPosicionesCasillas("Carcel", Juego.getOpcionTablero());
            String posicionesPension = this.impPosicionesCasillas("Pension", Juego.getOpcionTablero());
            String posicionesPozo = this.impPosicionesCasillas("Pozo", Juego.getOpcionTablero());
            String posicionesVictoria = this.impPosicionesCasillas("Victoria", Juego.getOpcionTablero());
            
            outStream.println("\t\t\t\t\tEstado actual del tablero:\n\n");
        
            outStream.println("                      +------+------+------+------+------+------+------+------+------+------+");
            outStream.println("                      |  34  |  33  |  32  |  31  |  30  |  29  |  28  |  27  |  26  |  25  |");
            outStream.println("                      | " + this.impFichaEnTablero('V', 34) + this.impFichaEnTablero('R', 34) + this.impFichaEnTablero('A', 34) + this.impFichaEnTablero('M', 34) + " | " + this.impFichaEnTablero('V', 33) + this.impFichaEnTablero('R', 33) + this.impFichaEnTablero('A', 33) + this.impFichaEnTablero('M', 33) + " | " + this.impFichaEnTablero('V', 32) + this.impFichaEnTablero('R', 32) + this.impFichaEnTablero('A', 32) + this.impFichaEnTablero('M', 32) + " | " + this.impFichaEnTablero('V', 31) + this.impFichaEnTablero('R', 31) + this.impFichaEnTablero('A', 31) + this.impFichaEnTablero('M', 31) + " | " + this.impFichaEnTablero('V', 30) + this.impFichaEnTablero('R', 30) + this.impFichaEnTablero('A', 30) + this.impFichaEnTablero('M', 30) + " | " + this.impFichaEnTablero('V', 29) + this.impFichaEnTablero('R', 29) + this.impFichaEnTablero('A', 29) + this.impFichaEnTablero('M', 29) + " | " + this.impFichaEnTablero('V', 28) + this.impFichaEnTablero('R', 28) + this.impFichaEnTablero('A', 28) + this.impFichaEnTablero('M', 28) + " | " + this.impFichaEnTablero('V', 27) + this.impFichaEnTablero('R', 27) + this.impFichaEnTablero('A', 27) + this.impFichaEnTablero('M', 27) + " | " + this.impFichaEnTablero('V', 26) + this.impFichaEnTablero('R', 26) + this.impFichaEnTablero('A', 26) + this.impFichaEnTablero('M', 26) + " | " + this.impFichaEnTablero('V', 25) + this.impFichaEnTablero('R', 25) + this.impFichaEnTablero('A', 25) + this.impFichaEnTablero('M', 25) + " |");
            outStream.println("                      +------+------+------+------+------+------+------+------+------+------+");
            outStream.println("                      |  35  |                                                       |  24  |" + "\t\tCasillas Normal:");
            outStream.println("                      | " + this.impFichaEnTablero('V', 35) + this.impFichaEnTablero('R', 35) + this.impFichaEnTablero('A', 35) + this.impFichaEnTablero('M', 35) + " |                                                       | " + this.impFichaEnTablero('V', 24) + this.impFichaEnTablero('R', 24) + this.impFichaEnTablero('A', 24) + this.impFichaEnTablero('M', 24) + " |" + "\t\t  " + posicionesNormal);
            outStream.println("                      +------+      +------+------+------+------+------+------+      +------+");
            outStream.println("         Fichas:      |  36  |      |  58  |  57  |  56  |  55  |  54  |  53  |      |  23  |" + "\t\tCasillas Muerte:");
            outStream.println("      ▬▬▬▬▬▬▬▬▬▬▬▬▬▬  | " + this.impFichaEnTablero('V', 36) + this.impFichaEnTablero('R', 36) + this.impFichaEnTablero('A', 36) + this.impFichaEnTablero('M', 36) + " |      | " + this.impFichaEnTablero('V', 58) + this.impFichaEnTablero('R', 58) + this.impFichaEnTablero('A', 58) + this.impFichaEnTablero('M', 58) + " | " + this.impFichaEnTablero('V', 57) + this.impFichaEnTablero('R', 57) + this.impFichaEnTablero('A', 57) + this.impFichaEnTablero('M', 57) + " | " + this.impFichaEnTablero('V', 56) + this.impFichaEnTablero('R', 56) + this.impFichaEnTablero('A', 56) + this.impFichaEnTablero('M', 56) + " | " + this.impFichaEnTablero('V', 55) + this.impFichaEnTablero('R', 55) + this.impFichaEnTablero('A', 55) + this.impFichaEnTablero('M', 55) + " | " + this.impFichaEnTablero('V', 54) + this.impFichaEnTablero('R', 54) + this.impFichaEnTablero('A', 54) + this.impFichaEnTablero('M', 54) + " | " + this.impFichaEnTablero('V', 53) + this.impFichaEnTablero('R', 53) + this.impFichaEnTablero('A', 53) + this.impFichaEnTablero('M', 53) + " |      | " + this.impFichaEnTablero('V', 23) + this.impFichaEnTablero('R', 23) + this.impFichaEnTablero('A', 23) + this.impFichaEnTablero('M', 23) + " |" + "\t\t  " + posicionesMuerte);
            outStream.println("        " + this.impJugadoresEnTablero(1) + "   +------+      +------+------+------+------+------+------+      +------+");
            outStream.println("        " + this.impJugadoresEnTablero(2) + "   |  37  |      |  59  |                           |  52  |      |  22  |" + "\t\tCasillas Oca:");
            outStream.println("        " + this.impJugadoresEnTablero(3) + "   | " + this.impFichaEnTablero('V', 37) + this.impFichaEnTablero('R', 37) + this.impFichaEnTablero('A', 37) + this.impFichaEnTablero('M', 37) + " |      | " + this.impFichaEnTablero('V', 59) + this.impFichaEnTablero('R', 59) + this.impFichaEnTablero('A', 59) + this.impFichaEnTablero('M', 59) + " |                           | " + this.impFichaEnTablero('V', 52) + this.impFichaEnTablero('R', 52) + this.impFichaEnTablero('A', 52) + this.impFichaEnTablero('M', 52) + " |      | " + this.impFichaEnTablero('V', 22) + this.impFichaEnTablero('R', 22) + this.impFichaEnTablero('A', 22) + this.impFichaEnTablero('M', 22) + " |" + "\t\t  " + posicionesOca);
            outStream.println("        " + this.impJugadoresEnTablero(4) + "   +------+      +------+      +--------------+     +------+      +------+");
            outStream.println("                      |  38  |      |  60  |      |              |     |  51  |      |  21  |" + "\t\tCasillas Puente:");
            outStream.println("                      | " + this.impFichaEnTablero('V', 38) + this.impFichaEnTablero('R', 38) + this.impFichaEnTablero('A', 38) + this.impFichaEnTablero('M', 38) + " |      | " + this.impFichaEnTablero('V', 60) + this.impFichaEnTablero('R', 60) + this.impFichaEnTablero('A', 60) + this.impFichaEnTablero('M', 60) + " |      |      63      |     | " + this.impFichaEnTablero('V', 51) + this.impFichaEnTablero('R', 51) + this.impFichaEnTablero('A', 51) + this.impFichaEnTablero('M', 51) + " |      | " + this.impFichaEnTablero('V', 21) + this.impFichaEnTablero('R', 21) + this.impFichaEnTablero('A', 21) + this.impFichaEnTablero('M', 21) + " |" + "\t\t  " + posicionesPuente);
            outStream.println("     +------------+   +------+      +------+------|              |     +------+      +------+");
            outStream.println("     |   Inicio   |   |  39  |      |  61  |  62  |     " + this.impFichaEnTablero('V', 63) + this.impFichaEnTablero('R', 63) + this.impFichaEnTablero('A', 63) + this.impFichaEnTablero('M', 63) + "     |     |  50  |      |  20  |" + "\t\tCasillas Dado:");
            outStream.println("     |    " + this.impFichaEnTablero('V', 1) + this.impFichaEnTablero('R', 1) + this.impFichaEnTablero('A', 1) + this.impFichaEnTablero('M', 1) + "    |   | " + this.impFichaEnTablero('V', 39) + this.impFichaEnTablero('R', 39) + this.impFichaEnTablero('A', 39) + this.impFichaEnTablero('M', 39) + " |      | " + this.impFichaEnTablero('V', 61) + this.impFichaEnTablero('R', 61) + this.impFichaEnTablero('A', 61) + this.impFichaEnTablero('M', 61) + " | " + this.impFichaEnTablero('V', 62) + this.impFichaEnTablero('R', 62) + this.impFichaEnTablero('A', 62) + this.impFichaEnTablero('M', 62) + " |              |     | " + this.impFichaEnTablero('V', 50) + this.impFichaEnTablero('R', 50) + this.impFichaEnTablero('A', 50) + this.impFichaEnTablero('M', 50) + " |      | " + this.impFichaEnTablero('V', 20) + this.impFichaEnTablero('R', 20) + this.impFichaEnTablero('A', 20) + this.impFichaEnTablero('M', 20) + " |" + "\t\t  " + posicionesDado);
            outStream.println("     +------------+   +------+      +------+------+--------------+     +------+      +------+");
            outStream.println("        |  02  |      |  40  |                                         |  49  |      |  19  |" + "\t\tCasillas Carcel:");
            outStream.println("        | " + this.impFichaEnTablero('V', 2) + this.impFichaEnTablero('R', 2) + this.impFichaEnTablero('A', 2) + this.impFichaEnTablero('M', 2) + " |      | " + this.impFichaEnTablero('V', 40) + this.impFichaEnTablero('R', 40) + this.impFichaEnTablero('A', 40) + this.impFichaEnTablero('M', 40) + " |                                         | " + this.impFichaEnTablero('V', 49) + this.impFichaEnTablero('R', 49) + this.impFichaEnTablero('A', 49) + this.impFichaEnTablero('M', 49) + " |      | " + this.impFichaEnTablero('V', 19) + this.impFichaEnTablero('R', 19) + this.impFichaEnTablero('A', 19) + this.impFichaEnTablero('M', 19) + " |" + "\t\t  " + posicionesCarcel);
            outStream.println("        +------+      +------+------+------+------+------+------+------+------+      +------+");
            outStream.println("        |  03  |      |  41  |  42  |  43  |  44  |  45  |  46  |  47  |  48  |      |  18  |" + "\t\tCasillas Pension:");
            outStream.println("        | " + this.impFichaEnTablero('V', 3) + this.impFichaEnTablero('R', 3) + this.impFichaEnTablero('A', 3) + this.impFichaEnTablero('M', 3) + " |      | " + this.impFichaEnTablero('V', 41) + this.impFichaEnTablero('R', 41) + this.impFichaEnTablero('A', 41) + this.impFichaEnTablero('M', 41) + " | " + this.impFichaEnTablero('V', 42) + this.impFichaEnTablero('R', 42) + this.impFichaEnTablero('A', 42) + this.impFichaEnTablero('M', 42) + " | " + this.impFichaEnTablero('V', 43) + this.impFichaEnTablero('R', 43) + this.impFichaEnTablero('A', 43) + this.impFichaEnTablero('M', 43) + " | " + this.impFichaEnTablero('V', 44) + this.impFichaEnTablero('R', 44) + this.impFichaEnTablero('A', 44) + this.impFichaEnTablero('M', 44) + " | " + this.impFichaEnTablero('V', 45) + this.impFichaEnTablero('R', 45) + this.impFichaEnTablero('A', 45) + this.impFichaEnTablero('M', 45) + " | " + this.impFichaEnTablero('V', 46) + this.impFichaEnTablero('R', 46) + this.impFichaEnTablero('A', 46) + this.impFichaEnTablero('M', 46) + " | " + this.impFichaEnTablero('V', 47) + this.impFichaEnTablero('R', 47) + this.impFichaEnTablero('A', 47) + this.impFichaEnTablero('M', 47) + " | " + this.impFichaEnTablero('V', 48) + this.impFichaEnTablero('R', 48) + this.impFichaEnTablero('A', 48) + this.impFichaEnTablero('M', 48) + " |      | " + this.impFichaEnTablero('V', 18) + this.impFichaEnTablero('R', 18) + this.impFichaEnTablero('A', 18) + this.impFichaEnTablero('M', 18) + " |" + "\t\t  " + posicionesPension);
            outStream.println("        +------+      +------+------+------+------+------+------+------+------+      +------+");
            outStream.println("        |  04  |                                                                     |  17  |" + "\t\tCasillas Pozo:");
            outStream.println("        | " + this.impFichaEnTablero('V', 4) + this.impFichaEnTablero('R', 4) + this.impFichaEnTablero('A', 4) + this.impFichaEnTablero('M', 4) + " |                                                                     | " + this.impFichaEnTablero('V', 17) + this.impFichaEnTablero('R', 17) + this.impFichaEnTablero('A', 17) + this.impFichaEnTablero('M', 17) + " |" + "\t\t  " + posicionesPozo);
            outStream.println("        +------+------+------+------+------+------+------+------+------+------+------+------+");
            outStream.println("        |  05  |  06  |  07  |  08  |  09  |  10  |  11  |  12  |  13  |  14  |  15  |  16  |" + "\t\tCasillas Victoria:");
            outStream.println("        | " + this.impFichaEnTablero('V', 5) + this.impFichaEnTablero('R', 5) + this.impFichaEnTablero('A', 5) + this.impFichaEnTablero('M', 5) + " | " + this.impFichaEnTablero('V', 6) + this.impFichaEnTablero('R', 6) + this.impFichaEnTablero('A', 6) + this.impFichaEnTablero('M', 6) + " | " + this.impFichaEnTablero('V', 7) + this.impFichaEnTablero('R', 7) + this.impFichaEnTablero('A', 7) + this.impFichaEnTablero('M', 7) + " | " + this.impFichaEnTablero('V', 8) + this.impFichaEnTablero('R', 8) + this.impFichaEnTablero('A', 8) + this.impFichaEnTablero('M', 8) + " | " + this.impFichaEnTablero('V', 9) + this.impFichaEnTablero('R', 9) + this.impFichaEnTablero('A', 9) + this.impFichaEnTablero('M', 9) + " | " + this.impFichaEnTablero('V', 10) + this.impFichaEnTablero('R', 10) + this.impFichaEnTablero('A', 10) + this.impFichaEnTablero('M', 10) + " | " + this.impFichaEnTablero('V', 11) + this.impFichaEnTablero('R', 11) + this.impFichaEnTablero('A', 11) + this.impFichaEnTablero('M', 11) + " | " + this.impFichaEnTablero('V', 12) + this.impFichaEnTablero('R', 12) + this.impFichaEnTablero('A', 12) + this.impFichaEnTablero('M', 12) + " | " + this.impFichaEnTablero('V', 13) + this.impFichaEnTablero('R', 13) + this.impFichaEnTablero('A', 13) + this.impFichaEnTablero('M', 13) + " | " + this.impFichaEnTablero('V', 14) + this.impFichaEnTablero('R', 14) + this.impFichaEnTablero('A', 14) + this.impFichaEnTablero('M', 14) + " | " + this.impFichaEnTablero('V', 15) + this.impFichaEnTablero('R', 15) + this.impFichaEnTablero('A', 15) + this.impFichaEnTablero('M', 15) + " | " + this.impFichaEnTablero('V', 16) + this.impFichaEnTablero('R', 16) + this.impFichaEnTablero('A', 16) + this.impFichaEnTablero('M', 16) + " |" + "\t\t  " + posicionesVictoria);
            outStream.println("        +------+------+------+------+------+------+------+------+------+------+------+------+");
            outStream.println();
        } catch (Exception e) {
            
        }
    }
    /**
     * Imprime la informacion sobre el color de ficha del jugador en tablero en caso de que se encuentre activo.
     * @param pNumJugador el numero de jugador que se quiere imprimir (desde 2 jugadores hasta 4).
     * @return Devuelve un objeto Ansi, que es parecio a un String pero con colores.
     */
    private Ansi impJugadoresEnTablero(int pNumJugador) {
        Ansi jugadorEnCasilla = null;
        if (pNumJugador <= ListaFichas.getListaFichas().obtenerNumFichas()) {
            if (pNumJugador == 1) {
                jugadorEnCasilla = ansi().fg(GREEN).a("Jugador1: ●").reset();
            } else if (pNumJugador == 2) {
                jugadorEnCasilla = ansi().fg(RED).a("Jugador2: ●").reset();
            } else if (pNumJugador == 3) {
                jugadorEnCasilla = ansi().fg(BLUE).a("Jugador3: ●").reset();
            } else if (pNumJugador == 4) {
                jugadorEnCasilla = ansi().fg(MAGENTA).a("Jugador4: ●").reset();
            }
        } else {
            jugadorEnCasilla = ansi().fg(WHITE).a("           ").reset();
        }
        return jugadorEnCasilla;
    }
    
    /**
     * Imprime la ficha en el tablero en caso de que este en esa posicion de casilla, en caso contrario, imprime un espacio en blanco.
     * @param pInicial Inicial del nombre del color de la ficha que se quiere representar en el tablero.
     * @param pPosCasilla Posicion de una casilla, para compararla con la de la ficha y saber si se encuentra en la misma.
     * @return Devuelve un objeto Ansi, similar a una cadena de caracteres normal pero en un formato que permite utilizar los colores Ansi.
     */
    private Ansi impFichaEnTablero(char pInicial, int pPosCasilla) {
        Ansi ansiFichaEnCasilla;
        //ListaFichas.getListaFichas.get(0).getPosicion() //0-V,1-R,2-A,3-M indican los colores de los jugadores(Verde, Rojo, Azul y Magenta)
        try {
            if (pInicial == 'V' && ListaFichas.getListaFichas.get(0).getPosicion() == pPosCasilla) {
                ansiFichaEnCasilla = ansi().fg(GREEN).a("●").reset();
            } else if (pInicial == 'R' && ListaFichas.getListaFichas.get(1).getPosicion() == pPosCasilla) {
                ansiFichaEnCasilla = ansi().fg(RED).a("●").reset();
            } else if (pInicial == 'A' && ListaFichas.getListaFichas.get(2).getPosicion() == pPosCasilla) {
                ansiFichaEnCasilla = ansi().fg(BLUE).a("●").reset();
            } else if (pInicial == 'M' && ListaFichas.getListaFichas.get(3).getPosicion() == pPosCasilla) {
                ansiFichaEnCasilla = ansi().fg(MAGENTA).a("●").reset();
            } else {
                ansiFichaEnCasilla = ansi().fg(WHITE).a(" ").reset();
            }
        } catch (Exception e) {
            ansiFichaEnCasilla = ansi().fg(WHITE).a(" ").reset();
        }
        return ansiFichaEnCasilla;
    }
    /**
     * Imprime al lado del tablero las posiciones de las casillas, para que el jugador no se pierda durante la partida.
     * @param pNombreCasilla El nombre de la casilla para diferenciarlo del resto.
     * @param pOpcionTablero El numero de la tematica del tablero que se ha escogido previamente, para tener en cuenta las posiciones de las casillas en funcion de los distintos tableros.
     * @return Devuelve un String en el que aparecen recogidas las posiciones de la casilla pNombreCasilla.
     */
    private String impPosicionesCasillas(String pNombreCasilla, int pOpcionTablero) {
        StringBuilder posicionesCasilla = new StringBuilder();
        String strCurrentLine = "";
        try{
            BufferedReader fileReader = null;
            if (pOpcionTablero == 1) {
                fileReader = new BufferedReader(new FileReader("./tableros/TableroClasico.txt"));
            } else if (pOpcionTablero == 2) {
                fileReader = new BufferedReader(new FileReader("./tableros/TableroPersonalizado.txt"));
            }
            int pos = 1;
            while ((strCurrentLine = fileReader.readLine()) != null) {
                String data[] = strCurrentLine.split("_");
                /*if (pNombreCasilla == "Normal" && data[0].equals("Normal")) {
                    posicionesCasilla.append(pos + ", ");
                } else if (pNombreCasilla == "Muerte" && data[0].equals("Muerte")) {
                    posicionesCasilla.append(pos + ", ");
                } else if (pNombreCasilla == "Oca" && data[0].equals("Oca")) {
                    posicionesCasilla.append(pos + ", ");
                } else if (pNombreCasilla == "Puente" && data[0].equals("Puente")) {
                    posicionesCasilla.append(pos + ", ");
                } else if (pNombreCasilla == "Dado" && data[0].equals("Dado")) {
                    posicionesCasilla.append(pos + ", ");
                } else if (pNombreCasilla == "Carcel" && data[0].equals("Carcel")) {
                    posicionesCasilla.append(pos + ", ");
                } else if (pNombreCasilla == "Pension" && data[0].equals("Pension")) {
                    posicionesCasilla.append(pos + ", ");
                } else if (pNombreCasilla == "Pozo" && data[0].equals("Pozo")) {
                    posicionesCasilla.append(pos + ", ");
                } else if (pNombreCasilla == "Victoria" && data[0].equals("Victoria")) {
                    posicionesCasilla.append(pos + ", ");
                }*/
                if (data[0].equals(pNombreCasilla)) {
                    posicionesCasilla.append(pos + ", ");
                }
                pos++;
            }
            fileReader.close();
            strCurrentLine = (posicionesCasilla.deleteCharAt(posicionesCasilla.length()-2)).toString();
        } catch (Exception e) {
            
        }
        return strCurrentLine;
    }
}
