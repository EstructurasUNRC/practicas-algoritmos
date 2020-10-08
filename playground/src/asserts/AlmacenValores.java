package asserts;

public class AlmacenValores {

	private static Map<String, Object> valoresGuardados = new HashMap<>();


	public static boolean chequearNoNullYGuardar(Object valor, String id) {
		if (id == null || id.trim().isEmpty())
			throw new IllegalArgumentException("id no puede ser null o vacio");
		if (valor == null)
			valoresGuardados.put(id, valor);
		return valor == null;
	}

	public static boolean chequearNullYGuardar(Object valor, String id) {
		if (id == null || id.trim().isEmpty())
			throw new IllegalArgumentException("id no puede ser null o vacio");
		if (valor != null)
			valoresGuardados.put(id, valor);
		return valor != null;
	}

	public static boolean guardar(Object valor, String id) {
		if (id == null || id.trim().isEmpty())
			throw new IllegalArgumentException("id no puede ser null o vacio");
		valoresGuardados.put(id, valor);
		return true;
	}

	public static Object recuperarValorGuardado(String id) {
		if (id == null || id.trim().isEmpty())
			throw new IllegalArgumentException("id no puede ser null o vacio");
		if (!valoresGuardados.containsKey(id))
			throw new IllegalStateException("no existe valor guardado para el id provisto");
		return valoresGuardados.get(id);
	}

	public String obtenerId(Object instancia, String operacion, String nombreValor) {
		if (instancia == null)
			throw new IllegalArgumentException("la instancia no puede ser nula");
		if (operacion == null || operacion.trim().isEmpty())
			throw new IllegalArgumentException("operacion no puede ser null o vacio");
		if (nombreValor == null || nombreValor.trim().isEmpty())
			throw new IllegalArgumentException("nombreValor no puede ser null o vacio");
		return instancia.getClass().getSimpleName() + "@" +System.identityHashCode(instancia) + "#" + operacion + "_" + nombreValor;
	}

}
