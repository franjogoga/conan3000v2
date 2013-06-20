package Club.servicio.sorteo;

import IngSoft.general.CoServlet;

public class SMCSorteo extends CoServlet{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarInscripcionSorteo());
		acciones.put("Inscripcion", new AccionInscripcionSorteo());
		acciones.put("Consultar", new AccionGenerarSorteo());
		acciones.put("Pagar", new AccionPagarSorteo());
		//acciones.put("Eliminar", new AccionEliminarSorteo());
	}
	
}
