package IngSoft.administracion.servicio;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ServicioBeanFunction;
import IngSoft.administracion.bean.CriterioServicioBeanData;
import IngSoft.administracion.bean.CriterioServicioBeanFunction;
import IngSoft.administracion.bean.ResultadoServicioBeanData;
import IngSoft.administracion.bean.AmbienteMiniBeanData;

public class AccionBuscarServicio extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		int tipo= Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			CriterioServicioBeanData criterioServicioData = new CriterioServicioBeanFunction().crearCriterio(request,response);
			Vector<ResultadoServicioBeanData> resultados = new CriterioServicioBeanFunction().buscarServicio(criterioServicioData);
			ServicioBeanFunction servicioFunction= ServicioBeanFunction.getInstance();
			Vector<AmbienteMiniBeanData> ambienteMiniData = servicioFunction.getAmbientes();
			request.setAttribute("ambientes",ambienteMiniData);
			request.setAttribute("resultados", resultados);
			this.direccionar(sc, request, response, "/IngSoft/administracion/servicio/buscarservicio.jsp");
		}
		if(tipo==1){
			ServicioBeanFunction servicioFunction= ServicioBeanFunction.getInstance();
			Vector<AmbienteMiniBeanData> ambienteMiniData=servicioFunction.getAmbientes();
			request.setAttribute("ambientes",ambienteMiniData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/servicio/buscarservicio.jsp");
		}
	}
}