package SaberYGanar;

public class Jugador {
	private int marcador;
	private String nombre;

	public Jugador(String nombre) {
		this.setMarcador(0);
		this.nombre = nombre;
	}

	public int getMarcador() {
		return marcador;
	}

	public void setMarcador(int marcador) {
		this.marcador = marcador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
