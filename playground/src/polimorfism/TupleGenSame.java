package polimorfism;

/**
* Una clase sin contenido como esta no es, en general, una buena idea, pero este es un ejemplo de herencia utilizando clases con genericidad.
*/
public class TupleGenSame<A> extends TupleGen<A, A> {

	public TupleGenSame(A first, A second) {
		//así como this hace mención a la instancia actual, super hace mención a la instancia actual de la clase de la cual
		//esta clase hereda.
		//this(argumentos) hace referencia a un constructor
		//super(argumentos) hace referencia a un constructor de la clase de la cual esta hereda
		super(first, second);
	}	

}
