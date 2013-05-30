package IngSoft.administracion.bungalow;

import IngSoft.general.CoServlet;

public class SMABungalow extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarBungalow());
		acciones.put("Consultar", new AccionConsultarBungalow());
		acciones.put("Agregar", new AccionAgregarBungalow());
		acciones.put("Modificar", new AccionModificarBungalow());
		acciones.put("Eliminar", new AccionEliminarBungalow());
	}
}
