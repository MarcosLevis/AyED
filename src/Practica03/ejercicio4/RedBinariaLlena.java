package tp03.ejercicio4;
import tp03.ejercicio1.ArbolBinario;

public class RedBinariaLlena {
	
	private ArbolBinario<Integer> arbol;
	
	public RedBinariaLlena(ArbolBinario<Integer> a) {
		this.arbol = a;
	}
	
	
	public int retardoEnvio() {
		return retardoEnvio(this.arbol);
	}
	private int retardoEnvio (ArbolBinario<Integer> arbol) {
		int retardo = 0;
		if (arbol.esVacio())
			return -1;
		if (arbol.esHoja())
			return arbol.getDato();
		else {
			if(arbol.tieneHijoIzquierdo()) 
				retardo = Math.max(retardo, retardoEnvio(arbol.getHijoIzquierdo()));
			if(arbol.tieneHijoDerecho()) 
				retardo = Math.max(retardo, retardoEnvio(arbol.getHijoDerecho()));
		}
		
		return retardo + arbol.getDato();
	}
}