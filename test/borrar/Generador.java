package borrar;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

public class Generador {

	private String pathOut = "Ejecucion de Prueba/";
	private Historia historia;

	@Test
	public void test() {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(pathOut + "fatiga.out"));
			for (int i = 0; i < 40000; i++) {
				this.historia = new Historia(i);
				System.out.println(this.historia.getNumero() + " " + this.historia.getNombre());
				salida.println(this.historia.getNumero() + " " + this.historia.getNombre());
			}
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
