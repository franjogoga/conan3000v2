package IngSoft.venta.membresia;


import IngSoft.general.CoServlet;


public class SMVMembresia extends CoServlet{

	/**
	 * 
	 */
	//private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarMembresia());
		acciones.put("Consultar", new AccionConsultarMembresia());
		acciones.put("Agregar", new AccionAgregarMembresia());
		acciones.put("Modificar", new AccionModificarMembresia());
		acciones.put("Eliminar", new AccionEliminarMembresia());
	}
	
	
	
}
