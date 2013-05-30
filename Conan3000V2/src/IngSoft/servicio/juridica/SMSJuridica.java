package IngSoft.servicio.juridica;

import IngSoft.general.CoServlet;

public class SMSJuridica extends CoServlet{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarJuridica());
		acciones.put("Consultar", new AccionConsultarJuridica());
		acciones.put("Agregar", new AccionAgregarJuridica());
		acciones.put("Modificar", new AccionModificarJuridica());
		acciones.put("Eliminar", new AccionEliminarJuridica());
	}
	
}
