package IngSoft.servicio.sorteo;

import IngSoft.general.CoServlet;

public class SMSSorteo extends CoServlet{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarSorteo());
		//acciones.put("Consultar", new AccionConsultarSorteo());
		acciones.put("Agregar", new AccionAgregarSorteo());
		//acciones.put("Modificar", new AccionModificarSorteo());
		acciones.put("Eliminar", new AccionEliminarSorteo());
	}
	
}
