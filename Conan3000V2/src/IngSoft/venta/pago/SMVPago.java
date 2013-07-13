package IngSoft.venta.pago;


import IngSoft.general.CoServlet;


public class SMVPago extends CoServlet{

	/**
	 * 
	 */
	//private static final long serialVersionUID = -8594038457439090712L;

	@Override
	protected void initAcciones() {
		acciones.put("Buscar", new AccionBuscarPago());
		acciones.put("Consultar", new AccionConsultarPago());
		acciones.put("Pagar", new AccionAgregarPago());
		acciones.put("BuscarOrdenPago", new AccionBuscarOrdenPago());
		acciones.put("BuscarOrdenPago2", new AccionBuscarOrdenPago2());
		acciones.put("AgregarCuotaExtraordinaria", new AccionAgregarCuotaExtra());
		acciones.put("AgregarOrdenPago", new AccionAgregarOrdenPago());
		acciones.put("ConsultarOrdenPago", new AccionConsultarOrdenPago());
		acciones.put("BuscarEgreso", new AccionBuscarEgreso());
		acciones.put("AgregarEgreso", new AccionAgregarEgreso());
		acciones.put("ConsultarEgreso", new AccionConsultarEgreso());
		acciones.put("Modificar", new AccionModificarPago());
		acciones.put("Eliminar", new AccionEliminarPago());
		acciones.put("SeleccionarSocioNoMembresia", new AccionSeleccionarNoMembresia());
		acciones.put("SeleccionarMembresia", new AccionSeleccionarSocioPago());
		acciones.put("AplicarMulta", new AccionAplicarMulta());
		acciones.put("AplicarMultaExtra", new AccionAplicarMultaExtra());
		acciones.put("BuscarFlujoCaja", new AccionBuscarFlujoCaja());
	}
	
	
}
