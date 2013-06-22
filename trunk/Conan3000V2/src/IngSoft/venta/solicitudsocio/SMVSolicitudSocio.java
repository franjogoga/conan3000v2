package IngSoft.venta.solicitudsocio;

import IngSoft.general.CoServlet;


public class SMVSolicitudSocio extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarSolicitudSocio());
		acciones.put("Agregar", new AccionAgregarSolicitudSocio());
		acciones.put("Aceptar", new AccionAceptarSolicitudSocio());
		acciones.put("Denegar", new AccionDenegarSolicitudSocio());
		acciones.put("Seleccionar", new AccionSeleccionarSolicitudSocio());
	}

}
