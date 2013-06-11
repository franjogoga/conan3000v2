package IngSoft.administracion.horariodeactividad;

import IngSoft.general.CoServlet;

public class SMAHorariodeactividad extends CoServlet{

	
	
	@Override
	protected void initAcciones() {	
		
		
		
		acciones.put("Buscar", new AccionBuscarHorariodeactividad());
		
		
		
		acciones.put("Consultar", new AccionConsultarHorariodeactividad());
		
		
		acciones.put("Eliminar", new  AccionEliminarHorariodeactividad());
		
		
		acciones.put("Modificar", new AccionModificarHorariodeactividad());
		
		
		acciones.put("Agregar", new AccionAgregarHorariodeactividad());
		
		
		

	}
	
	
}
