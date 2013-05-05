package IngSoft.administracion.sede;

import IngSoft.general.CoServlet;

public class SMASede extends CoServlet{

	
	
	@Override
	protected void initAcciones() {
		acciones.put("Consultar", new AccionConsultarSede());
		
		System.out.print("--> SMASede ");
		
		/*
		acciones.put("Consultar", new AccionConsultarEvento());
		acciones.put("Agregar", new AccionAgregarEvento());
		acciones.put("Modificar", new AccionModificarEvento());
		acciones.put("Eliminar", new AccionEliminarEvento());
	*/
	}
	
	
}
