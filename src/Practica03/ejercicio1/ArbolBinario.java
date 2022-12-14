package tp03.ejercicio1;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}
	
	public void inOrder() {
		if (this.tieneHijoIzquierdo()) {
			this.getHijoIzquierdo().inOrder();
		}
		System.out.println(this.getDato());
		if (this.tieneHijoDerecho()) {
			this.getHijoDerecho().inOrder();
		}
	}
		

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}
	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		int suma = 0;
			if (this.esHoja())
				suma++;
			if (tieneHijoIzquierdo())
				suma += this.getHijoIzquierdo().contarHojas();
			if(tieneHijoDerecho()) 
				suma += this.getHijoDerecho().contarHojas();		
		return suma;
	}
	
	

    public ArbolBinario<T> espejo() {
		
		return null;
	}


	public void entreNiveles(int n, int m){		
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>(); 
		cola.encolar(this);
		cola.encolar(null);
		int nivel = 0;
		while (!cola.esVacia()) {
			arbol = cola.desencolar();			
			if (arbol != null){				
				if ((nivel >= n) && (nivel <= m))			
					System.out.println(arbol.getDato());
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.hijoIzquierdo);
				if (arbol.tieneHijoDerecho()) 
					cola.encolar(arbol.hijoDerecho);				
			}else if(!cola.esVacia()) {
					System.out.println();
					cola.encolar(null);
					nivel++;
			}	
		}
	}
}



	

