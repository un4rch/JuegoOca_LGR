package org.pmoo.proyecto;

public class Victoria extends Casilla{
    
    public Victoria (String pDescripcion)
    {        
        super(pDescripcion);

    }    
    
    public void cumplirMiFuncion(Ficha pFicha) {
        
        super.cumplirMiFuncion(pFicha);
        pFicha.sobreescribirHeGanado();    
        
    }

}
