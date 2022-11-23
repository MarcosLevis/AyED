package ejercicio5;

import ejercicio1.Arista;
import ejercicio1.Grafo;
import ejercicio1.Vertice;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class DfsGrafoCompleto<T> {

	public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo){
		ListaGenerica<Vertice<T>> lista = new ListaEnlazadaGenerica<Vertice<T>>();
		boolean [] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		for (int i = 1; i < grafo.listaDeVertices().tamanio() ; i++) {
			if(!marca[i]) {
				enProfundidad(i,marca,grafo,lista);
			}
		}
		return lista;
	}
	
	private void enProfundidad(int i, boolean[] marca, Grafo<T> grafo, ListaGenerica<Vertice<T>> lista ) {
		marca[i] = true;		
		int j = 0;
		Arista<T> arista = null;
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		lista.agregarFinal(v);
		ListaGenerica<Arista<T>> adyac = grafo.listaDeAdyacentes(v);
		adyac.comenzar();
		while (!adyac.fin()) {
			arista = adyac.proximo();
			j = arista.verticeDestino().getPosicion();
			if(!marca[j])
				enProfundidad(j,marca,grafo,lista);
		}		
	}
}
