package tp03.ejercicio1;

public class MainArbolEj3 {

	public static void main(String[] args) {
		ArbolBinario<Integer> arbol = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> hijoIzquierdo= new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> hijoDerecho = new ArbolBinario<Integer>(3);
		hijoIzquierdo.agregarHijoIzquierdo(new ArbolBinario<Integer>(4));
		hijoIzquierdo.agregarHijoDerecho(new ArbolBinario<Integer>(5));
		hijoDerecho.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
		hijoDerecho.agregarHijoDerecho(new ArbolBinario<Integer>(8));
		arbol.agregarHijoIzquierdo(hijoIzquierdo);
		arbol.agregarHijoDerecho(hijoDerecho);
		
		System.out.println(arbol.contarHojas());
		
	}

}
