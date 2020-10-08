package colecciones.cola;


/**
* Esta clase representa una cola de objetos <b>first in first out (FIFO)</b> donde el primer elemento insertado es el primero que se accede.
* Las operaciones ofrecidas por cualquier implementación de esta clase son:
* <p>
* <ul>
*   <li> encolar	: Encola un nuevo elemento y evaluar si fue encolado con exito</li>
*   <li> desencolar	: Desencola y retorna el primer elemento</li>
*   <li> primero	: Retorna el primer elemento sin desencolarlo</li>
*   <li> esVacia	: Permite consultar si la cola está vacía</li>
*   <li> vaciar		: Remueve todos los elementos de la cola</li>
*   <li> elementos	: Retornar la cantidad de elementos presentes</li>
*   <li> repOK		: Permite validar si una instancia satisface el invariante de representación</li>
*   <li> toString	: Retorna una representación en forma de cadena</li>
*   <li> equals		: Permite evaluar si otra instancia de cola es igual a esta</li>
* </ul>
*/
public interface Cola<T> {
	
	/**
	* Permite evaluar si la cola no tiene elementos.
	* @return {@code true} sii la cola no tiene elementos
	*/
	public boolean esVacia();

	/**
	* Encola un elemento en el comienzo de la cola.
	* @param elem el elemento a encolar
	* @return {@code true} sii el elemento pudo ser encolado
	*/
	public boolean encolar(T elem);

	/**
	* Desencola el primer elemento de la cola, y retorna el elemento desencolado, si ésta no es vacía.
	* @return el primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	public T desencolar();

	/**
	* Retorna el primero de la cola, si ésta no es vacía.
	* @return primer elemento de la cola
	* @throws IllegalStateException si la cola está vacía
	* @see #esVacia()
	*/
	public T primero();

	/**
	* Remueve todos los elementos en la cola.
	*/
	public void vaciar();

	/**
	* @return cantidad de elementos en la cola.
	*/
	public int elementos();

	/**
	* Invariante de clase.
	* @return {@code true} sii la cola satisface su invariante de clase
	*/
	public boolean repOK();

	@Override
	public String toString();

	@Override
	public boolean equals(Object other);

}
