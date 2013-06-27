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
		acciones.put("pagoMembresia", new AccionReportePagoMembresia());
		acciones.put("PagoOtros", new AccionPagoOtrosServicios());
		acciones.put("EgresosClub", new AccionReporteEgresosClub());
		acciones.put("InscritosSorteo", new AccionReporteInscritosSorteo());
		acciones.put("PrecioProveedor", new AccionReportePrecioProveedor());

	}
	
}
