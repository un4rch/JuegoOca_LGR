package org.pmoo.proyecto;

public abstract class Casilla {
    
    //atributos
    private String descripcion;
    
    //constructora
    public Casilla (String pDescripcion) {
        this.descripcion = pDescripcion;
    }

    //metodos
    public void imprimirInfo() {
        System.out.println(this.descripcion + "\n");
    }
    
    public abstract void cumplirMiFuncion(Ficha pFicha);
    
}
