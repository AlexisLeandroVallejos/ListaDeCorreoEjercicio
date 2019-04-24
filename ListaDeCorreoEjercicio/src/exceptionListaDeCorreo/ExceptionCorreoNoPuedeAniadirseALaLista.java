package exceptionListaDeCorreo;


public class ExceptionCorreoNoPuedeAniadirseALaLista extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExceptionCorreoNoPuedeAniadirseALaLista() {
		super("No se puede añadir el correo a la lista.");
	}
}
