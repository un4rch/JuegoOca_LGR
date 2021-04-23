package org.pmoo.proyecto;

import java.util.ArrayList;

public class ListaCasillas {

    //Atributos
    private ArrayList<Casilla> lista;
    private static ListaCasillas miListaCasillas;
    
    //Constructora
    private ListaCasillas() {
        this.lista = new ArrayList<Casilla>();
    }
    
    //Metodos
    public static ListaCasillas getListaCasillas() {
        if(ListaCasillas.miListaCasillas == null) {
            ListaCasillas.miListaCasillas = new ListaCasillas();
        }
        return miListaCasillas;
    }
    
    public void anadirCasilla(Casilla pCasilla) {
        this.lista.add(pCasilla);
    }
    
    public Casilla queHayEnPosicion(int pPosicion) {
        return this.lista.get(pPosicion);
    }
}
