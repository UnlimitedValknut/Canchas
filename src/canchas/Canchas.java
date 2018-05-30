package canchas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Canchas extends EjercicioOIA {
	/**
	 * Cantidad de reservas permitidas por semana. <br>
	 */
	private int cantidadReservas;
	/**
	 * Arancel por reserva. <br>
	 */
	private int arancel;
	/**
	 * Cantidad de turnos asignables por persona por semana. <br>
	 */
	private int turnos;
	/**
	 * Reservas realizadas por los socios. <br>
	 */
	private Map<Integer, Integer> socios = new HashMap<Integer, Integer>();
	/**
	 * Cantidad de plata a devolver. <br>
	 */
	private int aDevolver = 0;

	public Canchas(final File entrada, final File salida) {
		super(entrada, salida);
		try {
			this.leerArchivo(super.entrada);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	/**
	 * Lee el archivo de entrada. <br>
	 *
	 * @param path
	 *            Archivo de entrada. <br>
	 * @throws IOException
	 *             El path es incorrecto o los parámetros están mal pasado. <br>
	 */
	private void leerArchivo(final File path) throws IOException {
		try {
			Scanner entrada = new Scanner(path);
			this.cantidadReservas = entrada.nextInt();
			this.arancel = entrada.nextInt();
			this.turnos = entrada.nextInt();
			this.validarReservas();
			int deporte;
			int jugadores;
			int socio;
			for (int i = 0; i < this.cantidadReservas; i++) {
				entrada.nextLine();
				deporte = entrada.nextInt();
				jugadores = entrada.nextInt();
				this.validarDeporte(deporte, jugadores, i + 1);
				entrada.nextLine();
				for (int j = 0; j < jugadores; j++) {
					socio = entrada.nextInt();
					if (this.socios.containsKey(socio)) {
						this.socios.put(socio, this.socios.get(socio) + 1);
					} else {
						this.socios.put(socio, 1);
					}
				}
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			throw new IOException("Error al abrir el archivo de entrada. \nPath invalido.");
		} catch (ArithmeticException e) {
			throw new IOException(e.getMessage());
		}
	}

	/**
	 * Valida de que la cantidad de reservas, el arancel y la cantidad de turnos
	 * asignables por persona durante una semana sean válidos. <br>
	 *
	 * @throws ArithmeticException
	 *             Los parámetros de entrada no cumplen con las condiciones.
	 *             <br>
	 */
	private void validarReservas() throws ArithmeticException {
		if (this.cantidadReservas < 0 || this.cantidadReservas > 1000) {
			throw new ArithmeticException("Cantidad de reservas erroneas.");
		}
		if (this.arancel < 1 || this.arancel > 100) {
			throw new ArithmeticException("Arancel erroneo.");
		}
		if (this.turnos < 1 || this.turnos > 20) {
			throw new ArithmeticException("Turnos erroneos.");
		}
	}

	/**
	 * Valida que la cantidad de jugadores que reservaron sea la corecta para el
	 * deporte a realizar. <br>
	 *
	 * @param deporte
	 *            Deporte en que se reservó. <br>
	 * @param jugadores
	 *            Jugadores que participan. <br>
	 * @param posicion
	 *            Posición actual de la línea de reservas. <br>
	 * @throws ArithmeticException
	 *             La cantidad de jugadores no es la correcta para el deporte.
	 *             <br>
	 */
	private void validarDeporte(final int deporte, final int jugadores, final int posicion) throws ArithmeticException {
		if ((deporte == 1 || deporte == 2) && (jugadores != 2 && jugadores != 4)) {
			throw new ArithmeticException("Cantidad de jugadores incorrectas en la línea " + posicion);
		}
		if (deporte == 3 && (jugadores != 10 && jugadores != 14 && jugadores != 22)) {
			throw new ArithmeticException("Cantidad de jugadores incorrectas en la línea " + posicion);
		}
	}

	@Override
	public void resolver() {
		for (Iterator<Map.Entry<Integer, Integer>> iterator = this.socios.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<Integer, Integer> actual = iterator.next();
			if (actual.getValue() > this.turnos) {
				this.aDevolver += (actual.getValue() - this.turnos) * this.arancel;
			}
		}
		this.grabarArchivo();
	}

	/**
	 * Graba el archivo de salida. <br>
	 */
	private void grabarArchivo() {
		PrintWriter salida;
		try {
			salida = new PrintWriter(new FileWriter(super.salida));
			salida.println(this.aDevolver);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
