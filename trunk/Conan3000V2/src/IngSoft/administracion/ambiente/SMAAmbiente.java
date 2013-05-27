package IngSoft.administracion.ambiente;

import IngSoft.general.CoServlet;

public class SMAAmbiente extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarAmbiente());
		acciones.put("Consultar", new AccionConsultarAmbiente());
		acciones.put("Agregar", new AccionAgregarAmbiente());
		acciones.put("Modificar", new AccionModificarAmbiente());
		acciones.put("Eliminar", new AccionEliminarAmbiente());
	}
}
