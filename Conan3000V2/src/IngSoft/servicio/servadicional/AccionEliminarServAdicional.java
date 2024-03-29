package IngSoft.servicio.servadicional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.ServAdicionalBeanData;
import IngSoft.servicio.bean.ServAdicionalBeanFuncion;

public class AccionEliminarServAdicional extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==1){		
			String codigo= request.getParameter("codigo");
			ServAdicionalBeanFuncion servadicionalFuncion= ServAdicionalBeanFuncion.getInstance();			
			ServAdicionalBeanData servData=servadicionalFuncion.consultarServAdicional(codigo);
			request.setAttribute("resultado", servData);
			request.setAttribute("modo","E");
			this.direccionar(sc, request, response, "/IngSoft/servicio/servadicional/consultaradicional.jsp");
		}
		if(tipo==2){	
			String codigo= request.getParameter("txtCodigo");
			ServAdicionalBeanFuncion servadicionalFuncion= ServAdicionalBeanFuncion.getInstance();			
			servadicionalFuncion.eliminarServAdicional(codigo);
			this.direccionar(sc, request, response, "/IngSoft/servicio/servadicional/SMSServAdcional?accion=Buscar&tipo=1");
		}

	}

}
