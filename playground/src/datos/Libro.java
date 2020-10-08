package datos;

public class Libro {

	private final String titulo;
	private final String autor;
	private final int nroPag;

	/**
	* Construye un nuevo {@code Libro} con un titulo, autor, y numero de paginas determinadas.
	* @param titulo el titulo del libro, no puede ser {@code null} o vacio 
	* @param autor el autor del libro, no puede ser {@code null} o vacio
	* @param paginas la cantidad de paginas del libro, debe ser un numero positivo
	*/
	public Libro(String titulo, String autor, int paginas) {
		if (titulo == null || titulo.trim().isEmpty())
			throw new IllegalArgumentException("titulo es null o vacio");
		if (autor == null || autor.trim().isEmpty())
			throw new IllegalArgumentException("autor es null o vacio");
		if (paginas <= 0)
			throw new IllegalArgumentException("paginas es cero o negativo");
		this.titulo = titulo;
		this.autor = autor;
		nroPag = paginas;
	}

	/**
	* Obtiene el titulo de este libro.
	* @return el titulo del libro
	*/
	public String titulo() {
		return titulo;
	}

	public String autor() {
		return autor;
	}

	public int paginas() {
		return nroPag;
	}


	@Override
	public String toString() {
		return "Titulo: " + titulo + ", Autor: " + autor + ", Paginas: " + nroPag;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) return true;
		if (other == null) return false;
		if (!(other instanceof Libro)) return false;
		Libro otherLibro = (Libro) other;
		return (autor.equals(otherLibro.autor) &&
			titulo.equals(otherLibro.titulo) &&
			nroPag == otherLibro.nroPag);
	}

}
