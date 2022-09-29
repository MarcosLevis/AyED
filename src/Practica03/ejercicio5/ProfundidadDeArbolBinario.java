package tp03.ejercicio5;

import tp03.ejercicio1.ArbolBinario;
import tp03.ejercicio1.ColaGenerica;

public class ProfundidadDeArbolBinario {
	ArbolBinario<Integer> arbol;
	
	public ProfundidadDeArbolBinario(ArbolBinario<Integer> a) {
		this.arbol = a;
	}
	
	public int sumaElementosProfundidad(int p) {
		ArbolBinario<Integer> a = this.arbol;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		int nivel = 0;
		int total = 0;
		int rep = 0;
		cola.encolar(a);
		cola.encolar(null);
		while (!cola.esVacia()) {
			a = cola.desencolar();
			if (a != null){			
				if(nivel == p) {
					total += a.getDato();
				}
				if (a.tieneHijoIzquierdo()) 
					cola.encolar(a.getHijoIzquierdo());				
				if(a.tieneHijoDerecho()) 
					cola.encolar(a.getHijoDerecho());
			}else if(!cola.esVacia()){
				cola.encolar(null);
				nivel++;
				System.out.println("Nivel: " + nivel);
			}
		}
		
		return total;
	}
	
}
