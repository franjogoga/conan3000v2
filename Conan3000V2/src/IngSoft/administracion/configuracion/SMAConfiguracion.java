package IngSoft.administracion.configuracion;

import IngSoft.general.CoServlet;

public class SMAConfiguracion extends CoServlet{
	
	@Override
	protected void initAcciones() {		
		acciones.put("Consultar", new AccionConsultarConfiguracion());		
		acciones.put("Modificar", new AccionModificarConfiguracion());							
	}
}
