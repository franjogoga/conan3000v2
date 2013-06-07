package IngSoft.venta.pago;


import IngSoft.general.CoServlet;


public class SMVPago extends CoServlet{

	/**
	 * 
	 */
	//private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarPago());
		acciones.put("Consultar", new AccionConsultarPago());
		acciones.put("Pagar", new AccionAgregarPago());
		acciones.put("Modificar", new AccionModificarPago());
		acciones.put("Eliminar", new AccionEliminarPago());
	}
	
	
	
}
