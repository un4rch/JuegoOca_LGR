package org.pmoo.proyecto;

import java.io.PrintStream;
import java.util.Scanner;
import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.*;

public class Teclado {
    //Atributos
    private static Teclado miTeclado = null;

    //Constructora
    /**
     * Crea una instancia de Teclado.
     */
    private Teclado() {
    	
    }

    //Otros Metodos
    /**
     * @return Devuelve la unica instancia de Teclado.
     */
    public static Teclado getTeclado() {
       if (Teclado.miTeclado == null) {
           Teclado.miTeclado = new Teclado();
       }
       return Teclado.miTeclado;
    }
    /**
     * Pide una opcion al usuario, desde el numero 1 hasta la cantidad recivida(pNumOpciones).
     * @param pNumOpciones Numero de opciones que se desean pedir.
     * @return Devuelve un entero que representa el numero de opcion que ha elegido el usuario.
     */
    public int pedirOpcion(int pNumOpciones) {
    	Scanner input = new Scanner(System.in);
        int opcion = 0;
        try{
        	PrintStream outStream = new PrintStream(System.out, true, "UTF-8");
            if (input.hasNextInt()) {
            	opcion = input.nextInt();
            }
            if (opcion < 1 || opcion > pNumOpciones) {
            	outStream.print(ansi().fg(RED).a("[Ø] Error: Opcion no valida, intentalo de nuevo: ").reset());
            	opcion = Teclado.getTeclado().pedirOpcion(pNumOpciones);
            }
    	} catch (Exception e) {
    		
    	}
        return opcion;
    }
}
