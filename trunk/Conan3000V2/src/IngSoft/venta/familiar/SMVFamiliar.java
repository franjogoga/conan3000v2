package IngSoft.venta.familiar;

import IngSoft.general.CoServlet;

public class SMVFamiliar extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarFamiliar());
		acciones.put("Consultar", new AccionConsultarFamiliar());
		//acciones.put("Agregar", new AccionAgregarFamiliar());
		//acciones.put("Modificar", new AccionModificarFamiliar());
		acciones.put("Eliminar", new AccionEliminarFamiliar());
		//acciones.put("Seleccionar", new AccionSeleccionarFamiliar());
	}
	
}
