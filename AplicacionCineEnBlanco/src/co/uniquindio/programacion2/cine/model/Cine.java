package co.uniquindio.programacion2.cine.model;

import java.util.ArrayList;

public class Cine {

	private  ArrayList <Sala> listaSalas;
	public Cine () {
		/*
		 * instanciar lista de Salas
		 * 
		 * 
		 * */
		this.listaSalas = new ArrayList<Sala>();
		
	}
	/*
	 * METODO PARA ADICIONAR UNA SALA
	 * */
	private void adicionarSala(Sala sala) throws yaExiste {
		//valida si ya existe
		int posicion = buscarSala(sala.getNombre());
		if(posicion == -1) {
			listaSalas.add(sala);
		}
		else {
			throw new yaExiste("Ya existe la sala");
		}
		
		
	}
	/*
	 * Metodo que busca el indice de una sala dado su nombre
	 * */
	public int buscarSala(String nombre) {
		int posicion=-1;
		for (int i = 0; i < listaSalas.size() && posicion == -1; i++) {
			if(listaSalas!= null && listaSalas.get(i).getNombre().equalsIgnoreCase(nombre));
			   posicion = i;
		}
		return posicion;
	}
	public int buscarSalaLibre() {
		int posicion = -1;
		for (int i = 0; i < listaSalas.size() && posicion == -1; i++) {
			 if(listaSalas.get(i)== null) {
				 posicion=i;
			 }
		}
	return posicion;
	}
	/*
	 * METODO QUE RETORNA EL INDICE DE LA SALA QUE ESTE PROYECTANDO UNA PELÍCULA
	 * 
	 * */
	public int buscarSalaXPelicula(Pelicula pelicula) {
		int posicion=-1;
		for (int i = 0; i < listaSalas.size() && posicion == -1; i++) {
			   if(listaSalas.get(i).getPelicula().equals(pelicula));
		           posicion= i;
		}
		return posicion;
	}
	
	/*
	 * METODO QUE ASIGNA UN PUESTO EN UNA SALA DE ACUERDO AL TIPO DE SILLA ESCOGIDO POR
	 * EL USUARIO.
	 * 
	 * RETORNA EL NUMERO DE LA SILLA
	 * */
	public Puesto asignarPuestoSala(String nombreSala, TipoPuesto Tipo) throws elPuestoEstaOcupado {
		Puesto silla;
		int posicion= buscarSala(nombreSala);
		if(posicion!= -1) {
			silla=listaSalas.get(posicion).buscarPuestoDisponibleXTipo(Tipo);
			}
		
		else {
			throw new elPuestoEstaOcupado("El puesta ya esta ocupado");
		}
		return silla;
	}
	
	/**
	 * Metedo que calcula la sillas ocupadas en los extremos
	 * @return
	 */
	public int calcularSillasExtremoOcupadas() {
        int cantidad=0;
        for (int i = 1; i < listaSalas.size(); i++) {
            cantidad += listaSalas.get(i).calcularOcupacionExtremo();
        }
        return cantidad;
    }
	/**
	 * Metodo que me devuelve la sala con mayor ocupación
	 * @return
	 */
	public Sala obtenerSalaMayorOcupacion() {
		Sala salaMasOcupada=listaSalas.get(0);
		for (int i = 0; i < listaSalas.size(); i++) {
			if(listaSalas.get(i).calcularOcupacionSala()> salaMasOcupada.calcularOcupacionSala()) {
				salaMasOcupada= listaSalas.get(i);
			}
		}
		return salaMasOcupada;
	}
	
	/**
	 * metodo que me retorna el marco de la sala mas ocupado
	 * @return
	 */
	public int calcularMarcoMaxOcupado() {
		int nivelDelMarco=0;
        for (int i = 1; i < listaSalas.size(); i++) {
            nivelDelMarco += listaSalas.get(i).calcularMarcoMayorOcupacion();
        }
        return nivelDelMarco;
    
	}
	
	/**
	 * metodo para obtener la cantidad de sillas del marco del cine sean
	 * reservadas totalmente
	 * @return
	 */
	public int sillasCompletasExtremos() {
		int cantidad=0;
		for (int i = 0; i < listaSalas.size(); i++) {
			cantidad += listaSalas.get(i).calcularPuestosExtremo();
		}
	    return cantidad;
	}
	
	
}
