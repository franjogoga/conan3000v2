package IngSoft.servicio.evento;

import IngSoft.general.CoServlet;

public class SMSEvento extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarEvento());
		acciones.put("Agregar", new AccionAgregarEvento());
		acciones.put("Modificar", new AccionModificarEvento());
	}
	
}
