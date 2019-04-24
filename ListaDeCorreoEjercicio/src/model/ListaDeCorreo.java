package model;

import java.util.ArrayList;
import exceptionListaDeCorreo.*;

public class ListaDeCorreo {
	private boolean cerrada = false;
	private boolean suscripcionCerrada = false;
	
	private ArrayList<IAlertas> _filtros = new ArrayList<IAlertas>();
	private ArrayList<String> _correos = new ArrayList<String>();

	public boolean enviarMensaje(Correo miCorreo) {
		if (cerrada == true && _correos.contains(miCorreo.get_correo()) == false) {
			throw new ExceptionCorreoNoPerteneceAlGrupo();
		}
		ISendMessage sistemaEnvioDeMensaje = new EnvioDeMensajeMock();
		return sistemaEnvioDeMensaje.enviar(miCorreo.get_correo(), miCorreo.get_titulo(), miCorreo.get_cuerpo());

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

	public void addFiltros(IAlertas filtro) {
		// TODO Auto-generated method stub
		this._filtros.add(filtro);
	}

	public boolean mailFiltrado(Correo miCorreo) {
		// TODO Auto-generated method stub
		boolean spam = false;
		for(int i = 0; i< this._filtros.size();i++)
		{
			//spam = _filtros.get(i).Filtrado(miCorreo);
		}
		return spam;
	}

}
