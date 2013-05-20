package IngSoft.venta.socio;

import IngSoft.general.CoServlet;
import IngSoft.venta.promocion.AccionAgregarPromocion;
import IngSoft.venta.promocion.AccionBuscarPromocion;
import IngSoft.venta.promocion.AccionConsultarPromocion;
import IngSoft.venta.promocion.AccionEliminarPromocion;
import IngSoft.venta.promocion.AccionModificarPromocion;

public class SMVSocio extends CoServlet{
	
	@Override
	protected void initAcciones() {
		//acciones.put("Buscar", new AccionBuscarPromocion());
		//acciones.put("Consultar", new AccionConsultarPromocion());
		acciones.put("Agregar", new AccionAgregarSocio());
		//acciones.put("Modificar", new AccionModificarPromocion());
		//acciones.put("Eliminar", new AccionEliminarPromocion());
	}
	
}
