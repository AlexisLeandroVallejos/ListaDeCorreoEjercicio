package modelTest;

import org.junit.*;
import exceptionListaDeCorreo.*;

import model.*;

public class ListaDeCorreoTest {
	@Test
	public void enviarMensaje_enviaMensajeVacioEnListaAbierta() {
		ListaDeCorreo lista = new ListaDeCorreo();
		Correo miCorreo = new Correo();
		lista.enviarMensaje(miCorreo);
	}
	
	@Test
	public void correos_listaEstaVacia() {
		ListaDeCorreo lista = new ListaDeCorreo();
		int tamanio = lista.getCorreos().size();
		Assert.assertEquals("Lista de correo no esta vacia.", 0 , tamanio);
	}
	
	@Test
	public void correos_aniadoCorreoAListaVacia() {
		ListaDeCorreo lista = new ListaDeCorreo();
		lista.getCorreos().add("alv@gmail.com");
		int tamanio = lista.getCorreos().size();
		Assert.assertEquals("Lista de correo no esta vacia.", 1 , tamanio);
	}
	
	@Test
	public void listaDeCorreo_seCreaAbierta() {
		ListaDeCorreo lista = new ListaDeCorreo();
		Assert.assertEquals("Lista de correo no esta cerrada.", false , lista.isCerrada());
	}
	
	@Test
	public void listaDeCorreo_seCreaAbiertaYSePasaACerrada() {
		ListaDeCorreo lista = new ListaDeCorreo();
		lista.setCerrada(true);
		Assert.assertEquals("Lista de correo esta cerrada.", true , lista.isCerrada());
	}
	
	@Test
	public void listaDeCorreo_seEnviaCorreoEnUnaListaAbierta() {
		ListaDeCorreo lista = new ListaDeCorreo();
		lista.getCorreos().add("alv@gmail.com.ar");
		Correo miCorreo = new Correo();
		miCorreo.set_correo("gt40@yahoo.com");
		lista.enviarMensaje(miCorreo);
	}
	
	@Test(expected=ExceptionCorreoNoPerteneceAlGrupo.class)
	public void listaDeCorreo_seEnviaCorreoEnUnaListaCerrada() {
		ListaDeCorreo lista = new ListaDeCorreo();
		lista.getCorreos().add("alv@gmail.com.ar");
		lista.setCerrada(true);
		Correo miCorreo = new Correo();
		miCorreo.set_correo("gt40@yahoo.com");
		lista.enviarMensaje(miCorreo);
	}
	
	@Test
	public void listaDeCorreo_seEnviaCorreoEnUnaListaCerradaQuePerteneceALaLista() {
		ListaDeCorreo lista = new ListaDeCorreo();
		lista.getCorreos().add("alv@gmail.com.ar");
		lista.getCorreos().add("gt40@yahoo.com");
		lista.setCerrada(true);
		Correo miCorreo = new Correo();
		miCorreo.set_correo("gt40@yahoo.com");
		lista.enviarMensaje(miCorreo);
		
	}
	
	@Test
	public void listaDeCorreo_SeCreaListaDeSuscripcionCerrada() {
		ListaDeCorreo lista = new ListaDeCorreo();
		lista.setSuscripcionCerrada(true);
		Assert.assertEquals("Lista de correo es de suscripcion abierta.", true , lista.isSuscripcionCerrada());
	}

	@Test
	public void listaDeCorreo_SeCreaListaDeSuscripcionAbierta() {
		ListaDeCorreo lista = new ListaDeCorreo();
		Assert.assertEquals("Lista de correo es de suscripcion cerrada.", false , lista.isSuscripcionCerrada());
	}
	
	@Test(expected=ExceptionCorreoNoPuedeAniadirseALaLista.class)
	public void listaDeCorreo_SeCreaListaDeSuscripcionCerradaYSeAniadeGente() {
		ListaDeCorreo lista = new ListaDeCorreo();
		lista.setSuscripcionCerrada(true);
		lista.getCorreos().add("mavelazquez@gmail.com");
		
	}

	@Test
	public void listaDeCorreo_SeCreaListaDeSuscripcionAbiertaYSeAniadeGente() {
		ListaDeCorreo lista = new ListaDeCorreo();
		lista.setSuscripcionCerrada(false);
		lista.getCorreos().add("mavelazquez@gmail.com");
		
	}

	@Test
	public void listaDeCorreo_SeEnviaUnMailMasDe6VecesPorLaMismaPersona() {
		ListaDeCorreo lista = new ListaDeCorreo();
		lista.setSuscripcionCerrada(false);
		lista.addFiltros(new FiltroSpam());
		Correo miCorreo = new Correo();
		miCorreo.set_correo("mailspammer@spaaaaammmm.com");
		miCorreo.set_titulo("spam");
		miCorreo.set_correo("spam2");
		for(int i = 0; i < 6; i++)
		{
			lista.enviarMensaje(miCorreo);
		}
		//Assert.assertArrayEquals("El Correo no esta Bloqueado.",true, lista.mailFiltrado(miCorreo));
	}
}
