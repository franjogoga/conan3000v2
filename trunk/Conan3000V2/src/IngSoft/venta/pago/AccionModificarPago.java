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
public class AccionModificarPago extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		PagoBeanFunction PagoFunction= PagoBeanFunction.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
	
			PagoBeanData PagoData=PagoFunction.crearPago(request, response);
			PagoData.setIdIngreso(request.getParameter("idIngreso"));
			PagoFunction.modificarPago(PagoData);
			this.direccionar(sc, request, response, "/IngSoft/ventas/pago/buscarpago.jsp");
		}	
		PagoBeanData PagoData=PagoFunction.consultarPagoMembresia(request.getParameter("codigo"));

		request.setAttribute("pago", PagoData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/pago/modificarpago.jsp");
	}
}