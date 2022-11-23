package ejercicio5;

import ejercicio1.Arista;
import ejercicio1.Grafo;
import ejercicio1.Vertice;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class DfsPrimerCamino {
	private Grafo<String> grafo;
	
	public ListaGenerica<String> primerCamino(String cOrigen, String cDestino){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		Vertice<String> origen = buscarVertice(cOrigen);
		Vertice<String> destino = buscarVertice(cDestino);
		boolean [] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
		dfs(origen,destino,marca,camino);
		return camino;
	}
	
	public boolean dfs(Vertice<String> origen, Vertice<String> destino,boolean [] marca, ListaGenerica<String> camino) {
		boolean encontre = false;
		marca[origen.getPosicion()] = true;
		camino.agregarFinal(origen.dato());
		if (origen.dato().equals(destino.dato())) {
			encontre = true;
		} else {
			ListaGenerica<Arista<String>> adyac = grafo.listaDeAdyacentes(origen);
			adyac.comenzar();
			while ((!adyac.fin()) && (!encontre)) {
				Arista<String> arista = adyac.proximo();
				if(!marca[arista.verticeDestino().getPosicion()]) {
					encontre = dfs(arista.verticeDestino(),destino,marca,camino);
				}
				if (!encontre) {
					camino.eliminarEn(camino.tamanio());
				}
			}
		}
		return encontre;
	
		
		
		
	}
	
	
	
	
	
	private Vertice<String> buscarVertice(String dato){
		ListaGenerica<Vertice<String>> lista = this.grafo.listaDeVertices();
		lista.comenzar();
		while (!lista.fin()) {
			Vertice<String> este = lista.proximo();
			if (este.dato().equals(dato)) {
				return este;
			}
		}
		return null;
	}
}
