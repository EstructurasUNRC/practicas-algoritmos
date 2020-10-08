package polimorfism;

/**
* Clase para imprimir valores de distintos tipos, mostrando polimorfismo por sobrecarga.
*/
public class ValuePrinter {

	private char separator;

	/**
	* Constructor que utiliza la coma como separador.
	*/
	public ValuePrinter() {
		this(',');
	}

	/**
	* Constructor que permite definir el caracter a utilizar como separador.
	* @param separator el separador a utilizar
	*/
	public ValuePrinter(char separator) {
		this.separator = separator;
	}

	/**
	* Imprime una serie de valores enteros.
	* Se utiliza toString() para imprimir cada elemento, lo que es un ejemplo de polimorfismo por herencia
	* @param values el arreglo de valores a imprimir
	* @return una representacion de la forma [elementos]
	*/
	public String toString(int ... values) {
		String representation = "[";
		int idx = 0;
		while (idx < values.length) {
			int elem = values[idx];
			representation += Integer.toString(elem);
			if (idx + 1 < values.length)
				representation += separator;
			idx++;
		}
		representation += "]";
		return representation;
	}


	/**
	* Imprime una serie de valores floats.
	* Se utiliza toString() para imprimir cada elemento, lo que es un ejemplo de polimorfismo por herencia
	* @param values el arreglo de valores a imprimir
	* @return una representacion de la forma [elementos]
	*/
	public String toString(float ... values) {
		String representation = "[";
		int idx = 0;
		while (idx < values.length) {
			float elem = values[idx];
			representation += Float.toString(elem);
			if (idx + 1 < values.length)
				representation += separator;
			idx++;
		}
		representation += "]";
		return representation;
	}

	/**
	* Imprime una serie de valores booleanos.
	* Se utiliza toString() para imprimir cada elemento, lo que es un ejemplo de polimorfismo por herencia
	* @param values el arreglo de valores a imprimir
	* @return una representacion de la forma [elementos]
	*/
	public String toString(boolean ... values) {
		String representation = "[";
		int idx = 0;
		while (idx < values.length) {
			boolean elem = values[idx];
			representation += Boolean.toString(elem);
			if (idx + 1 < values.length)
				representation += separator;
			idx++;
		}
		representation += "]";
		return representation;
	}

	/**
	* Imprime un arreglo de valores de tipo Object.
	* Se utiliza toString() para imprimir cada elemento, lo que es un ejemplo de polimorfismo por herencia
	* @param values el arreglo de valores a imprimir
	* @return una representacion de la forma [elementos]
	*/
	public String toString(Object[] values) {
		String representation = "[";
		int idx = 0;
		while (idx < values.length) {
			Object elem = values[idx];
			representation += elem == null?"NULL":elem.toString();
			if (idx + 1 < values.length)
				representation += separator;
			idx++;
		}
		representation += "]";
		return representation;
	}

}
