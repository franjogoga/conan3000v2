package IngSoft.venta.pago;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.venta.bean.PagoBeanData;
import IngSoft.venta.bean.PagoBeanFunction;

public class AccionAgregarPago extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				PagoBeanFunction PagoFunction= PagoBeanFunction.getInstance();
				if(tipo==2){
					
					PagoBeanData pagoData=PagoFunction.crearPago(request, response);
					
					PagoFunction.agregarPago(pagoData);
					this.direccionar(sc, request, response, "/IngSoft/ventas/pago/buscarpago.jsp");
				}
				PagoBeanData PagoData=PagoFunction.consultarPagoMembresia(request.getParameter("codigo"));

				request.setAttribute("pago", PagoData);
				this.direccionar(sc, request, response, "/IngSoft/ventas/pago/registrarpago.jsp");
					
				//EventoBeanFuncion eventoFunction= EventoBeanFuncion.getInstance();
				//Vector<SedeMiniBeanData> sedeMiniData=eventoFunction.getSedes();
				//Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFunction.getTipoEvento();
				//Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFunction.getAmbientes();
				//request.setAttribute("sedes",sedeMiniData );
				//request.setAttribute("ambientes",AmbienteMiniData );
				//request.setAttribute("tiposEvento",tipoEventoMiniData);
				//this.direccionar(sc, request, response, "/IngSoft/servicio/evento/agregarevento.jsp");			
	}

}

