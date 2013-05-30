package IngSoft.administracion.cancha;

import IngSoft.general.CoServlet;

public class SMACancha extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarCancha());
		acciones.put("Consultar", new AccionConsultarCancha());
		acciones.put("Agregar", new AccionAgregarCancha());
		acciones.put("Modificar", new AccionModificarCancha());
		acciones.put("Eliminar", new AccionEliminarCancha());
	}
}
