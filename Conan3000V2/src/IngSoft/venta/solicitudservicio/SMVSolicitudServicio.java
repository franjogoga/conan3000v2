package IngSoft.venta.solicitudservicio;

import IngSoft.general.CoServlet;
import IngSoft.venta.solicitudproducto.AccionAgregarSolicitudProducto;

public class SMVSolicitudServicio extends CoServlet{
	
	@Override
	protected void initAcciones() {
		//acciones.put("Buscar", new AccionBuscarSolicitudProducto());
		//acciones.put("Consultar", new AccionConsultarSolicitudProducto());
		acciones.put("Agregar", new AccionAgregarSolicitudProducto());

	}

}
