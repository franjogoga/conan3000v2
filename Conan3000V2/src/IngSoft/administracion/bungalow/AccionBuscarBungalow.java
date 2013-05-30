package IngSoft.administracion.bungalow;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.BungalowBeanFunction;
import IngSoft.administracion.bean.CriterioBungalowBeanData;
import IngSoft.administracion.bean.CriterioBungalowBeanFunction;
import IngSoft.administracion.bean.ResultadoBungalowBeanData;
import IngSoft.administracion.bean.AmbienteMiniBeanData;

public class AccionBuscarBungalow extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		int tipo= Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			CriterioBungalowBeanData criterioBungalowData = new CriterioBungalowBeanFunction().crearCriterio(request,response);
			Vector<ResultadoBungalowBeanData> resultados = new CriterioBungalowBeanFunction().buscarBungalow(criterioBungalowData);
			BungalowBeanFunction bungalowFunction= BungalowBeanFunction.getInstance();
			Vector<AmbienteMiniBeanData> ambienteMiniData=bungalowFunction.getAmbientes();
			request.setAttribute("ambientes",ambienteMiniData);
			request.setAttribute("resultados", resultados);
			this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/buscarbungalow.jsp");
		}
		if(tipo==1){
			BungalowBeanFunction bungalowFunction= BungalowBeanFunction.getInstance();
			Vector<AmbienteMiniBeanData> ambienteMiniData=bungalowFunction.getAmbientes();
			request.setAttribute("ambientes",ambienteMiniData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/buscarbungalow.jsp");
		}
		 	
	}
}