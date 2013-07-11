package IngSoft.venta.solicitudproducto;

import IngSoft.general.CoServlet;

public class SMVSolicitudProducto extends CoServlet{
	
	@Override
	protected void initAcciones() {
		//acciones.put("Buscar", new AccionBuscarSolicitudProducto());
	    acciones.put("Agregar", new AccionAgregarSolicitudProducto());
		//acciones.put("Aceptar", new AccionModificarSolicitudProducto());
		//acciones.put("Denegar", new AccionEliminarSolicitudProducto());
		//acciones.put("Seleccionar", new AccionSeleccionarSolicitudProducto());
	}
	
}
