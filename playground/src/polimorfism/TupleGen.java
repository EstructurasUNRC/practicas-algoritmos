package polimorfism;

/**
* Implementación de {@code Tuple} utilizando genericidad, una vez creada una instancia de esta clase, los tipos de los elementos
* de la tupla permanecen fijos.
*/
public class TupleGen<A, B> {
	private A first;
	private B second;

	public TupleGen(A first, B second) {
		this.first = first;
		this.second = second;
	}

	public A first() {
		return first;	
	}

	public B second() {
		return second;	
	}

	public void setFirst(A first) {
		this.first = first;	
	}

	public void setSecond(B second) {
		this.second = second;	
	}

	@Override
	public String toString() {
		//Una expresión de la forma : expresión booleana?valor1:valor2 es una expresión condicional que retorna valor1
		//si la expresión booleana es verdadera y valor2 en caso contrario.
		return "{" + (first == null?"NULL":first.toString()) + ", " + (second == null?"NULL":second.toString()) + "}";
	}

}
