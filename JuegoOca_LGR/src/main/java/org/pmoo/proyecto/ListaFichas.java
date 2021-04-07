package org.pmoo.proyecto;

public class ListaFichas {
	
	//otros metodos
    /**
	 * Limpia la consola de comandos o shell (clear screen).
	 */
	public void limpiarConsola() {
		try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (Exception e) {}
	}
    /**
	 * Termina la partida saliendo del juego por completo.
	 */
	public static void terminarPartida() {
		System.out.println("Hasta la proxima...");
		System.exit(0);
	}
}
