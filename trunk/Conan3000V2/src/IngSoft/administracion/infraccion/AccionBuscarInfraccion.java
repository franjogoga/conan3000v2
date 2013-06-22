package IngSoft.administracion.infraccion;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CriterioInfraccionBeanData;
import IngSoft.administracion.bean.CriterioInfraccionBeanFunction;
import IngSoft.administracion.bean.ResultadoInfraccionBeanData;


public class AccionBuscarInfraccion extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub

		CriterioInfraccionBeanData criterioInfraccionData =new CriterioInfraccionBeanFunction().crearCriterio(request,response);
		Vector<ResultadoInfraccionBeanData> resultados=new CriterioInfraccionBeanFunction().buscarPlantillaInfraccion(criterioInfraccionData);

		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/administracion/infraccion/buscarinfraccion.jsp");
		
	}

}
