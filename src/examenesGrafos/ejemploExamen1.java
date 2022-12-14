//Se cuenta con un mapa de localidades de la provincia de Mendoza y en las vacaciones de invierno se quiere realizar un paseo en auto cumpliendo las siguientes restricciones:

//    • El recorrido debe comenzar en la ciudad de “Mendoza”.
//    • No hay un punto especifico de destino para el recorrido.
//    • El recorrido debe permitir visitar al menos una cantidad X de localidades, no consumir más de Y litros de nafta y NO debe pasar por ciertas localidades. Los datos se reciben como parámetro.
//    •  Cualquier camino que cumpla con las condiciones es considerado válido.
//    • En caso de no existir recorrido posible, debe devolver una lista vacía.
//    • El camino no debe pasar dos veces por la misma localidad.

//Escriba el método:
//public ListaGenerica<String> recorrido(Grafo<String> grafo, int cantLocalidades, int cantNafta, ListaGenerica<String> localidadesExceptuadas)





public ListaGenerica<String> recorrido(Grafo<String> grafo, int cantLocalidades, int cantNafta, ListaGenerica<String> localidadesExceptuadas){
	ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
	boolean [] marca = new boolean[gafo.listaDeVertices().tamanio() + 1];
	Vertice<String> origen = buscarVertice(grafo);
	dfs(grafo, camino, marca,origen, cantLocalidades - 1, cantNafta, localidadesExceptuada);
	return camino;
}

private void dfs(Grafo<String> grafo, ListaGenerica<String> camino, boolean [] marca, Vertice<String> origen, int cantLocalidades, int cantNafta, ListaGenerica<String> localidadesExceptuadas){
	marca [origen.posicion()] = true;
	camino.agregarAlFinal(origen.dato());
	ListaGenerica<Arista<String>> adyac = origen.obtenerAdyacentes();
	adyac.comenzar();
	while ((!adyac.fin()) && (cantLocalidades > 0)){
		Arista<String> arista = adyac.proximo();
		Vertice<String> vertice = arista.verticeDestino()
		if ((!marca[vertice.posicion()) && (cantLocalidades > 0) && ((cantNafta - arista.peso()) > 0) && (!localidadesExceptuadas.incluye(vertice.dato())){
			dfs(grafo,camino,marca,vertice,cantLocalidades - 1, cantNafta - arista.peso(), localidadesExceptuadas);
		}			    
	}
	camino.eliminarEn(camino.tamanio);	///esta bien
	marca [origen.posicio()] = false;
}

private Vertice<String> buscarVertice(Grafo<String> grafo){
	ListaGenerica<Vertice<String> lista = grafo.listaDeVertices();
	Vertice<String> vertice = null;
	lista.comenzar();
	while (!lista.fin()){
		vertice = lista.proximo()
		if (vertice.dato().equals("Mendoza")){
			return vertice;
		}
	}
	return null;
}
