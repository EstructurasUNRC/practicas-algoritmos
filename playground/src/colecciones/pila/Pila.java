package colecciones.pila;

/**
* Esta clase representa una pila de objetos <b>first in last out (FILO)</b> donde el primer elemento insertado es el último que se accede.
* Las operaciones ofrecidas por cualquier implementación de esta clase son:
* <p>
* <ul>
*   <li> tope		: Accede al tope de una pila no vacía sin modificar a la misma</li>
*   <li> apilar		: Apila un nuevo elemento en la pila y retorna si la operación fue exitosa</li>
*   <li> desapilar	: Desapila y retona el elemento en el tope de una pila no vacía</li>
*   <li> vaciar		: Elimina todos los elementos de la pila dejándola vacía</li>
*   <li> elementos	: Retorna la cantidad de elementos presentes en la pila</li>
*   <li> esVacia	: Permite consultar si la pila está vacía</li>
*   <li> repOK		: Permite validar si una instancia satisface el invariante de representación</li>
*   <li> toString	: Retorna una representación en forma de cadena</li>
*   <li> equals		: Permite evaluar si otra instancia de pila es igual a esta</li>
* </ul>
*/
public interface Pila<T> {

	/**
	* Retorna el tope de la pila, si ésta no es vacía.
	* @return tope de la pila
	* @throws IllegalStateException si la pila está vacía
	* @see #esVacia()
	*/
	public T tope();

	/**
	* Permite evaluar si la pila no tiene elementos.
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia();

	/**
	* Apila un elemento en el tope de la pila.
	* @param elem el elemento a apilar
	* @return {@code true} sii el elemento pudo ser apilado
	*/
	public boolean apilar(T elem);

	/**
	* Desapila el tope de la pila, y retorna el elemento desapilado, si ésta no es vacía.
	* @return tope de la pila
	* @throws IllegalStateException si la pila está vacía
	* @see #esVacia()
	*/
	public T desapilar();
	
	/**
	* @return cantidad de elementos en la pila.
	*/
	public int elementos();

	/**
	* Remueve todos los elementos en la pila.
	*/
	public void vaciar();

	/**
	* Invariante de clase.
	* @return {@code true} sii la pila satisface su invariante de clase
	*/
	public boolean repOK();

	@Override
	public String toString();

	@Override
	public boolean equals(Object other);

}
