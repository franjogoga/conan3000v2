package IngSoft.venta.pago;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.OrdenPagoBeanData;
import IngSoft.venta.bean.OrdenPagoBeanFunction;
import IngSoft.venta.bean.PagoBeanData;
import IngSoft.venta.bean.PagoBeanFunction;

public class AccionConsultarOrdenPago extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		OrdenPagoBeanFunction ordenPagoFuncion= OrdenPagoBeanFunction.getInstance();
		OrdenPagoBeanData ordenPagoData=ordenPagoFuncion.consultarOrdenPago(request.getParameter("codigo"));

		request.setAttribute("pago", ordenPagoData);

		this.direccionar(sc, request, response, "/IngSoft/ventas/pago/verordenpago.jsp");
	}
	
}