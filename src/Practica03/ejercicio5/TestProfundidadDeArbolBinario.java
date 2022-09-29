package tp03.ejercicio5;

import tp03.ejercicio1.ArbolBinario;

public class TestProfundidadDeArbolBinario {

	public static void main(String[] args) {
		ArbolBinario<Integer> raiz = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> HI= new ArbolBinario<Integer>(2);
		ArbolBinario<Integer> HD = new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> HI1 = new ArbolBinario<Integer>(4);
		ArbolBinario<Integer> HD1 = new ArbolBinario<Integer>(5);
		ArbolBinario<Integer> HI2 = new ArbolBinario<Integer>(6);
		ArbolBinario<Integer> HD2 = new ArbolBinario<Integer>(7);
		
		raiz.agregarHijoIzquierdo(HI);
		raiz.agregarHijoDerecho(HD);		
		HI.agregarHijoIzquierdo(HI1);
		HI.agregarHijoDerecho(HD1);
		HD.agregarHijoIzquierdo(HI2);
		HD.agregarHijoDerecho(HD2);
		
		ProfundidadDeArbolBinario test = new ProfundidadDeArbolBinario(raiz);
		System.out.println(test.sumaElementosProfundidad(1));
	}

}
