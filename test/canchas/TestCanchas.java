package canchas;

import java.io.File;

import org.junit.Test;

public class TestCanchas {
	private String pathIn = "Preparacion de Prueba/Lote de Prueba/Entrada/";
	private String pathOut = "Ejecucion de Prueba/Salida Obtenida/";

	@Test
	public void test() {
		Canchas canchas = new Canchas(new File(pathIn + "00_Enunciado.in"), new File(pathOut + "00_Enunciado.out"));
		canchas.resolver();
	}
}
