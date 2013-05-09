package IngSoft.administracion.sede;

import IngSoft.general.CoServlet;

public class SMASede extends CoServlet{

	
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarSede());
		//acciones.put("Eliminar", new AccionEliminarSede());
		
		
		/*
		acciones.put("Consultar", new AccionConsultarEvento());
		acciones.put("Agregar", new AccionAgregarEvento());
		acciones.put("Modificar", new AccionModificarEvento());
		
	*/
	}
	
	
}
