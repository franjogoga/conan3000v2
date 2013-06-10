package IngSoft.administracion.concesionario;

import IngSoft.general.CoServlet;

public class SMAConcesionario extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarConcesionario());
		acciones.put("Consultar", new AccionConsultarConcesionario());
		acciones.put("Agregar", new AccionAgregarConcesionario());
		acciones.put("Modificar", new AccionModificarConcesionario());
		acciones.put("Eliminar", new AccionEliminarConcesionario());
	}
}
