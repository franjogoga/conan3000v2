package IngSoft.venta.pago;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.venta.bean.PagoBeanData;
import IngSoft.venta.bean.PagoBeanFunction;

public class AccionEliminarPago extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			PagoBeanFunction pagoFuncion= PagoBeanFunction.getInstance();
			pagoFuncion.eliminarPago(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/ventas/pago/buscarpago.jsp");
		}
		if(Integer.valueOf(request.getParameter("tipo"))==1){
		PagoBeanFunction pagoFuncion= PagoBeanFunction.getInstance();
		PagoBeanData pagoData=pagoFuncion.consultarPagoMembresia(request.getParameter("codigo"));
		
		request.setAttribute("pago", pagoData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/pago/eliminarpago.jsp");
		}
		//this.direccionar(sc, request, response, "/IngSoft/ventas/pagoes/buscarpago.jsp");
					
				
	}

}
