package IngSoft.venta.pago;


import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioPagoBeanData;
import IngSoft.venta.bean.CriterioPagoBeanFunction;
import IngSoft.venta.bean.PagoBeanFunction;
import IngSoft.venta.bean.ResultadoPagoBeanData;
@SessionScoped
public class AccionBuscarPago extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioPagoBeanData criterioPagoData =new CriterioPagoBeanFunction().crearCriterio(request,response);
		Vector<ResultadoPagoBeanData> resultados=new CriterioPagoBeanFunction().buscarPago(criterioPagoData);
		PagoBeanFunction pago=PagoBeanFunction.getInstance();
		pago.cuotaVitalicio();
		
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/pago/buscarpago.jsp");
		
	}

}
