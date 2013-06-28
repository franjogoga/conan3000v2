package IngSoft.administracion.actividad;

import IngSoft.general.CoServlet;

public class SMAActividad extends CoServlet{

	
	
	@Override
	protected void initAcciones() {		
		acciones.put("Buscar", new AccionBuscarActividad());
		acciones.put("Consultar", new AccionConsultarActividad());
		acciones.put("Eliminar", new  AccionEliminarActividad());
		acciones.put("Modificar", new AccionModificarActividad());
		acciones.put("Agregar", new AccionAgregarActividad());
		
		
		acciones.put("Seleccionar", new AccionSeleccionarEmpleado());
		
		
		acciones.put("BuscarMatricula", new AccionBuscarMatriculaActividad());
		
		
		
		acciones.put("Agregarmatricula", new AccionAgregarMatriulaActividad());
		
		acciones.put("Consultarmatricula", new AccionConsultarMatriculaActividad());
		
		
		acciones.put("SeleccionarSocio", new AccionSeleccionarSocio());

		
		
	}
	
	
}
