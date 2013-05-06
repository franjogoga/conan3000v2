package IngSoft.administracion.invitado;

import IngSoft.administracion.invitado.AccionConsultarInvitado;
import IngSoft.general.CoServlet;

public class SMAInvitado extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Consultar", new AccionConsultarInvitado());
		
		System.out.print("--> SMAInvitado ");
		
		/*
		acciones.put("Consultar", new AccionConsultarEvento());
		acciones.put("Agregar", new AccionAgregarEvento());
		acciones.put("Modificar", new AccionModificarEvento());
		acciones.put("Eliminar", new AccionEliminarEvento());
	*/
	}

	
}
