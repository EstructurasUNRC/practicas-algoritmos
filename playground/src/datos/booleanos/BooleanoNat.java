package datos.booleanos;

/**
* Implementacion de la interface Booleano con  valores Nat. 
* 0 = Falso, (&gt; 0) = Verdadero
* Las operaciones de esta implementación no modifican this.
*/
public class BooleanoNat implements Booleano {

	/* Representación interna del booleano. */
	private int valor;

	/**
	* Constructor privado, con parametro.
	* 
	*/
	private  BooleanoNat(int n) {
		valor = n;
	}

	/**
	* Operacion generadora de  Verdadero.
	* @return Booleano Verdadero
	*/
	public static Booleano verdadero() {
		BooleanoNat v = new BooleanoNat(2);
		assert v.repOK() : "La operacion verdadero' no satisface el invariante";
		return v;
	}

	/**
	* Operacion generadora de Falso.
	* @return Booleano Falso
	*/
	public static Booleano falso() {
		BooleanoNat v = new BooleanoNat(0);
		assert v.repOK() : "La operacion falso' no satisface el invariante";
		return v;
	}

	@Override
	public Booleano negacion() {
		assert repOK() : "No se cumple el invariante antes de llamar a negacion";
		BooleanoNat neg = new BooleanoNat((valor == 0) ? 1 : 0);
		assert repOK() && neg.repOK() : "No se cumple el invariante luego de llamar a negacion";
		assert neg.esVerdadero() != esVerdadero() : "La negacion no hace lo que deberia";		
		return neg;
	}
	
	@Override
	public Booleano conjuncion(Booleano b) {
		BooleanoNat boolConcreto;
		assert repOK() && b.repOK() : "No vale el invariante antes de llamar a conjuncion";
		if (b instanceof BooleanoNat) {
			boolConcreto = (BooleanoNat) b;
		} else  {
			boolConcreto = (BooleanoNat) (b.esVerdadero() ? verdadero() : falso());
		}
		BooleanoNat conj = conjuncionConcreta(boolConcreto);
		assert repOK() && conj.repOK() && b.repOK(): "No vale el invariante luego de llamar a conjuncion";
		assert (b.esVerdadero() && conj.esVerdadero() == esVerdadero()) || (!b.esVerdadero() && !conj.esVerdadero()) : "La conjuncion no hace lo que deberia";
		return conj;
	}

	private BooleanoNat conjuncionConcreta(BooleanoNat b) {
		return new BooleanoNat(this.valor * b.valor);
	}

	@Override
	public Booleano disyuncion(Booleano b) {
		BooleanoNat boolConcreto;
		if (b instanceof BooleanoNat) {
			boolConcreto = (BooleanoNat) b;
		} else  {
			boolConcreto = (BooleanoNat) (b.esVerdadero() ? verdadero() : falso());
		} 
		return disyuncionConcreta(boolConcreto);
	}

	private BooleanoNat disyuncionConcreta(BooleanoNat b) {
		return new BooleanoNat(this.valor + b.valor);
	}

	@Override
	public Booleano implicacion(Booleano b) {
		return ((this.negacion()).disyuncion(b));
	}

	@Override
	public boolean esVerdadero() {
		return (valor != 0);
	}


	@Override
	public String toString() {
		return ((valor != 0) ? "Verdadero" : "Falso");
	}

	@Override
	public boolean repOK() {
		return valor >= 0;
	}

}
