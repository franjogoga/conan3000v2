package IngSoft.administracion.horariodetrabajo;

import IngSoft.general.CoServlet;

public class SMAHorariodetrabajo extends CoServlet{

	
	
	@Override
	protected void initAcciones() {		
		acciones.put("Buscar", new AccionBuscarHorariodetrabajo());
		
		System.out.print("entra aqui ----> ");
		
		acciones.put("Consultar", new AccionConsultarHorariodetrabajo());
		
		
		acciones.put("Eliminar", new  AccionEliminarHorariodetrabajo());
		
		
		acciones.put("Modificar", new AccionModificarHorariodetrabajo());
		
		
		acciones.put("Agregar", new AccionAgregarHorariodetrabajo());
		
		
		

	}
	
	
}
