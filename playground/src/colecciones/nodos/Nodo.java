package colecciones.nodos;


public class Nodo<T> {

	private T elem;
	private Nodo<T> siguiente;

	public Nodo(T elem) {
		this(elem, null);
	}

	public Nodo(T elem, Nodo<T> siguiente) {
		this.elem = elem;
		this.siguiente = siguiente;
	}

	public T elem() {
		return elem;
	}

	public Nodo<T> siguiente() {
		return siguiente;	
	}

	public void elem(T elem) {
		this.elem = elem;	
	}

	public void siguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;	
	}

}
