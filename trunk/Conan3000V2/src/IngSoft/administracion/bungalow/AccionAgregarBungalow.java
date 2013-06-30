package IngSoft.administracion.bungalow;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.BungalowBeanData;
import IngSoft.administracion.bean.BungalowBeanFunction;
import IngSoft.administracion.bean.AmbienteMiniBeanData;
import IngSoft.administracion.bean.SedeMiniBeanData;

@SessionScoped
public class AccionAgregarBungalow extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException {
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			BungalowBeanFunction bungalowFunction= BungalowBeanFunction.getInstance();
			BungalowBeanData bungalowData=bungalowFunction.crearBungalow(request, response);
			bungalowFunction.agregarBungalow(bungalowData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/buscarbungalow.jsp");
		}
		BungalowBeanFunction bungalowFunction= BungalowBeanFunction.getInstance();
		Vector<SedeMiniBeanData> sedes =bungalowFunction.getSedes();
		Vector<AmbienteMiniBeanData> ambienteMiniData=bungalowFunction.getAmbientes(sedes.get(0).getCodigo());
		request.setAttribute("sedes",sedes);
		request.setAttribute("ambientes",ambienteMiniData);
		this.direccionar(sc, request, response, "/IngSoft/administracion/bungalow/agregarbungalow.jsp");
	}
}