package IngSoft.administracion.socio;

import IngSoft.general.CoServlet;

public class SMASocio extends CoServlet{
	@Override
	protected void initAcciones() {		
		acciones.put("Buscar", new AccionBuscarSocio());
		acciones.put("Vitalizar", new AccionVitalizarSocio());
		acciones.put("Suspender", new AccionSuspenderSocio());			
	}
}
