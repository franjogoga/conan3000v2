package IngSoft.venta.membresia;


import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.CriterioMembresiaBeanData;
import IngSoft.venta.bean.CriterioMembresiaBeanFunction;
import IngSoft.venta.bean.ResultadoMembresiaBeanData;

public class AccionBuscarMembresia extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		CriterioMembresiaBeanData criterioMembresiaData =new CriterioMembresiaBeanFunction().crearCriterio(request,response);
		Vector<ResultadoMembresiaBeanData> resultados=new CriterioMembresiaBeanFunction().buscarPlantillaMembresia(criterioMembresiaData);
		
		//request.setAttribute(name, o)
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/ventas/membresia/buscarmembresia.jsp");
		
	}

}
