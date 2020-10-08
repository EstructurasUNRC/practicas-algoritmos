package colecciones.pila;

import java.util.Collection;

/**
* Implementación basada en arreglos de tamaño dinámico de la interfaz {@code Pila}.
* Cuando el arreglo asociado se llena, un nuevo arreglo con mayor capacidad es creado para tomar su lugar.
* @see colecciones.pila.Pila
*/
public class PilaArregloDinamico<T> implements Pila<T> {

	/**
	* Capacidad inicial por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	/**
	* Incremento por defecto ({@value #INCREMENTO_POR_DEFECTO})
	*/
	public static final float INCREMENTO_POR_DEFECTO = 0.5f;
	private float incremento;
	private Object[] arreglo;
	private int elementos = 0;

	/**
	* Construye una nueva pila vacía con una capacidad inicial de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public PilaArregloDinamico() {
		this(CAPACIDAD_POR_DEFECTO, INCREMENTO_POR_DEFECTO);
	}

	/**
	* Construye una nueva pila vacía con una capacidad inicial determinada mayor a 0, y un incremento de {@value #INCREMENTO_POR_DEFECTO}
	* @param capacidadInicial la capacidad de la pila
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	public PilaArregloDinamico(int capacidadInicial) {
		this(capacidadInicial, INCREMENTO_POR_DEFECTO);
	}

	/**
	* Construye una nueva pila vacía con una capacidad y un incremento determinados mayores a 0.
	* @param capacidadInicial la capacidad inicial de la pila
	* @param incremento la taza de incremento de la pila
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0
	* @throws IllegalArgumentException si {@code incremento} es menor o igual a 0
	*/
	public PilaArregloDinamico(int capacidadInicial, float incremento) {
		if (capacidadInicial <= 0)
			throw new IllegalArgumentException("capacidad debe ser mayor a cero (" + capacidadInicial + ")");
		if (incremento <= 0)
			throw new IllegalArgumentException("incremento debe ser mayor a cero (" + incremento + ")");
		arreglo = new Object[capacidadInicial];
		this.incremento = incremento;
	}

	/**
	* Construye una pila a partir de elementos en una colección.
	* Los elementos en la colección se apilan de izquierda a derecha.
	* La capacidad de la pila va a ser suficiente para al menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la pila
	*/
	public PilaArregloDinamico(Collection<T> elems) {
		this(elems, INCREMENTO_POR_DEFECTO);	
	}

	/**
	* Construye una pila a partir de elementos en una colección con una taza de incremento determinada.
	* Los elementos en la colección se apilan de izquierda a derecha.
	* La capacidad de la pila va a ser suficiente para al menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la pila
	* @param incremento la taza de incremento de la pila
	* @throws IllegalArgumentException si {@code incremento} es menor o igual a 0
	*/
	public PilaArregloDinamico(Collection<T> elems, float incremento) {
		throw new UnsupportedOperationException("Implementar y eliminar esta sentencia");
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
