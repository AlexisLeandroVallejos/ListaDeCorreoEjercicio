package model;

import java.util.ArrayList;

public class FiltroSpam implements IAlertas {
	
	ArrayList<String> mailsBloqueados = new ArrayList<String>();
	
	@Override
	public boolean controlar(Correo miCorreo) {
		// TODO Auto-generated method stub Agregar control de envios
		return false;
	}

	@Override
	public boolean TieneAlerta(Correo miCorreo) {
		// TODO Auto-generated method stub
		return false;
	}

}
