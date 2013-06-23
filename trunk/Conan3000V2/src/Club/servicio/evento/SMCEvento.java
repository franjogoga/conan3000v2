   package Club.servicio.evento;

import IngSoft.general.CoServlet;

public class SMCEvento extends CoServlet{
	
	/**
	 * 
	 */
//	private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarEvento());
		acciones.put("Consultar", new AccionConsultarEvento());
		acciones.put("Agregar", new AccionAgregarEvento());
		acciones.put("Modificar", new AccionModificarEvento());
		acciones.put("Eliminar", new AccionEliminarEvento());
	}
	
}
