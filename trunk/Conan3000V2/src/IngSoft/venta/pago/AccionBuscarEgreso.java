package IngSoft.venta.pago;


import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioEgresoBeanData;
import IngSoft.venta.bean.CriterioEgresoBeanFunction;
import IngSoft.venta.bean.ResultadoEgresoBeanData;

public class AccionBuscarEgreso extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioEgresoBeanData criterioEgresoData =new CriterioEgresoBeanFunction().crearCriterio(request,response);
		Vector<ResultadoEgresoBeanData> resultados=new CriterioEgresoBeanFunction().buscarEgreso(criterioEgresoData);
		
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/pago/buscaregreso.jsp");
		
	}

}
