package IngSoft.administracion.actividad;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.administracion.bean.ActividadBeanData;
import IngSoft.administracion.bean.ActividadBeanFuncion;


public class AccionConsultarActividad extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance();
		
		
		 
		 
		ActividadBeanData actividadData=actividadFuncion.consultarEvento(request.getParameter("codigo"));

		
	
		
		
		request.setAttribute("actividad",actividadData );



		this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/consultaractividad.jsp");
		

	}

}
