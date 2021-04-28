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

	/*public int tirarDado() {
        return (int) Math.round((Math.random()*5)+1);
    }*/





	public int tirarDado() {
		int dadoTruco = 0;
		System.out.println(ansi().fg(YELLOW).a("[] Ingrese el valor que quiera que saque el dado:\n"));
		dadoTruco = Teclado.getTeclado().pedirOpcion(6);
		return dadoTruco;
	}
}