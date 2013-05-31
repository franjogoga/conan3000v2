package IngSoft.administracion.actividad;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.administracion.bean.ActividadBeanData;
import IngSoft.administracion.bean.ActividadBeanFuncion;
import IngSoft.administracion.bean.SedeBeanFuncion;


public class AccionEliminarActividad extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			
			ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance();
			actividadFuncion.eliminarActividad(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/buscaractividad.jsp");
			
		}
		else
		{
			ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance(); 
			ActividadBeanData actividadData=actividadFuncion.consultarEvento(request.getParameter("codigo"));
			request.setAttribute("actividad",actividadData );
			this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/eliminaractividad.jsp");
			
		}

		

	}

}
