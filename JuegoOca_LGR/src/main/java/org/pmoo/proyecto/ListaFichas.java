package org.pmoo.proyecto;
import java.util.ArrayList;
import java.util.Iterator;

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
        while (!ganador)
        {
            Iterator<Ficha> itr = this.getIterador();
            while (!ganador && itr.hasNext())
            {
                fichAct = itr.next();
                fichAct.jugar();
            }
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
    public static void terminarPartida() {
        System.out.println("Hasta la proxima...");
        System.exit(0);
    }
}
