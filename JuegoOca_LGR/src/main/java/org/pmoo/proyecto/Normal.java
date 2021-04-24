package org.pmoo.proyecto;

public class Normal extends Casilla{
    

    //constructora

    public Normal (String pDescripcion)
    {        
        super(pDescripcion);

    }    
    
    public void cumplirMiFuncion(Ficha pFicha) {        
        super.imprimirInfo();
    }

}
