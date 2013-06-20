package IngSoft.venta.solicitudsocio;

import IngSoft.general.CoServlet;


public class SMVSolicitudSocio extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarSolicitudSocio());
		//acciones.put("Consultar", new AccionConsultarSocio());
		acciones.put("Agregar", new AccionAgregarSolicitudSocio()); //este es para agregar en traslado	
		//acciones.put("Eliminar", new AccionEliminarSocio());
	}

}
