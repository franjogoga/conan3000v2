package IngSoft.servicio.reporte;

import IngSoft.general.CoServlet;

public class SMSReporte extends CoServlet{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Reserva", new AccionReporteBungalow());
		//acciones.put("Generar", new AccionGenerarSorteo());
		//acciones.put("Agregar", new AccionAgregarSorteo());
		//acciones.put("Modificar", new AccionModificarSorteo());
		//acciones.put("Eliminar", new AccionEliminarSorteo());
	}
	
}
