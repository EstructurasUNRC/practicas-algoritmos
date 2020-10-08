package polimorfism;

/**
* Ejemplo de una clase tupla, esta clase usa polimorfismo por herencia en {@code #toString()}.
*/
public class Tuple {
	private Object first;
	private Object second;

	public Tuple(Object first, Object second) {
		this.first = first;
		this.second = second;
	}

	public Object first() {
		return first;
	}

	public Object second() {
		return second;	
	}

	public void setFirst(Object first) {
		this.first = first;	
	}

	public void setSecond(Object second) {
		this.second = second;	
	}

	@Override
	public String toString() {
		return "{" + (first == null?"NULL":first.toString()) + ", " + (second == null?"NULL":second.toString()) + "}";
	}

}
