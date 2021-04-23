package org.pmoo.proyecto;

public class Ficha {


    private String nombre;
    private boolean heGanado;
    private int posicion;
    private int turnosEspera;

    public Ficha(String pNombre)
    {
        this.nombre = pNombre;
        this.heGanado = false;
        this.posicion = 1;
        this.turnosEspera = 0;
    }

    public void jugar()
    {
        if (this.turnosEspera==0)
        {
            int tirada = Dado.getDado().tirarDado();
            this.aumentarPosicion(tirada);
            Casilla casillaAct = ListaCasillas.getListaCasillas().queHayEnPosicion(this.posicion);
            casillaAct.cumplirMiFuncion(this);
        }
        else
        {
            this.modificarTurnosEspera(-1);
        }
    }    

    public boolean getHeGanado()
    {
        return(this.heGanado);
    }

    public void sobreescribirHeGanado()
    {
        this.heGanado = true;
    }

    public int getPosicion()
    {
        return(this.posicion);
    }

    public void modificarTurnosEspera(int pTurnosEspera)
    {
        this.turnosEspera = this.turnosEspera + pTurnosEspera;
    }

    public void aumentarPosicion(int pDado)
    {
        this.posicion = this.posicion + pDado;
    }

    public void sobreescribirPosicion(int pPos)
    {
        this.posicion = pPos;
    }

}
