package IngSoft.administracion.sede;

import IngSoft.general.CoServlet;

public class SMASede extends CoServlet{

	
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarSede());
		acciones.put("Consultar", new AccionConsultarSede());
		acciones.put("Eliminar", new  AccionEliminarSede());
		acciones.put("Modificar", new AccionModificarSede());
		

	}
	
	
}
