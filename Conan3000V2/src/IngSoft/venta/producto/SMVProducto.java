package IngSoft.venta.producto;
import IngSoft.general.CoServlet;


public class SMVProducto extends CoServlet{

	/**
	 * 
	 */
	//private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarProducto());
	    acciones.put("Consultar", new AccionConsultarProducto());
		acciones.put("Agregar", new AccionAgregarProducto());
		acciones.put("Modificar", new AccionModificarProducto());

		acciones.put("Eliminar", new AccionEliminarProducto());
		
	}
}
	
	