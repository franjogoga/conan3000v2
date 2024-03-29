package IngSoft.venta.socio;

import IngSoft.general.CoServlet;
import IngSoft.venta.socio.AccionAgregarSocio;
import IngSoft.venta.socio.AccionBuscarSocio;
//import IngSoft.venta.socio.AccionConsultarSocio;
//import IngSoft.venta.socio.AccionEliminarSocio;
//import IngSoft.venta.socio.AccionModificarSocio;

public class SMVSocio extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarSocio());
		acciones.put("Consultar", new AccionConsultarSocio());
		acciones.put("Agregar", new AccionAgregarSocio()); //este es para agregar en traslado
		
		acciones.put("Modificar", new AccionModificarSocio());
		acciones.put("Eliminar", new AccionEliminarSocio());
		acciones.put("Seleccionar", new AccionSeleccionarSocio());
		acciones.put("AgregarMini", new AccionAgregarMiniSocio()); //este es para el agregar en socio membresia
	}
	
}
