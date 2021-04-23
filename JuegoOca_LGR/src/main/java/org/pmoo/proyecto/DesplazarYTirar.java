package org.pmoo.proyecto;

public class DesplazarYTirar extends Casilla{
        

        //atributos
        
        private int nuevaPosicion;

        //constructora

        public DesplazarYTirar (String pDescripcion, int pNuevaPosicion)
        {        
            super(pDescripcion);
            this.nuevaPosicion = pNuevaPosicion;

        }    
        
        public void cumplirMiFuncion(Ficha pFicha) {
            
            super.cumplirMiFuncion();
            pFicha.sobreescribirPosicion(this.nuevaPosicion);
            pFicha.jugar();                                       // que implica : tirarDado ()  : int
                                                                  //               getPosicion () : int
                                                                  //               queHayEnPosicion (int) : Casilla 
                                                                  //               cumplirMiFuncion (Ficha)  
            
        }


}
