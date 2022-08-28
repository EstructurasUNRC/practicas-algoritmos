package datos;

/**
* La clase {@code Libro} representa un libro formado por los siguientes datos:
* <ul>
* 	<li>El nombre del autor del libro.</li>
*	<li>El título del libro.</li>
*	<li>El número de páginas del libro</li>
* </ul>
* 
* La implementación no garantiza que los valores sean correctos con respecto a lo esperado de un libro:
* <ul>
* 	<li> El autor puede ser vacío o nulo ({@code null}). </li>
*	<li> El título puede ser vacío o nulo ({@code null}). </li>
	<li> El número de páginas puede ser un número negativo o cero. </li>
* </ul>
*
* @version 1.0
*/
public class Libro {

	//el autor del libro
	private String autor;
	//el título del libro
	private String titulo;
	//la cantidad de páginas del libro
	private int nroPaginas;
	
	
	/**
	* Construye un nuevo {@code Libro} con autor, título, y número de páginas dados.
	* @param autor : el autor del nuevo Libro.
	* @param titulo : el título del nuevo Libro.
	* @param nroPaginas : el número de páginas del nuevo Libro.
	*/
	public Libro(String autor, String titulo, int nroPaginas) {
		this.autor = autor;
		this.titulo = titulo;
		this.nroPaginas = nroPaginas;
	}
	
	/**
	* Define el autor de este Libro.
	* @param autor : el nuevo autor de este Libro.
	*/
	public void autor(String autor) {
		this.autor = autor;
	}
	
	/**
	* Retorna el autor asociado a este Libro.
	* @return el autor.
	*/
	public String autor() {
		return autor;
	}
	
	/**
	* Define el título de este Libro.
	* @param titulo : el nuevo título de este Libro.
	*/
	public void titulo(String titulo) {
		this.autor = titulo;
	}
	
	/**
	* Retorna el título asociado a este Libro.
	* @return el título.
	*/
	public String titulo() {
		return titulo;
	}
	
	/**
	* Define el número de páginas de este Libro.
	* @param nroPaginas : el nuevo número de páginas de este Libro.
	*/
	public void nroPaginas(int nroPaginas) {
		this.nroPaginas = nroPaginas;
	}
	
	/**
	* Retorna el número de páginas asociado a este Libro.
	* @return el número de páginas.
	*/
	public int nroPaginas() {
		return nroPaginas;
	}
	
	@Override
	public String toString() {
		throw new UnsupportedOperationException("Debe implementar este método");
	}
	
	@Override
	public boolean equals(Object otro) {
		if (otro == null)
			return false;
		if (otro == this)
			return true;
		if (!(otro instanceof Libro))
			return false;
		Libro otroLibro = (Libro) otro;
		if (otroLibro.autor == null && autor != null)
			return false;
		if (otroLibro.titulo == null && titulo != null)
			return false;
		if (!otroLibro.autor.equals(autor))
			return false;
		if (!otroLibro.titulo.equals(titulo))
			return false;
		return otroLibro.nroPaginas == nroPaginas;
	}

}
