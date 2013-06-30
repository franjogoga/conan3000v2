package IngSoft.venta.pago;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.PagoBeanData;
import IngSoft.venta.bean.PagoBeanFunction;

public class AccionAplicarMulta extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				PagoBeanFunction PagoFunction= PagoBeanFunction.getInstance();
				if(tipo==2){
					
					PagoBeanData pagoData=PagoFunction.crearMulta(request, response);
					
					PagoFunction.aplicarMulta(pagoData);
					this.direccionar(sc, request, response, "/IngSoft/ventas/pago/buscarpago.jsp");
				}
				String cantidad=(String)PagoFunction.consultarMulta();

				request.setAttribute("cantidad", cantidad);
				this.direccionar(sc, request, response, "/IngSoft/ventas/pago/multas.jsp");
						
	}

}

