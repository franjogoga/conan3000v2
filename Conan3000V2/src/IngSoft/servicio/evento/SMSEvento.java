package IngSoft.servicio.evento;

import IngSoft.general.CoServlet;

public class SMSEvento extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", null);
	}
	
}
