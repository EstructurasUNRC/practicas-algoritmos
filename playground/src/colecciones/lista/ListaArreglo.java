package colecciones.lista;

import java.util.Collection;


public class ListaArreglo<T> implements Lista<T> {

	public static final int CAPACIDAD_POR_DETECTO = 20;
	public static final float TASA_CRECIMIENTO_POR_DEFECTO = 0.5f;
	private Object[] arreglo;
	private int elementos = 0;
	private float tasaCrecimiento;

	public ListaArreglo() {
		this(CAPACIDAD_POR_DETECTO, TASA_CRECIMIENTO_POR_DEFECTO);
	}
	
	public ListaArreglo(int capacidadInicial) {
		this(capacidadInicial, TASA_CRECIMIENTO_POR_DEFECTO);
	}

	public ListaArreglo(int capacidadInicial, float crecimiento) {
		inicializar(capacidadInicial, crecimiento);
	}

	public ListaArreglo(Collection<T> elems) {
		this(elems, TASA_CRECIMIENTO_POR_DEFECTO);
	}
	
	public ListaArreglo(Collection<T> elems, float crecimiento) {
		inicializar(Math.max(elems.size(), CAPACIDAD_POR_DETECTO), crecimiento);
	}

	private void inicializar(int capacidad, float crecimiento) {
		if (capacidad <= 0)
			throw new IllegalArgumentException("La capacidad debe ser positiva (" + capacidad + ")");
		if (crecimiento <= 0)
			throw new IllegalArgumentException("El crecimiento debe ser positivo (" + crecimiento + ")");
		arreglo = new Object[capacidad];
		tasaCrecimiento = crecimiento;
	} 

	
	@Override
	public boolean agregar(T elem) {
		asegurarCapacidad();
		arreglo[elementos - 1] = elem;
		elementos++;
		return true;
	}

	@Override
	public boolean insertar(T elem, int indice) {
		asegurarCapacidad();
		if (indice < elementos - 1)
			moverADerecha(indice);
		arreglo[indice] = elem;
		elementos++;
		return true;
	}

	private void asegurarCapacidad() {
		if (elementos == arreglo.length) {
			int nuevaCapacidad = (int) Math.ceil(arreglo.length + (tasaCrecimiento * arreglo.length));
			Object[] nuevoArreglo = new Object[nuevaCapacidad];
			System.arraycopy(arreglo, 0, nuevoArreglo, 0, arreglo.length);
			arreglo = nuevoArreglo;	
		}
	}

	private void moverADerecha(int desde) {
		
	}

	@Override
	public T eliminar(int indice) {
		throw new UnsupportedOperationException("Falta implementar");
	}

	@Override
	public T obtener(int indice) {
		throw new UnsupportedOperationException("Falta implementar");
	}

	@Override
	public boolean contiene(T elem) {
		throw new UnsupportedOperationException("Falta implementar");
	}

	@Override
	public void vaciar() {
		throw new UnsupportedOperationException("Falta implementar");
	}
	
	@Override
	public int elementos() {
		return elementos;
	}

	@Override
	public boolean esVacia() {
		return elementos == 0;
	}

	@Override
	public boolean repOK() {
		throw new UnsupportedOperationException("Falta implementar");
	}

	@Override
	public String toString() {
		throw new UnsupportedOperationException("Falta implementar");	
	}
	
}
