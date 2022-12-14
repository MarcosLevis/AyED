public class Examen {
    private Grafo mapaEstadios;

    public ListaGenerica<Estadio> estadios(Grafo mapaEstadios, String estadioOrigen, int cantKm){
        ListaGenerica<ListaGenerica<String>> caminosMaximos = new ListaEnlazadaGenerica<ListaEnlazadaGenerica<String>>();
        ListaGenerica<Sring> caminoActual = new ListaEnlazadaGenerica<String>();
        Vertice<Estadio> origen = buscarVertice(estadioOrigen, mapaEstadios);
        boolean [] marca = new boolean[mapaEstadios.listaDeVertices().tamanio() + 1];
        int distanciaRecorrida = 0;        
        dfs(mapaEstadios, caminoActual, caminosMaximos, origen, marca, cantKm);
        return caminosMaximos;
    }

    private void dfs(Grafo mapaEstadios; ListaEnlazadaGenerica<String> caminoActual; ListaGenerica<ListaEnlazadaGenerica<String>> caminosMaximos; Vertice<Estadio> origen; boolean [] marca; int distanciaRecorrida; int cantKm){       
        marca [origen.posicion()] = true;
        caminoActual.agregarAlFinal(origen.dato().nombre());
        Vertice<Estadio> vertice = null;
        Arista<Estadio> arista = null;                
        ListaGenerica<Arista<Estadio>> adyac = origen.obtenerAdyacentes();
        adyac.comenzar;
        while (!adyac.fin()){
            arista = adyac.proximo();
            vertice = arista.destino();
            
            if ((!marca[vertice.posicion()]) && (distanciaRecorrida + arista.peso() <= cantKm)){
                dfs(mapaEstadios, caminoActual, caminosMaximos, vertice, marca, distanciaRecorrida + arista.peso() , cantKm);
             }else if (distanciaRecorrida > cantKm){
                ListaGenerica<Estadio<String>> camino = caminoActual.clonar();
                caminosPosibles.agregarAlFinal(camino);
                }            
        }
        caminoActual.eliminarEn(caminoActual.tamanio());
        marca [origen.posicion()] = false;
    }
                














                
            
