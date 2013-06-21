package IngSoft.venta.solicitud;

import IngSoft.general.CoServlet;

public class SMVSolicitud extends CoServlet{

	@Override
	protected void initAcciones() {

		acciones.put("Agregar", new AccionLinks());
	}
	
}
