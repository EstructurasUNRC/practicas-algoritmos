package catalogo;

import colecciones.lista.Lista;
import colecciones.lista.ListaEncadenada;
import datos.Libro;

public class CatalogoLibros {

	private Lista<Libro> catalogo;


	public CatalogoLibros() {
		catalogo = new ListaEncadenada<>();	
	}


	public boolean agregarLibro(String titulo, String autor, int paginas) {
		Libro nuevoLibro = new Libro(titulo, autor, paginas);
		if (catalogo.contiene(nuevoLibro))
			return false;
		catalogo.agregar(nuevoLibro);
		return true;
	}

	public Libro buscarPorTitulo(String titulo) {
		for (int idx = 0; idx < catalogo.elementos(); idx++) {
			Libro libro = catalogo.obtener(idx);
			if (libro.titulo().equals(titulo))
				return libro;		
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Catalogo de libros\n" + catalogo.toString();
	}

}
