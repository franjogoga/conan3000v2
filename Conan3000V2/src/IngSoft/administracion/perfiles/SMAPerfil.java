package IngSoft.administracion.perfiles;

import IngSoft.general.CoServlet;

public class SMAPerfil extends CoServlet{
	@Override
	protected void initAcciones() {		
		acciones.put("Buscar", new AccionBuscarPerfil());
		acciones.put("Consultar", new AccionConsultarPerfil());
		acciones.put("Agregar", new AccionAgregarPerfil());
		acciones.put("Modificar", new AccionModificarPerfil());
		acciones.put("Eliminar", new AccionEliminarPerfil());		
	}
}
