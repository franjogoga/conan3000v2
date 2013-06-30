package IngSoft.administracion.bungalow;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.BungalowBeanFunction;
import IngSoft.administracion.bean.BungalowBeanData;
import IngSoft.administracion.bean.AmbienteMiniBeanData;
import IngSoft.administracion.bean.SedeMiniBeanData;

@SessionScoped
public class AccionEliminarBungalow extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			BungalowBeanFunction bungalowFunction= BungalowBeanFunction.getInstance();
			bungalowFunction.eliminarBungalow(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/buscarbungalow.jsp");
		}
		if(Integer.valueOf(request.getParameter("tipo"))==1){
			BungalowBeanFunction bungalowFunction= BungalowBeanFunction.getInstance();
			BungalowBeanData bungalowData=bungalowFunction.consultarBungalow(request.getParameter("codigo"));
			SedeMiniBeanData sede = bungalowFunction.consultarCodigoSede(request.getParameter("codigo"));
			Vector<SedeMiniBeanData> sedes =bungalowFunction.getSedes();
			Vector<AmbienteMiniBeanData> ambienteMiniData=bungalowFunction.getAmbientes(sede.getCodigo());
			request.setAttribute("sedes",sedes);
			request.setAttribute("ambientes",ambienteMiniData);
			request.setAttribute("bungalow",bungalowData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/eliminarbungalow.jsp");
	}
	this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/buscarbungalow.jsp");
	}
}