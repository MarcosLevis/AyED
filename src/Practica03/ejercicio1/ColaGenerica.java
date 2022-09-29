package tp03.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ColaGenerica<T>{
	private ListaGenerica<T> datos;
	public ColaGenerica() {
		this.datos = new ListaEnlazadaGenerica<>();
		
	}
	public void encolar(T elem) {
		this.datos.agregarFinal(elem);
	}
	public T desencolar() {
		T aux = this.tope();
		this.datos.eliminarEn(1);
		return aux;
	}
	public T tope() {
		return this.datos.elemento(1);
	}
	public boolean esVacia() {
		return this.datos.esVacia();
	}

}
