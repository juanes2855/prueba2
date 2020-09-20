package co.uniquindio.programacion2.cine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sala {
	
	private String nombre;
	private Pelicula pelicula;
	
	//matriz de puestos
	private Puesto [][]puestos;
	
	/**
	 * @param nombre
	 */
	public Sala(String nombre, int cantidadFilas, int cantidadSillaXFila) {
		this.nombre = nombre;
		this.puestos= new Puesto[cantidadFilas][cantidadSillaXFila];
		crearPuestos();
		//Reservar memoria para puestos;
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
	}
	
	/*
	 * Metodo que crea los puestos y los guarda en la matriz con los puestos, teniendo en cuenta que los puestos 
	 * de la diagonal principal son de primera clase, los que esten por encima de ella vip y los otros general.
	 * los puestos se enumeran de acuerdo a su tipo, es decir cada tipo empieza a contar desde cero
	 * */
	
	public void crearPuestos() {
		
		int contadorVip = 0;
		int contadorGeneral = 0;
		int contadorPrimeraClase = 0;
		
	for (int i = 0; i < puestos.length; i++) {
		for (int j = 0; j < puestos[0].length; j++) {
			if(i==j) { //Diagonal principal
				puestos[i][j] = new Puesto(contadorPrimeraClase++, TipoPuesto.PRIMERACLASE);
				
			}
			else {
				if(j>i) {//Encima de la diagonal principal
					puestos[i][j]= new Puesto(contadorVip++, TipoPuesto.VIP);
				}
				else { //i>j Debajo de la diagonal principal
					puestos[i][j] = new Puesto(contadorGeneral++, TipoPuesto.GENERAL);
				}
			}
		}
	}	
		
		
	}
	/*
	 * Metodo que retorna el primer puesto libre;
	 * 
	 * 
	 * 
	 * 
	 * */
	public Puesto buscarPuestoDisponible() {
		Puesto puesto = null;
		for (int i = 0; i < puestos.length && puesto== null; i++) {
			for (int j = 0; j < puestos[i].length && puesto == null; j++) {
				if(puestos[i][j].isDisponible()) {
					puesto= puestos[i][j];
				}
				
			}
			
		}
		return puesto;
	}
	
	/*
	 * Metodo que retorna el primer puesto libre de un tipo de silla especificado;
	 * 
	 * 
	 * 
	 * 
	 * */
	public Puesto buscarPuestoDisponibleXTipo(TipoPuesto tipo) {
		Puesto puesto = null;
		for (int i = 0; i < puestos.length && puesto== null; i++) {
			for (int j = 0; j < puestos[i].length && puesto == null; j++) {
				if(puestos[i][j] != null && puestos[i][j].getTipo() == tipo && puestos [i][j].isDisponible()) {
					puesto= puestos[i][j];
				}
				
			}
			
		}
		return puesto;
	}
	
	
	/*
	 * Metodo que ocupa un puesto de la sala dado su número.
	 * 
	 * */
	public void ocuparPuesto(int puesto) {
		boolean salir = false;
		for (int i = 0; i < puestos.length && !salir; i++) { // arreglo.length
			for (int j = 0; j < puestos[i].length && !salir; j++) {
				if (puestos[i][j]!= null && puestos[i][j].getNumero() == puesto) {
					puestos[i][j].setDisponible(false);
					salir = true;
				}
			}
		}
		
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
	 * @return the pelicula
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}

	/**
	 * @param pelicula the pelicula to set
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	public int calcularOcupacionSala() {
	  int contadorPuestos=0;
	  for (int i = 0; i < puestos.length; i++) {
		for (int j = 0; j < puestos[i].length; j++) {
			contadorPuestos+= !puestos[i][j].isDisponible()? 1:0;
		    }
	     }
	   return contadorPuestos;	
	  }
	
	/**
	 * Metodo que retorna en String los puestos que hay con su informacion, tipo, numero.
	 * @return
	 */
	public String PuestosToString() {
		String mensaje= "";
		for(int i=0; i< puestos.length; i++) {
			for (int j = 0; j < puestos[0].length; j++) {
				mensaje+= puestos[i][j].getNumero()+":"+puestos[i][j].getTipo().toString();
			}
		}
		return "";
	}

	/**
	 * metodo que retorna la cantidad de puestos en los extremos
	 * @return
	 */
	public int calcularOcupacionExtremo() {
		int cantidad=0;
		for (int i = 0; i < puestos.length; i++) {
			for (int j = 0; j < puestos[i].length; j++) {
				if(!puestos[i][j].isDisponible() && 
				   (i==0 || j==0 || i== puestos.length-1 || j== puestos.length-1)) {
					cantidad ++;
				}
			}
		}
		
		return cantidad;
	}
	
	public int calcularPuestosExtremo() {
		int cantidad=0;
		for (int i = 0; i < puestos.length; i++) {
			for (int j = 0; j < puestos[i].length; j++) {
				if(!puestos[i][j].isDisponible() && puestos[i][j].isDisponible() &&
				   (i==0 || j==0 || i== puestos.length-1 || j== puestos.length-1)) {
					cantidad ++;
				}
			}
		}
		
		return cantidad;
	}
	
     /**
      * Metodo para obtener el numero del marco con mas puestos ocupados
     * @return
     */
    public int calcularMarcoMayorOcupacion() {
    	int marcoMax=0;
    	int aux1 =0;
    	int k = 1;
    	ArrayList<Integer> marco = new ArrayList<>();
    	
    	
    	for (int i = 0; i < puestos.length; i++) {
			for (int j = 0; j < puestos[i].length; j++) {
				if(!puestos[i][j].isDisponible()) {
					if(i==k || j==k || i== puestos.length - k || j== puestos[i].length - k) {
						aux1 ++;
						k++;
					  }
					marco.add(aux1);
					for(i = 0;i<marco.size();i++) {
			                if(marco.get(i)>marcoMax) {
			                	marcoMax=i;
			                } 
			            }
					}
				}
			}
		 
    	 
    	 
    	return marcoMax;
     }
		
}
