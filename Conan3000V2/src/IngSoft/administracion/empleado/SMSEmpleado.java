   package IngSoft.administracion.empleado;

import IngSoft.general.CoServlet;

public class SMSEmpleado extends CoServlet{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarEmpleado());
		acciones.put("Consultar", new AccionConsultarEmpleado());
		acciones.put("Agregar", new AccionAgregarEmpleado());
		acciones.put("Modificar", new AccionModificarEmpleado());
		acciones.put("Eliminar", new AccionEliminarEmpleado());
		acciones.put("Seleccionar", new AccionSeleccionarEmpleado());
	}
	
}
