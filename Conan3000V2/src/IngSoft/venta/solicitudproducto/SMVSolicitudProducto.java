package IngSoft.venta.solicitudproducto;

import IngSoft.general.CoServlet;

public class SMVSolicitudProducto extends CoServlet{
	
	@Override
	protected void initAcciones() {
		//acciones.put("Buscar", new AccionBuscarSolicitudProducto());
		//acciones.put("Consultar", new AccionConsultarSolicitudProducto());
		acciones.put("Agregar", new AccionAgregarSolicitudProducto());
		//acciones.put("Modificar", new AccionModificarSolicitudProducto());
		//acciones.put("Eliminar", new AccionEliminarSolicitudProducto());
		//acciones.put("Seleccionar", new AccionSeleccionarSolicitudProducto());
	}
	
}
