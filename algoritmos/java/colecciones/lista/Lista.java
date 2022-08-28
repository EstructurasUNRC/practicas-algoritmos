package colecciones.lista;

/**
* La interface {@code Lista} representa una secuencia de objetos. El usuario de esta interface tiene control de acceso, inserción, y eliminación indexada de elementos.
* 
* Las operaciones ofrecidas por cualquier implementación de esta clase son:
* <ul>
*   <li> agregar	: Agrega un nuevo elemento al final de la lista, y retorna si la operación fue exitosa.</li>
*   <li> agregarTodos	: Agrega todos los elementos de otra lista al final de la lista, y retorna si la operación fue exitosa.</li>
*   <li> insertar	: Agrega un nuevo elemento en un índice particular, desplazando el resto de los elementos a la derecha si es necesario, y retorna si la operación fue exitosa.</li>
*   <li> eliminar	: Elimina un elemento en un ídice particular, retorna el elemento eliminado.</li>
*   <li> obtener	: Retorna el elemento en un índice particular sin eliminarlo.</li>
*   <li> subLista	: Retorna una sublista de esta lista dados dos índices particulares.</li>
*   <li> contiene	: Permite evaluar si la lista contiene un elemento particular.</li>
*   <li> vaciar		: Elimina todos los elementos de la lista dejándola vacía</li>
*   <li> elementos	: Retorna la cantidad de elementos presentes en la lista</li>
*   <li> esVacia	: Permite consultar si la lista está vacía</li>
*   <li> repOK		: Permite validar si una instancia satisface el invariante de representación</li>
*   <li> toString	: Retorna una representación en forma de cadena</li>
*   <li> equals		: Permite evaluar si otra instancia de lista es igual a esta</li>
* </ul>
* @param T : el tipo de los elementos a almacenar en la Lista.
* @version 1.1
*/
public interface Lista<T> {

	/**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/
	public boolean agregar(T elem);
	
	/**
	* Agrega todos los elementos de otra lista, al final de esta lista.
	* @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
	* @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
	*/
	public boolean agregarTodos(Lista<T> otraLista);

	/**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
	public boolean insertar(T elem, int indice);

	/**
	* Elimina un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a eliminar
	* @return el elemento eliminado
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T eliminar(int indice);

	/**
	* Obtiene un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a obtener
	* @return el elemento en la posición {@code indice}
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T obtener(int indice);
	
	/**
	* Retorna la porción de esta lista entre los índice especificados {@code desdeInd}, inclusivo, y {@code hastaInd}, exclusivo, en una nueva lista.
	* Si {@code fromInd} es igual a {@code hastaInd} se retorna un a lista vacía.
	* @param desdeInd el índice inferior, inclusivo
	* @param hastaInd el índice superior, exclusivo
	* @return una nueva lista formada con los elementos entre {@code desdeInd} hasta {@code hastaInd - 1} de esta lista
	* @throws IndexOutOfBoundsException si ({@code fromInd} &lt; {@code 0} || {@code hastaInd} &gt; {@code #elementos()} || {@code desdeInd} &gt; {@code hastaInd})
	* @see #elementos() 
	*/
	public Lista<T> subLista(int desdeInd, int hastaInd);

	/**
	* Evalua si esta lista contiene un elemento particular, utilizando el método {@code equals(Object)}.
	* @param elem el elemento a buscar
	* @return {@code true} sii, existe un elemento {@code e} en la lista, tal que {@code e == null && elem == null || e.equals(elem)}
	*/
	public boolean contiene(T elem);

	/**
	* Remueve todos los elementos en la lista.
	*/
	public void vaciar();
	
	/**
	* Retorna la cantidad de elementos agregados a la lista.
	* @return cantidad de elementos en la lista
	*/
	public int elementos();

	/**
	* Permite evaluar si la lista no tiene elementos.
	* Este método es equivalente a:
	* <pre>lista.elementos() == 0</pre>
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia();

	/**
	* Invariante de clase.
	* @return {@code true} sii la lista satisface su invariante de clase
	*/
	public boolean repOK();

	/**
	* Retorna una representación como {@code String} de esta lista. La representación como {@code String} consiste de los elementos en esta lista, en el orden correspondiente a la implementación de la misma, encerrados entre corchetes ("[]"). 
	* Elementos adyacentes están separados mediante los caractéres ", " (coma y espacio). Los elementos son convertidos mediante {@code String.valueOf(Object)}.
	* @return una representación como {@code String} de esta lista
	*/
	@Override
	public String toString();
	
	/**
	* Evalúa igualdad entre esta y otra lista. La igualdad considera que el tamaño de ambas listas es el mismo, y que los elementos de ambas listas son iguales considerando el orden de los mismos de acuerdo a la implementación de cada lista.
	* La igualdad entre elementos se realiza considerando si ambos son {@code null} o, en caso contrario, mediante el método {@code equals(Object)}.
	* @return {@code true} sii ambas listas tienen los mismos elementos.
	*/
	@Override
	public boolean equals(Object otro);

}
