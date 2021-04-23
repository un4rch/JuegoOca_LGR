package org.pmoo.proyecto;

public class Espera extends Casilla{
    

    //atributos
    
    private int turnosEspera;

    //constructora

    public Espera (String pDescripcion, int pTurnosEspera)
    {        
        super(pDescripcion);
        this.turnosEspera = pTurnosEspera;

    }    
    
    public void cumplirMiFuncion(Ficha pFicha) {
        
        super.cumplirMiFuncion();
        pFicha.modificarTurnosEspera(this.turnosEspera);
    }

}
