package ejercicio6;

import ejercicio1.Arista;
import ejercicio1.Grafo;
import ejercicio1.Vertice;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class VisitaOslo {
	
	
	///corregir, esta mal creo
	
	
	public ListaGenerica<String> pasoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		boolean [] marca = new boolean[lugares.listaDeVertices().tamanio() + 1];
		Vertice<String> origen = buscarVertice(lugares);
		int tiempo = 0;
		lugares.listaDeVertices().comenzar();
		dfs(origen,destino,marca,lugares,tiempo,camino,maxTiempo,lugaresRestringidos);
		return camino;		
	}
	
	private boolean dfs(Vertice<String> origen,String destino, boolean [] marca, Grafo<String> lugares, int tiempo, ListaGenerica<String> camino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
		marca[origen.getPosicion()] = true;
		if (origen.equals(destino)) {
			return true;
		}
		else {
			lugares.listaDeAdyacentes(origen).comenzar();
			while (!lugares.listaDeAdyacentes(origen).fin()) {
				Arista<String> arista = lugares.listaDeAdyacentes(origen).proximo();			
				tiempo += arista.peso();
				if ((tiempo < maxTiempo)&& (!marca[arista.verticeDestino().getPosicion()]) && (!esRestringido(arista.verticeDestino(),lugaresRestringidos))) {
					//nunca agrego al origen original al camino ..
					camino.agregarFinal(arista.verticeDestino().toString());					
					dfs(arista.verticeDestino(),destino,marca,lugares,tiempo,camino,maxTiempo,lugaresRestringidos);
				}
				tiempo -= arista.peso();/// el int no se pasa como referencia, ha yque borrarlo igual, nose
			}			
			camino.eliminarEn(camino.tamanio());				
			return false;
		}
			
	}
	
	private boolean esRestringido(Vertice<String> vertice,ListaGenerica<String> lugaresRestringidos) {
		lugaresRestringidos.comenzar();
		while (!lugaresRestringidos.fin()) {
			String lugar = lugaresRestringidos.proximo();
			if (lugar.equals(vertice.dato().toString())){
				return true;
			}			
		}
		return false;
	}
	
	private Vertice<String> buscarVertice(Grafo<String> lugares){
		lugares.listaDeVertices().comenzar();
		while (!lugares.listaDeVertices().fin()) {
			Vertice<String> v = lugares.listaDeVertices().proximo();
			if (v.dato().equals("Ayuntamiento")){
				return v;
			}
		}
		return null;
	}
}
