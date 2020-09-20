package co.uniquindio.programacion2.cine.model;

public class Pelicula {
	
	private String nombre;
	private int minimaEdad;
	/**
	 * @param nombre
	 * @param minimaEdad
	 */
	public Pelicula(String nombre, int minimaEdad) {
		this.nombre = nombre;
		this.minimaEdad = minimaEdad;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the minimaEdad
	 */
	public int getMinimaEdad() {
		return minimaEdad;
	}
	/**
	 * @param minimaEdad the minimaEdad to set
	 */
	public void setMinimaEdad(int minimaEdad) {
		this.minimaEdad = minimaEdad;
	}
	
	
}
