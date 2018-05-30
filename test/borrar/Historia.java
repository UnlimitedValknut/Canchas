package borrar;

public class Historia {
	private int numero;
	private String nombre = new String();
	private static final char[] letras = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public Historia(final int numero) {
		this.numero = numero;
		this.asignarNombre();
	}

	public int getNumero() {
		return numero + 1;
	}

	public String getNombre() {
		return nombre;
	}

	private void asignarNombre() {
		char primero = letras[this.numero % 21];
		char segundo = letras[this.numero % 22];
		char tercero = letras[this.numero % 23];
		char cuarto = letras[this.numero % 24];
		char quinto = letras[this.numero % 25];
		char sexto = letras[this.numero % 26];

		this.nombre = new String(primero + "" + segundo + "" + tercero + " " + cuarto + "" + quinto + "" + sexto);
	}
}
