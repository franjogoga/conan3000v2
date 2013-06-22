package IngSoft.administracion.infraccion;

import IngSoft.general.CoServlet;

public class SMAInfraccion extends CoServlet{
	@Override
	protected void initAcciones() {		
				
		acciones.put("Buscarinf", new AccionBuscarInfraccion());
		//acciones.put("Consultarinf", new AccionConsultarInfraccion());
		//acciones.put("Eliminarinf", new AccionEliminarInfraccion());		
		//acciones.put("Modificarinf", new AccionModificarInfraccion());
		//acciones.put("Multar", new AccionAgregarInfraccion()); 
		
   
	}
}
