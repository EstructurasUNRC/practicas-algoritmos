package polimorfism;

/**
* Un ejemplo de implementacion de los racionales
* @author Pablo Castro
**/
public class Racional implements Comparable<Racional> {

	private int num; // el numerador del racional
	private int den; // el denominador

	/**
	* Un constructor basico para racionales
	* @param n el numerador no negativo
	* @param d el denominador distinto de cero
	*/
	public Racional(int n, int d){
		if (d == 0)
			throw new IllegalArgumentException("denominador es cero");
		if (n < 0)
			throw new IllegalArgumentException("numerador es negativo");
		this.num = n;
		this.den = d;
	}

	@Override
	public boolean equals(Object r){
		if (r == null)
			return false;
		if (r instanceof Racional){
			Racional param = (Racional) r;
			return ((this.num * param.den) == (this.den * param.num));
		} else
		return false;
	}

	@Override
	public String toString(){
		return String.valueOf((float) this.num / (float) this.den);
	}
    
	/**
	* El invariante de represantacion
	* @return true cuando el segundo componente del par es diferente a 0
	*/
    	public boolean repOk(){
        	return (den != 0);
    	}


	@Override
	public int compareTo(Racional other) {
		if (other == null)
			throw new IllegalArgumentException("null argument");
		Racional a = this;
		int lhs = a.num * other.den;
		int rhs = a.den * other.num;
		if (lhs < rhs) return -1;
		if (lhs > rhs) return +1;
		return 0;
	}

}
