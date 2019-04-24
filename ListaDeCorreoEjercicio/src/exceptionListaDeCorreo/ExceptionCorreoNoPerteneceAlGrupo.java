package exceptionListaDeCorreo;


public class ExceptionCorreoNoPerteneceAlGrupo extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExceptionCorreoNoPerteneceAlGrupo() {
		super("No es un correo perteneciente al grupo.");
	}
}
