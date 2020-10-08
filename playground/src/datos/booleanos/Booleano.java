package datos.booleanos;

/**
* Especificacion que representa el TAD Booleano.
* Los unicos valores de Booleano son Verdadero y Falso.
*/
public interface Booleano {

	/**
	* Retorna el valor opuesto al booleano.
	* @return negacion del booleano.
	*/
	public Booleano negacion(); 

	/**
	* Retorna la conjuncion con otro booleano.
	* @param b valor booleano para la conjuncion. 
	* @return valor booleano de la conjuncion.
	*/
	public Booleano conjuncion(Booleano b);

	/**
	* Retorna la disyuncion con otro booleano.
	* @param b valor booleano para la disyuncion. 
	* @return valor booleano de la disyuncion.
	*/
	public Booleano disyuncion(Booleano b);

	/**
	* Retorna la implicacion con otro booleano.
	* @param b valor booleano para la implicacion. 
	* @return valor booleano de la implicacion.
	*/
	public Booleano implicacion(Booleano b);

	/**
	* Operacion observadora.
	* @return {@code true} sii el booleano es verdadero.
	*/
	public boolean esVerdadero();

	/**
	* Retorna una representación String en base a los valores Verdadero y Falso del algebra abstracta Booleano.
	*/
	@Override
	public String toString();


	public boolean repOK();

}
