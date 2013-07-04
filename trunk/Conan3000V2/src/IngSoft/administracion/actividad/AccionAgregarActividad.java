package IngSoft.administracion.actividad;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.administracion.bean.ActividadBeanData;
import IngSoft.administracion.bean.ActividadBeanFuncion;
import IngSoft.administracion.bean.AmbienteBeanData;
import IngSoft.administracion.bean.SedeBeanData;
import IngSoft.administracion.bean.TipoActividadMiniBeanData;


public class AccionAgregarActividad extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
		
		System.out.print(" ****  AccionAgregarActividad ");	
			
		ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance();
		ActividadBeanData actividadData=actividadFuncion.crearActividad(request, response);
		actividadFuncion.agregarActividad(actividadData);
		
		
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/SMAActividad?accion=Buscar&tipo=1");
		
		}
		else
		{
			


			Vector<AmbienteBeanData> 				ambientes = ActividadBeanFuncion.getInstance().getAmbientes();	
			Vector<SedeBeanData> 						sedes = ActividadBeanFuncion.getInstance().getSedes();	
			Vector<TipoActividadMiniBeanData> tipoactividades = ActividadBeanFuncion.getInstance().getTipoactividades();	

			request.setAttribute("ambientes", ambientes);
			request.setAttribute("tipoactividades", tipoactividades);
			request.setAttribute("sedes", sedes);
			
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/agregaractividad.jsp");
		
		}

	}

}
