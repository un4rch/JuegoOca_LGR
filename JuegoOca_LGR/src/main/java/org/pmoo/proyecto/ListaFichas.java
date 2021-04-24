package org.pmoo.proyecto;

import java.util.ArrayList;
import java.util.Iterator;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.*;

import java.lang.Thread;

public class ListaFichas {
    
    private ArrayList<Ficha> lista;
    private static ListaFichas miListaFichas=null;
    
    private ListaFichas()
    {
        lista = new ArrayList<Ficha>();
    }
    
    //otros metodos
    /**
     * Limpia la consola de comandos o shell (clear screen).
     */
    
    public static ListaFichas getListaFichas()
    {
        if (ListaFichas.miListaFichas==null)
        {
            ListaFichas.miListaFichas = new ListaFichas();
        }
        return (ListaFichas.miListaFichas);
    }
    
    private Iterator<Ficha> getIterador()
    {
        return(this.lista.iterator());
    }
    
    public void anadirFicha(Ficha pFicha)
    {
        this.lista.add(pFicha);
    }
    
    public int obtenerNumFichas()
    {
        return(this.lista.size());
    }
    
    public void jugar()
    {
        boolean ganador = false;
        Ficha fichAct = null;
        this.limpiarConsola();
        try {
        	 while (!ganador)
             {
                 Iterator<Ficha> itr = this.getIterador();
                 while (!ganador && itr.hasNext())
                 {
                     Tablero.getTablero().imprimirTablero();
                     fichAct = itr.next();
                     System.out.println(ansi().fg(YELLOW).a("[*] Opciones de Juego:\n"));
                     System.out.println("\t(1) Tirar Dado.");
                     System.out.println("\t(2) Terminar Partida.\n");
                     System.out.println(ansi().fg(CYAN).a(fichAct.getNombre() + ", ¿Que deseas hacer? ").reset());
                     if (Teclado.getTeclado().pedirOpcion(2) == 2) {
                     	this.terminarPartida();
                     }
                     System.out.println(ansi().fg(YELLOW).a(""));
                     fichAct.jugar();
                     ganador = fichAct.getHeGanado();
                     System.out.println(ansi().fg(MAGENTA).a("").reset());
                     Thread.sleep(3000);
                     this.limpiarConsola();
                 }
             }
        	 System.out.println(ansi().fg(GREEN).a("\n\n\n\n\t\t\t\t\t\t\t\tFelicidades " + ansi().fg(CYAN).a(fichAct.getNombre()) + ansi().fg(GREEN).a(" has ganado la partida!")));
        	 Thread.sleep(5000);
        } catch (Exception e) {
        	
        }
        
    }
    
    
    public Ficha obtenerFicha(int pPosFicha) {
    	return this.lista.get(pPosFicha);
    }
    
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
        System.out.println("\nHasta la proxima...");
        try {
        	Thread.sleep(2000);
        } catch(Exception e) {
        	
        }
        System.exit(0);
    }
}
