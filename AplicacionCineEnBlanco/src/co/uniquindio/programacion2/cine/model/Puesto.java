package co.uniquindio.programacion2.cine.model;

public class Puesto {

	private int numero;
	private TipoPuesto tipo;
	private boolean disponible;
	
	public Puesto( int numero, TipoPuesto tipo) {
			this.numero=numero;
			this.tipo=tipo;
			this.disponible=true;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the tipo
	 */
	public TipoPuesto getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoPuesto tipo) {
		this.tipo = tipo;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	
	
	

}
