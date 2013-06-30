package IngSoft.administracion.infraccion;

import IngSoft.administracion.reserva.AccionAgregarReserva;
import IngSoft.general.CoServlet;

public class SMAInfraccion extends CoServlet{
	@Override
	protected void initAcciones() {						
		acciones.put("Buscar", new AccionBuscarInfraccion());
		acciones.put("Agregar", new AccionAgregarInfraccion()); 		   
	}
}
