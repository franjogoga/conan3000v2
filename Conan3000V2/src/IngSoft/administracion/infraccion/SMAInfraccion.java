package IngSoft.administracion.infraccion;

import IngSoft.general.CoServlet;

public class SMAInfraccion extends CoServlet{
	@Override
	protected void initAcciones() {						
		acciones.put("Buscar", new AccionBuscarInfraccion());
		acciones.put("Agregar", new AccionAgregarInfraccion());
		acciones.put("Consultar", new AccionConsultarInfraccion());
	}
}
