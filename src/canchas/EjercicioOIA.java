package canchas;

import java.io.File;

/**
 * Clase que administra el formato de ejercicios de la OIA. <br>
 */
public abstract class EjercicioOIA {
	/**
	 * Archivo de entrada. <br>
	 */
	protected File entrada;
	/**
	 * Archivo de salida. <br>
	 */
	protected File salida;

	/**
	 * Crea los archivos de entrada y de salida del problema. <br>
	 *
	 * @param entrada
	 *            Archivo de entrada. <br>
	 * @param salida
	 *            Archivo de salida. <br>
	 */
	public EjercicioOIA(File entrada, File salida) {
		this.entrada = entrada;
		this.salida = salida;
	}

	/**
	 * Resuelve el ejercicio. <br>
	 */
	public abstract void resolver();

}