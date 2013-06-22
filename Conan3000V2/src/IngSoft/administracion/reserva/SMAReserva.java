package IngSoft.administracion.reserva;

import IngSoft.general.CoServlet;

public class SMAReserva extends CoServlet{
	@Override
	protected void initAcciones() {	
		System.out.print("entra");
		acciones.put("Buscar", new AccionBuscarReserva());
		acciones.put("Consultar", new AccionConsultarReserva());
		acciones.put("Eliminar", new AccionEliminarReserva());		
		acciones.put("Modificar", new AccionModificarReserva());
		
		acciones.put("Agregar", new AccionAgregarReserva()); 
   
	}
}
