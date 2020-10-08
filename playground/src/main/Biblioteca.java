package main;

import catalogo.CatalogoLibros;
import datos.Libro;

public class Biblioteca {


	
	public static void main(String[] args) {
		if (args.length % 3 != 0)
			throw new IllegalArgumentException("Quiero 3n datos");
		CatalogoLibros catalogo = new CatalogoLibros();
		for (int idx = 0; idx < args.length; idx = idx + 3) {
			String titulo = args[idx];
			String autor = args[idx + 1];
			int paginas = 0;
			try {
				paginas = Integer.parseInt(args[idx + 2]);
			} catch (NumberFormatException nfe) {
				throw new IllegalArgumentException("Valor de paginas invalido (" + args[idx + 2] + ")", nfe);
			}
			if (!catalogo.agregarLibro(titulo, autor, paginas))
				throw new IllegalArgumentException("Libro duplicado (" + titulo + ", " + autor + ", " + paginas + ")");
		}
		//codigo para buscar algun libro por autor (hardcodeado)
		System.out.println(catalogo.toString());
		Libro buscado = catalogo.buscarPorTitulo("Libro 1");
		if (buscado != null)
			System.out.println("Encontre el libro buscado: " + buscado.toString());
	}	


}
