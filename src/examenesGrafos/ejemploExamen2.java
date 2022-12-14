//Se cuenta con información del precio de los peajes para transitar por las rutas que unen las distintas ciudades. Se quiere obtener un camino cualquiera que comience en una ciudad origen y permita llegar a otra ciudad destino sin sumar más de X pesos en el total a pagar en peajes. En caso de no existir camino deberá retornar una lista vacía.


ListaGenerica<String> caminoConPresupuesto(Grafo<String> ciudades, String origen, String destino, int montoMaximo)


public ListaGenerica<String> caminoConPresupuesto(Grafo<String> ciudades, String origen, String destino, int montoMaximo){
	ListaGenerica<String> camino = ListaEnlazadaGenerica<String>();
	boolean [] marca = new boolean[ciudades.listaDeVertices().tamanio()+1);
	Vertice<String> origenV = buscarVertice(ciudades,origen);
	dfs(ciudades,origenV, destino,marca,camino, montoMaximo);
	return camino;
}

private boolean dfs(Grafo<String> ciudades, Vertice<String> origen, String destino, boolean [] marca, ListaGenerica<String> camino, int montoMaximo){
	boolean encontre = false;
	marca [origen.posicion()] = true;
	camino.agregarAlFinal(origen.dato());
	if (origen.dato().equals(destino)){
		encontre = true;
	} else {
		ListaGenerica<Arista<String>> adyac = origen.obtenerAdyacentes();
		Arista<String> arista = null;
		Vertice<String> vertice = null;
		adyac.comenzar();
		while ((!adyac.fin() && (!encontre){
			arista = adyac.proximo();
			vertice = arista.destino():
			if ((!marca[vertice.posicion()) && (!encontre) && ((montoMaximo - arista.peso()) >= 0)){
				encontre = dfs(ciudades,vertice,destino,marca,camino,montoMaximo - arista.peso()):
			}
			if (!encontre){
				camino.eliminarEn(camino.tamanio);  ///esto pude ir afuerda del while tambien
				marca [origen.posicion()] = false;
			}
		}
	}
	return encontre;
}
