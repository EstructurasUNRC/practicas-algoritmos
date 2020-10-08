package colecciones.pila;

import java.util.Collection;

/**
* Implementación basada en arreglos de tamaño fijo de la interfaz {@code Pila}.
* @see colecciones.pila.Pila
*/
public class PilaArregloFijo<T> implements Pila<T> {

	/**
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos = 0;

	/**
	* Construye una nueva pila vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public PilaArregloFijo() {
		this(CAPACIDAD_POR_DEFECTO);
	}

	/**
	* Construye una nueva pila vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la pila
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	public PilaArregloFijo(int capacidad) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("capacidad debe ser mayor a cero (" + capacidad + ")");
		arreglo = new Object[capacidad];
	}

	/**
	* Construye una pila a partir de elementos en una colección.
	* Los elementos en la colección se apilan de izquierda a derecha.
	* La capacidad de la pila va a ser suficiente para al menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la pila
	*/
	public PilaArregloFijo(Collection<T> elems) {
		//TODO: el arreglo debe ser capaz de almacenar al menos todos los elementos de la colección	
	}

	@Override
	public boolean apilar(T e) {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
		//TODO: completar
	}


	@Override
	public void vaciar() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
		//TODO: completar
	}

	@Override
	public boolean esVacia() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
		//TODO: completar
	}

	@Override
	public T tope() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
		//TODO: completar
	}

	@Override
	public T desapilar() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
		//TODO: completar
	}
	
	@Override
	public int elementos() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
		//TODO: completar
	}

	@Override
	public boolean repOK() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
		//TODO: completar
		//no debe haber ciclos
		//la cantidad de nodos accesibles desde tope debe ser igual a el valor del atributo elementos	
	}

	@Override
	public String toString() {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
		//TODO: completar	
	}

	@Override
	public boolean equals(Object other) {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
		//TODO: completar
	}

	/**
	* Permite obtener un elemento del arreglo en un indice determinado realizando el casteo necesario.
	* @param index el indice del elemento a obtener
	*/
	@SuppressWarnings("unchecked")
   	private T elemento(int index) {
        	return (T) arreglo[index];
    	}

}
