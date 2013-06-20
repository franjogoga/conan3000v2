package IngSoft.venta.ventaproducto;

import IngSoft.general.CoServlet;
import IngSoft.venta.socio.AccionAgregarSocio;
import IngSoft.venta.socio.AccionBuscarSocio;


public class SMVVentaProductos extends CoServlet{
	
	@Override
	protected void initAcciones() {
		//acciones.put("Buscar", new AccionBuscarSocio());
		//acciones.put("Consultar", new AccionConsultarSocio());
		acciones.put("Agregar", new AccionAgregarSocio()); //este es para agregar venta
		//acciones.put("Modificar", new AccionModificarSocio());
		//acciones.put("Eliminar", new AccionEliminarSocio());
		
	}
	
}
