package co.uniquindio.programacion2.cine.model;

public enum TipoPuesto {
	GENERAL(0),PRIMERACLASE(1),VIP(2);
	
	private int tipo;
	
	private TipoPuesto(int numTipo) {
		this.tipo = numTipo;
	}
	
	public int getNumTipo() {
		return tipo;
	}

	/**
	 * Representacion en string del valor elegido
	 */
	public String toString() {
		String tipo = " ";
		switch (this.tipo) {
		case 0:
			tipo = "General";
			break;
		case 1:
			tipo = "Primera Clase";
			break;
		case 2:
			tipo = "VIP";
			break;
		}
		return tipo;
	}

}
