   package IngSoft.servicio.servadicional;

import IngSoft.general.CoServlet;

public class SMSServAdcional extends CoServlet{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarServAdicional());
		acciones.put("Agregar", new AccionAgregarServAdicional());
		acciones.put("Modificar", new AccionModificarServAdcional());
		acciones.put("Consultar", new AccionConsultarServAdicional());
		acciones.put("Eliminar", new AccionEliminarServAdicional());
	}
	
}
