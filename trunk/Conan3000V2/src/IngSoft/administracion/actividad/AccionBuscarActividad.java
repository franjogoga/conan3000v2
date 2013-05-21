package IngSoft.administracion.actividad;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CriterioActividadBeanData;
import IngSoft.administracion.bean.CriterioActividadBeanFunction;
import IngSoft.administracion.bean.ResultadoActividadBeanData;

public class AccionBuscarActividad extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		CriterioActividadBeanData criterioActividadData =new CriterioActividadBeanFunction().crearCriterio(request,response);
		Vector<ResultadoActividadBeanData> resultados=new CriterioActividadBeanFunction().buscarPlantillaActividad(criterioActividadData);

		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/buscaractividad.jsp");
		
	}

}
