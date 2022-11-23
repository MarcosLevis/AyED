package ejercicio5;

import ejercicio1.Arista;
import ejercicio1.Grafo;
import ejercicio1.Vertice;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class DfsCaminoMasCorto {

	private Grafo<String> grafo;
	
	public ListaGenerica<String> caminoMasCorto(String cOrigen, String cDestino){
		ListaGenerica<String> actual = new ListaEnlazadaGenerica<String>();
		ListaGenerica<String> minimo = new ListaEnlazadaGenerica<String>();
		boolean [] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		Vertice<String> origen = buscarVertice(cOrigen);
		Vertice<String> destino = buscarVertice(cDestino);
		int distActual = 0;
		int distMinima = 0;
		dfs(origen,destino,marca,actual,minimo,distActual,distMinima);
		return minimo;		
	}
	
	public void dfs(Vertice<String> origen, Vertice<String> destino, boolean [] marca, ListaGenerica<String> actual, ListaGenerica<String> minimo, int distActual, int distMinima){
		marca[origen.getPosicion()] = true;
		actual.agregarFinal(origen.dato());
		if(origen.dato().equals(destino.dato())) {			
			if(distActual < distMinima) {
				distMinima = distActual;
				minimo.eliminarTodos();
				actual.comenzar();
				while(!actual.fin()) {
					minimo.agregarFinal(actual.proximo());
				}
			}
		}else{
			ListaGenerica<Arista<String>> adyac = grafo.listaDeAdyacentes(origen);
			adyac.comenzar();
			while (!adyac.fin()) {
				Arista<String> arista = adyac.proximo();				
				if ((!marca[arista.verticeDestino().getPosicion()]{
					distActual += arista.peso();
					dfs(arista.verticeDestino(),destino,marca,actual,minimo,distActual,distMinima);
					distActual -= arista.peso();
				}				
			}
						
		}
				     
		marca[arista.verticeDestino().getPosicion()] = false;
		actual.eliminarEn(arista.verticeDestino().getPosicion());
	}
	
	
	
	private Vertice<String> buscarVertice(String ciudad){
		ListaGenerica<Vertice<String>> lista = grafo.listaDeVertices();
		lista.comenzar();
		while (!lista.fin()) {
			Vertice<String> v = lista.proximo();
			if (v.dato().equals(ciudad)) {
				return v;
			}
		}
		return null;
	}
}
