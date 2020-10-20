package colecciones.lista;

public interface Lista<T> {

	/**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/
	public boolean agregar(T elem);

	/**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
	public boolean insertar(T elem, int indice);

	public T eliminar(int indice);

	public T obtener(int indice);

	public boolean contiene(T elem);

	public void vaciar();
	
	public int elementos();

	public boolean esVacia();

	public boolean repOK();

	@Override
	public String toString();

}
