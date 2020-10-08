package colecciones.nodos;

import colecciones.nodos.Nodo;
import java.util.Set;
import java.util.HashSet;

public class Nodos {

	public static <T> Set<Nodo<T>> alcanzables(Nodo<T> desde) {
		Set<Nodo<T>> nodos = new HashSet<>();
		Nodo<T> corriente = desde;
		while (corriente != null && nodos.add(corriente)) {
			corriente = corriente.siguiente();		
		}
		return nodos;
	}

	public static <T> Nodo<T> nth(Nodo<T> desde, int n) {
		if (desde == null)
			return null;
		Set<Nodo<T>> nodos = new HashSet<>();
		int idx = 0;
		Nodo<T> corriente = desde;
		while (corriente != null && nodos.add(corriente)) {
			if (idx == n)
				return corriente;
			corriente = corriente.siguiente();
			idx++;		
		}
		return null;
	}

	public static <T> boolean valorAlcanzable(T valor, Nodo<T> desde) {
		if (desde == null)
			return false;
		Set<Nodo<T>> nodos = new HashSet<>();
		Nodo<T> corriente = desde;
		while (corriente != null && nodos.add(corriente)) {
			if (corriente.elem() == null && valor == null)
				return true;
			if (corriente.elem() != null && corriente.elem().equals(valor))
				return true;
			corriente = corriente.siguiente();
		}
		return false;
	}

	public static <T> boolean nodoAlcanzable(Nodo<T> nodo, Nodo<T> desde) {
		if (nodo == null)
			return false;
		if (desde == null)
			return false;	
		Set<Nodo<T>> nodos = new HashSet<>();
		Nodo<T> corriente = desde;
		while (corriente != null && nodos.add(corriente)) {
			if (corriente == nodo)
				return true;
			corriente = corriente.siguiente();
		}
		return false;
	}

}
