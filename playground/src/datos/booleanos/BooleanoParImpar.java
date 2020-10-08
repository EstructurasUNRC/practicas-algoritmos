package datos.booleanos;

/**
 * Implementacion de la interface Booleano con  valores pares e impares. 
 * Impar = Verdadero
 * Las operaciones de esta implementación no modifican this.
 */
public class BooleanoParImpar implements Booleano {
  
	/* Representación interna del booleano. */
	private int valor; 

	/**
	* Constructor privado, con parametro.
	* 
	*/
	private  BooleanoParImpar(int n) {
		valor = n;
	}

	/**
	* Operacion generadora de  Verdadero.
	* @return Booleano Verdadero
	*/
	public static Booleano verdadero() {
		BooleanoParImpar v = new BooleanoParImpar(1);
		assert v.repOK() : "Se viola el invariante de representacion";
		assert v.esVerdadero() : "Se esperaba retornar algo Verdadero pero se retorna Falso";
		return v;
	}

	/**
	* Operacion generadora de  Falso.
	* @return Booleano Falso
	*/
	public static Booleano falso() {
		BooleanoParImpar v = new BooleanoParImpar(2);
		assert v.repOK() && !v.esVerdadero();
		return v;
	}


	@Override
	public Booleano negacion() {
		return new BooleanoParImpar(this.valor + 1);
	}


	@Override
	public Booleano conjuncion(Booleano b) {
		assert repOK() && b.repOK();
		BooleanoParImpar boolConcreto;
		if (b instanceof BooleanoParImpar) {
			boolConcreto = (BooleanoParImpar) b;
		} else  {
			boolConcreto = (BooleanoParImpar) (b.esVerdadero() ? verdadero() : falso());
		}
		BooleanoParImpar res = conjuncionConcreta(boolConcreto);
		assert res.repOK() && ((b.esVerdadero() && res.esVerdadero() == esVerdadero()) || (!b.esVerdadero() && !res.esVerdadero()));
		return res;
	}

	private BooleanoParImpar conjuncionConcreta(BooleanoParImpar b) {
		return new BooleanoParImpar(this.valor * b.valor);
	}

	@Override
	public Booleano disyuncion(Booleano b) {
		return (this.negacion()).conjuncion(b.negacion()).negacion();
	}

	@Override
	public Booleano implicacion(Booleano b) {
		return (this.conjuncion(b.negacion())).negacion();
	}



	@Override
	public boolean esVerdadero() {
		return (valor % 2 != 0);
	}


	@Override
	public String toString() {
		return ((valor % 2 != 0) ? "Verdadero" : "Falso");
	}

	@Override
	public boolean repOK() {
		return valor >= 0;	
	}

}
