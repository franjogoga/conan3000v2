   package Club.servicio.reserva;

import IngSoft.general.CoServlet;

public class SMCReserva extends CoServlet{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarReserva());
		acciones.put("Crear", new AccionCrearReserva());
		acciones.put("Eliminar", new AccionEliminarReserva());
	}
	
}
