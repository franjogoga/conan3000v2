package IngSoft.venta.solicitudservicio;

import IngSoft.general.CoServlet;

public class SMVSolicitudServicio extends CoServlet{
	
	@Override
	protected void initAcciones() {
		//acciones.put("Buscar", new AccionBuscarSolicitudProducto());
		//acciones.put("Consultar", new AccionConsultarSolicitudProducto());
		acciones.put("Agregar", new AccionAgregarSolicitudServicio());

	}

}
