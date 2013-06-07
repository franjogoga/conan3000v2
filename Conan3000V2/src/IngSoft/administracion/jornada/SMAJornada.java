package IngSoft.administracion.jornada;

import IngSoft.general.CoServlet;

public class SMAJornada extends CoServlet{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarJornada());
		//acciones.put("Generar", new AccionGenerarJornada());
		acciones.put("Agregar", new AccionAgregarJornada());
		//acciones.put("Modificar", new AccionModificarJornada());
		//acciones.put("Eliminar", new AccionEliminarJornada());
	}
	
}
