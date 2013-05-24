package IngSoft.venta.traslado;



import IngSoft.general.CoServlet;
import IngSoft.venta.traslado.AccionAgregarTraslado;

public class SMVTraslado extends CoServlet{
	
	@Override
	protected void initAcciones() {

		acciones.put("Agregar", new AccionAgregarTraslado());
		//acciones.put("Insertar", new AccionConsultarTraslado());
	}
	
}
	
	

