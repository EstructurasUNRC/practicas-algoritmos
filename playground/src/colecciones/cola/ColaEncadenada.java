package colecciones.cola;

import colecciones.nodos.Nodo;
import java.util.Collection;

/**
* Implementación basada en nodos simplemente encadenados de la interfaz {@code Cola}.
* @see colecciones.cola.Cola
*/
public class ColaEncadenada<T> implements Cola<T> {

	/**
	* Referencia al primer elemento a desencolar
	*/
	private Nodo<T> primero = null;
	/**
	* Referencia al último elemento encolado
	*/
	private Nodo<T> ultimo = null;
	/**
	* Cantidad de elementos en la cola
	*/
	private int elementos = 0;

	/**
	* Construye una cola vacía.
	*/
	public ColaEncadenada() {}

	/**
	* Construye una cola a partir de elementos en una colección.
	* Los elementos en la colección se encolan de izquierda a derecha
	* @param elems los elementos a agregar a la cola
	*/
	public ColaEncadenada(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		for (T e : elems) {
			encolar(e);		
		}
	}

	@Override
	public boolean esVacia() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
	}

	@Override
	public int elementos() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
	}

	@Override
	public boolean encolar(T elem) {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");		
	}

	@Override
	public T desencolar() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
	}

	@Override
	public T primero() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");	
	}

	@Override
	public void vaciar() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");	
	}

	@Override
	public boolean repOK() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");	
	}

	@Override
	public String toString() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");	
	}

	@Override
	public boolean equals(Object other) {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");	
	}

}
