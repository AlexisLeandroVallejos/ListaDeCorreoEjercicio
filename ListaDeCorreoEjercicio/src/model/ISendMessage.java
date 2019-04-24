package model;

public interface ISendMessage {
	/**
	 *
	 * Usar la Libreria Mockito para mockear esta interfaz en los test!
	 
	 */
	public boolean enviar(String correo, String titulo, String mensaje);
}
