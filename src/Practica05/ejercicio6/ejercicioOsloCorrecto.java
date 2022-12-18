Ejercicio 6
Se quiere realizar un paseo en bicicleta por lugares emblemáticos de Oslo. Para esto se cuenta con un grafo de
bicisendas. Partiendo desde el “Ayuntamiento” hasta un lugar destino en menos de X minutos, sin pasar por
un conjunto de lugares que están restringidos.
Escriba una clase llamada VisitaOslo e implemente su método:
ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo,
ListaGenerica<String> lugaresRestringidos)


Notas:
 El “Ayuntamiento” debe ser buscado antes de comenzar el recorrido para encontrar un camino.
 De no existir camino posible, se debe retornar una lista vacía.
 Debe retornar el primer camino que encuentre que cumple las restricciones.
 Ejemplos de posibles caminos a retornar, sin pasar por “Akker Brigge” y “Palacio Real” en no más de
120 min (maxTiempo)


public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> LugaresRestringidos){
	
	ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
	Vertice<String> origen = buscarVertice(lugares);
	boolean [] marca = new boolean[lugares.listaDeVertices().tamanio()+1];
	dfs(lugares,camino,origen,marca,destino,maxTiempo,lugaresRestringidos);
	return camino;
}

private boolean dfs(Grafo<String> lugares, ListaGenerica<String> camino, Vertice<String> origen, boolean [] marca, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){
	boolean encontre = false;
	marca[origen.posicion()] = true;
	camino.agregarAlFinal(origen.dato());
	if (origen.dato().equals(destino)){
		encontre = true;
	}else {
		ListaGenerica<Arista<String>> adyac = lugares.obtenerAdyacentes();
		adyac.comenzar();
		while ((!adyac.fin()) && (!encontre)){
			Arista<String> arista = adyac.proximo();
			Vertice<String> vertice = arista.verticeDestino();
			if ((!marca[vertice.posicion()) && (!encontre) && ((maxTiempo - arista.peso()) >= 0) && (!lugaresRestringidos.contiene(vertice.dato())){
				encontre = dfs(lugares,camino,vertice,marca,destino, maxTiempo - arista.peso(),lugaresRestringidos);
			}
		}
	}
	if (!encontre){
		camino.eliminarEn(camino.tamanio());
		marca[origen.posicion()] = false;
	}
	return encontre;
}

private Vertice<String> buscarVertice(Grafo<String> lugares){
	ListaGenerica<Vertice<String>> lista = lugares.listaDeVertices()
	lista.comenzar();
	while (!lista.fin()){
		Vertice<String> vertice = lista.proximo();
		if (vertice.dato().equals("Ayuntamiento"){
			return vertice;
		}
	}
	return null;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			
