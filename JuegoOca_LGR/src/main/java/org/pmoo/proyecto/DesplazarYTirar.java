package org.pmoo.proyecto;

import static org.fusesource.jansi.Ansi.ansi;
import static org.fusesource.jansi.Ansi.Color.CYAN;
import static org.fusesource.jansi.Ansi.Color.YELLOW;

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
            
            super.imprimirInfo();
            
            System.out.println(ansi().fg(YELLOW).a("[*] Opciones de Juego:\n"));
            System.out.println("\t(1) Tirar Dado.");
            System.out.println("\t(2) Terminar Partida.\n");
            System.out.println(ansi().fg(CYAN).a(pFicha.getNombre() + ", ¿Que deseas hacer? ").reset());
            if (Teclado.getTeclado().pedirOpcion(2) == 2) {
            	ListaFichas.getListaFichas().terminarPartida();
            }
            pFicha.sobreescribirPosicion(this.nuevaPosicion);
            if(pFicha.getPosicion()==63){
            	Casilla casillaAct = ListaCasillas.getListaCasillas().queHayEnPosicion(pFicha.getPosicion()-1);
                casillaAct.cumplirMiFuncion(pFicha);
            }
            else {
            	pFicha.jugar();
            }
                                                                  // que implica : tirarDado ()  : int
                                                                  //               getPosicion () : int
                                                                  //               queHayEnPosicion (int) : Casilla 
                                                                  //               cumplirMiFuncion (Ficha)  
            
        }


}
