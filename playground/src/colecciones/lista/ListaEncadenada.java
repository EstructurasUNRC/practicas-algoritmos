package colecciones.lista;

import colecciones.nodos.Nodo;
import static colecciones.nodos.Nodos.*;
import static asserts.AlmacenValores.*;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;


public class ListaEncadenada<T> implements Lista<T> {

	private Nodo<T> raiz = null;
	private int elementos = 0;

	public ListaEncadenada() {}

	public ListaEncadenada(Collection<T> elems) {
		for (T elem : elems) {
			agregar(elem);
		}
	}

	public boolean agregar(T elem) {
		assert repOK();
		boolean resultado = insertar(elem, elementos);
		assert repOK() && nth(raiz, elementos - 1).elem() == elem;
		return resultado;
	}

	public boolean insertar(T elem, int indice) {
		assert repOK() && indice >= 0;
		if (indice < 0)
			throw new IndexOutOfBoundsException("indice negativo");
		if (raiz == null) {
			raiz = new Nodo<>(elem);
		} else {
			int idx = 0;
			Nodo<T> corriente = raiz;
			while (idx < (indice - 1) && corriente.siguiente() != null) {
				corriente = corriente.siguiente();
				idx++;			
			}
			Nodo<T> nuevoNodo = new Nodo<>(elem, corriente.siguiente());
			corriente.siguiente(nuevoNodo);
		}
		elementos++;
		assert repOK() && nth(raiz, indice) != null && nth(raiz, indice).elem() == elem;
		return true;
	}

	@Override
	public T eliminar(int indice) {
		assert repOK() && nth(raiz, indice) != null
		&& guardar(nth(raiz, indice).elem(), obtenerId(this, "eliminar", "elemNth"));
		&& guardar(nth(raiz, indice), obtenerId(this, "eliminar", "nodoNth"));
		throw new UnsupportedOperationException("Falta implementar");
		//T resultado = ...		
		//assert repOK()
		//&& !alcanzables(raiz).contains(recuperarValorGuardado(obtenerId(this, "eliminar", "nodoNth")))
		//&& recuperarValorGuardado(obtenerId(this, "eliminar", "elemNth")) == resultado;
	}

	@Override
	public T obtener(int indice) {
		assert repOK() && nth(raiz, indice) != null;
		throw new UnsupportedOperationException("Falta implementar");
		//T resultado = ...		
		//assert repOK() && valorAlcanzable(resultado, raiz);
	}

	@Override
	public boolean contiene(T elem) {
		assert repOK();
		boolean resultado = false;		
		if (esVacia())
			resultado = false;	
		Nodo<T> corriente = raiz;
		while (corriente != null) {
			if (corriente.elem().equals(elem)) {
				resultado = true;
				break;
			}
			corriente = corriente.siguiente();		
		}
		assert repOK() && valorAlcanzable(elem, raiz) == resultado;
		return resultado;
	}

	@Override
	public void vaciar() {
		assert repOK();
		throw new UnsupportedOperationException("Falta implementar");
		//assert repOK() && alcanzables(raiz).isEmpty();
	}
	
	@Override
	public int elementos() {
		int resultado = elementos;
		assert repOK() && alcanzables(raiz).size() == resultado;
		return resultado;
	}

	@Override
	public boolean esVacia() {
		boolean resultado = elementos == 0;
		assert repOK() && alcanzables(raiz).isEmpty() == resultado;
		return resultado;
	}

	@Override
	public boolean repOK() {
		Set<Nodo<T>> nodosVisitados = new HashSet<>();
		Nodo<T> corriente = raiz;
		while (corriente != null) {
			if (!nodosVisitados.add(corriente)) {
				return false;
			}
			corriente = corriente.siguiente();
		}
		return nodosVisitados.size() == elementos;
	}

	@Override
	public String toString() {
		String res = "[";
		Nodo<T> corriente = raiz;
		while (corriente != null) {
			res += corriente.elem();
			if (corriente.siguiente() != null)
				res += ", ";
			corriente = corriente.siguiente();		
		}
		res += "]";
		return res;	
	}
	
}
