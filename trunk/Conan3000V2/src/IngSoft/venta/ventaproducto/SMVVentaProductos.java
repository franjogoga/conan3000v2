package IngSoft.venta.ventaproducto;

import IngSoft.general.CoServlet;
import IngSoft.venta.ventaproducto.AccionRegistrarVenta;


public class SMVVentaProductos extends CoServlet{
	
	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarVenta());
		acciones.put("BuscarNuevo", new AccionBuscarNuevaVenta());
		acciones.put("Consultar", new AccionConsultarVenta());
		//acciones.put("Registrar", new AccionRegistrarVentaProductos()); 
		//acciones.put("RegistrarVenta", new AccionRegistrarVenta()); 
		acciones.put("Registrar", new AccionRegistrarVenta()); 
		//acciones.put("Modificar", new AccionModificarSocio());
		//acciones.put("Eliminar", new AccionEliminarSocio());
		
	}
	
}
