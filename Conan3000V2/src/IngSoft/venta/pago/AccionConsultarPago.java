package IngSoft.venta.pago;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.PagoBeanData;
import IngSoft.venta.bean.PagoBeanFunction;
@SessionScoped
public class AccionConsultarPago extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		PagoBeanFunction PagoFuncion= PagoBeanFunction.getInstance();
		PagoBeanData PagoData=PagoFuncion.consultarPago(request.getParameter("codigo"));

		request.setAttribute("pago", PagoData);

		this.direccionar(sc, request, response, "/IngSoft/ventas/pago/verpago.jsp");
	}
	
}
