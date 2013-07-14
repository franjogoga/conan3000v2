package IngSoft.servicio.servadicional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.ServAdicionalBeanData;
import IngSoft.servicio.bean.ServAdicionalBeanFuncion;

public class AccionAgregarServAdicional extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==1){
			this.direccionar(sc, request, response, "/IngSoft/servicio/servadicional/agregadicional.jsp");
		}
		if(tipo==2){	
			ServAdicionalBeanFuncion servadicionalFuncion= ServAdicionalBeanFuncion.getInstance();
			ServAdicionalBeanData servadicionalData=servadicionalFuncion.crearServAdicional(request, response);
			servadicionalFuncion.agregarServAdicional(servadicionalData);			
			
		}

	}

}
