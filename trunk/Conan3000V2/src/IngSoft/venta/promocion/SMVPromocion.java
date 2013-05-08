package IngSoft.venta.promocion;

import IngSoft.general.CoServlet;


public class SMVPromocion extends CoServlet{

	/**
	 * 
	 */
	//private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarPromocion());
		acciones.put("Consultar", new AccionConsultarPromocion());
		acciones.put("Agregar", new AccionAgregarPromocion());
		acciones.put("Modificar", new AccionModificarPromocion());
		acciones.put("Eliminar", new AccionEliminarPromocion());
	}
	
	
	
}
