package org.pmoo.proyecto;

public class Muerte extends Casilla{
    

    //constructora

    public Muerte (String pDescripcion)
    {        
        super(pDescripcion);

    }    
    
    public void cumplirMiFuncion(Ficha pFicha) {
        
        super.imprimirInfo();
        pFicha.sobreescribirPosicion(1);                    // nos lleva directamente a la casilla de inicio 
    }
}
