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
            System.out.println("Has sacado: " + tirada + "\n");
            this.aumentarPosicion(tirada);
            Casilla casillaAct = ListaCasillas.getListaCasillas().queHayEnPosicion(this.posicion-1);
            casillaAct.cumplirMiFuncion(this);
        }
        else
        {
            this.modificarTurnosEspera(-1);
        }
    }
    
    public String getNombre() {
    	return this.nombre;
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
        if (this.posicion-63 > 0) {
        	this.posicion = this.posicion - 2*(this.posicion - 63);
        }
    }
    
    public int getTurnosEspera() {
    	return this.turnosEspera;
    }

    public void sobreescribirPosicion(int pPos)
    {
        this.posicion = pPos;
    }

}
