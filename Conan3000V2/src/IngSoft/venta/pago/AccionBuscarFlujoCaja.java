
package IngSoft.venta.pago;


import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioPagoBeanData;
import IngSoft.venta.bean.CriterioPagoBeanFunction;
import IngSoft.venta.bean.ResultadoFlujoCajaBeanData;

public class AccionBuscarFlujoCaja extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioPagoBeanData criterioPagoData =new CriterioPagoBeanFunction().crearCriterioFlujo(request,response);
		Vector<ResultadoFlujoCajaBeanData> resultados=new CriterioPagoBeanFunction().buscarFlujo(criterioPagoData);
		
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/pago/flujocaja.jsp");
		
	}

}
