package IngSoft.venta.ventaproducto;

import IngSoft.general.CoServlet;
import IngSoft.venta.producto.AccionRegistrarVenta;
import IngSoft.venta.socio.AccionAgregarSocio;
import IngSoft.venta.socio.AccionBuscarSocio;


public class SMVVentaProductos extends CoServlet{
	
	@Override
	protected void initAcciones() {
		//acciones.put("Buscar", new AccionBuscarSocio());
		//acciones.put("Consultar", new AccionConsultarSocio());
		//acciones.put("Registrar", new AccionRegistrarVentaProductos()); 
		acciones.put("RegistrarVenta", new AccionRegistrarVenta()); 
		//acciones.put("Modificar", new AccionModificarSocio());
		//acciones.put("Eliminar", new AccionEliminarSocio());
		
	}
	
}
