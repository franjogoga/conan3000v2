package IngSoft.administracion.bungalow;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.BungalowBeanData;
import IngSoft.administracion.bean.BungalowBeanFunction;
import IngSoft.administracion.bean.AmbienteMiniBeanData;

public class AccionConsultarBungalow extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		BungalowBeanFunction bungalowFunction = BungalowBeanFunction.getInstance();
		BungalowBeanData bungalowData = bungalowFunction.consultarBungalow(request.getParameter("codigo"));
		Vector<AmbienteMiniBeanData> ambienteMiniData=bungalowFunction.getAmbientes();
		request.setAttribute("ambientes",ambienteMiniData);
		request.setAttribute("bungalow",bungalowData);
		this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/consultarbungalow.jsp");
	}
}
