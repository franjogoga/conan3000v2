package IngSoft.venta.pago;


import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioOrdenPagoBeanData;
import IngSoft.venta.bean.CriterioOrdenPagoBeanFunction;
import IngSoft.venta.bean.ResultadoOrdenPagoBeanData;
@SessionScoped
public class AccionBuscarOrdenPago extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioOrdenPagoBeanData criterioOrdenPagoData =new CriterioOrdenPagoBeanFunction().crearCriterio(request,response);
		Vector<ResultadoOrdenPagoBeanData> resultados=new CriterioOrdenPagoBeanFunction().buscarOrdenPago(criterioOrdenPagoData);
		
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/pago/buscarpagootros.jsp");
		
	}

}
