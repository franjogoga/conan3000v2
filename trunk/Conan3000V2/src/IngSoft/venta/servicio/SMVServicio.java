package IngSoft.venta.servicio;

import IngSoft.general.CoServlet;
import IngSoft.venta.proveedor.AccionAgregarProveedor;
import IngSoft.venta.proveedor.AccionBuscarProveedor;
import IngSoft.venta.proveedor.AccionConsultarProveedor;
import IngSoft.venta.proveedor.AccionEliminarProveedor;
import IngSoft.venta.proveedor.AccionModificarProveedor;
import IngSoft.venta.proveedor.AccionSeleccionarProveedor;

public class SMVServicio extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarServicio());
		//acciones.put("Consultar", new AccionConsultarServicio());
		//acciones.put("Agregar", new AccionAgregarServicio());
		//acciones.put("Modificar", new AccionModificarServicio());
		//acciones.put("Eliminar", new AccionEliminarServicio());
		//acciones.put("Seleccionar", new AccionSeleccionarServicio());
	}
	
	
	
}
