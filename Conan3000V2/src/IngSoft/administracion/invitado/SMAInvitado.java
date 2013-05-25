package IngSoft.administracion.invitado;

import IngSoft.general.CoServlet;

public class SMAInvitado extends CoServlet{
	@Override
	protected void initAcciones() {		
		acciones.put("Buscar", new AccionBuscarInvitado());
		acciones.put("Consultar", new AccionConsultarInvitado());
		acciones.put("Agregar", new AccionAgregarInvitado()); 
		acciones.put("Modificar", new AccionModificarInvitado());
		acciones.put("Eliminar", new AccionEliminarInvitado());		
	}
}
