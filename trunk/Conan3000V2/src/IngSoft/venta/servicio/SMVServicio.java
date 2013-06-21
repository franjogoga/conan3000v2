package IngSoft.venta.servicio;

import IngSoft.general.CoServlet;

public class SMVServicio extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarServicio());
		acciones.put("Consultar", new AccionConsultarServicio());
		acciones.put("Agregar", new AccionAgregarServicio());
		acciones.put("Modificar", new AccionModificarServicio());
		acciones.put("Eliminar", new AccionEliminarServicio());
		acciones.put("Seleccionar", new AccionSeleccionarServicio());
	}
}
