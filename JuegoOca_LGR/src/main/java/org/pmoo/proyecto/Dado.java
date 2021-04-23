package org.pmoo.proyecto;
import java.lang.Math;

public class Dado {
    //atributos
    private static Dado miDado = null;
    //constructora
    private Dado() {
        
    }
    //otros metodos
    public static Dado getDado() {
        if (Dado.miDado == null) {
            Dado.miDado = new Dado();
        }
        return Dado.miDado;
    }

    public int tirarDado() {
        return (Math.random()*5)+1;
    }
}
