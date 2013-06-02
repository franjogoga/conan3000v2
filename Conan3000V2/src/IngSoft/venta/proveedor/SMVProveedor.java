package IngSoft.venta.proveedor;

import IngSoft.general.CoServlet;
import IngSoft.venta.socio.AccionAgregarSocio;
import IngSoft.venta.socio.AccionBuscarSocio;
//import IngSoft.venta.socio.AccionConsultarSocio;
//import IngSoft.venta.socio.AccionEliminarSocio;
//import IngSoft.venta.socio.AccionModificarSocio;

public class SMVProveedor extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarProveedor());
		acciones.put("Consultar", new AccionConsultarProveedor());
		acciones.put("Agregar", new AccionAgregarProveedor());
		//acciones.put("Modificar", new AccionModificarProveedor());
		acciones.put("Eliminar", new AccionEliminarProveedor());
		acciones.put("Seleccionar", new AccionSeleccionarProveedor());
	}
	
}
