package model;

import java.util.ArrayList;
import exceptionListaDeCorreo.*;

public class ListaDeCorreo {
	private boolean cerrada = false;
	private boolean suscripcionCerrada = false;
	private ArrayList<String> _correos = new ArrayList<String>();

	public boolean enviarMensaje(String correo, String titulo, String texto) {
		if (cerrada == true && _correos.contains(correo) == false) {
			throw new ExceptionCorreoNoPerteneceAlGrupo();
		}
		ISendMessage sistemaEnvioDeMensaje = new EnvioDeMensajeMock();
		return sistemaEnvioDeMensaje.enviar(correo, titulo, texto);

	}

	public ArrayList<String> getCorreos() {
		if(this.suscripcionCerrada)
		{
			throw new ExceptionCorreoNoPuedeAniadirseALaLista();
		}
		return _correos;
	}

	public boolean isCerrada() {
		return cerrada;
	}

	public void setCerrada(boolean cerrada) {
		this.cerrada = cerrada;
	}

	public boolean isSuscripcionCerrada() {
		return suscripcionCerrada;
	}

	public void setSuscripcionCerrada(boolean suscripcionCerrada) {
		this.suscripcionCerrada = suscripcionCerrada;
	}

}
