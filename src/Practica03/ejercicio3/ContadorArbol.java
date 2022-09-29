package tp03.ejercicio3;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ContadorArbol{
	private ArbolBinario<Integer> arbol;
	
	public ContadorArbol(ArbolBinario<Integer> a) {
		this.arbol = a;
	}
	
	public ListaGenerica<Integer> numerosPares(){
		ListaEnlazadaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
		System.out.println("Numeros Pares InOrden: ");
		inOrden(this.arbol,lista);		
		return lista;
	}
	
	private void inOrden(ArbolBinario<Integer> arbol, ListaEnlazadaGenerica<Integer> lista) {
		if (arbol.tieneHijoIzquierdo()){
			inOrden(arbol.getHijoIzquierdo(),lista);			
		}
		if (arbol.getDato()%2 == 0) {
			lista.agregarFinal(arbol.getDato());
		}
		if (arbol.tieneHijoDerecho()) {
			inOrden(arbol.getHijoIzquierdo(),lista);
		}
	}
	private void preOrden(ArbolBinario<Integer> arbol, ListaEnlazadaGenerica<Integer> lista) {
		
		if (arbol.getDato()%2 == 0) {
			lista.agregarFinal(arbol.getDato());
		}
		if (arbol.tieneHijoIzquierdo()){
			preOrden(arbol.getHijoIzquierdo(),lista);			
		}
	
		if (arbol.tieneHijoDerecho()) {
			preOrden(arbol.getHijoIzquierdo(),lista);
		}
	}

}
