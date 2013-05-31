package IngSoft.administracion.actividad;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.administracion.bean.ActividadBeanData;
import IngSoft.administracion.bean.ActividadBeanFuncion;
import IngSoft.administracion.bean.ActividadBeanData;
import IngSoft.administracion.bean.AmbienteBeanData;
import IngSoft.administracion.bean.CriterioActividadBeanData;
import IngSoft.administracion.bean.CriterioActividadBeanFunction;
import IngSoft.administracion.bean.CriterioSedeBeanData;
import IngSoft.administracion.bean.CriterioSedeBeanFunction;
import IngSoft.administracion.bean.ResultadoActividadBeanData;
import IngSoft.administracion.bean.ResultadoSedeBeanData;
import IngSoft.administracion.bean.SedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;
import IngSoft.administracion.bean.TipoActividadMiniBeanData;


public class AccionModificarActividad extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
		
			System.out.print( "-----> entro  modificar  -------->" );
			
			ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance();
		ActividadBeanData actividadData=actividadFuncion.crearActividadModificada(request, response);
		actividadFuncion.modificarActividad(actividadData);
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/buscaractividad.jsp");
		
		}
		else
		{
			
			

			
			ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance(); 
			ActividadBeanData actividadData=actividadFuncion.consultarEvento(request.getParameter("codigo"));
			

			Vector<AmbienteBeanData> 				ambientes = ActividadBeanFuncion.getInstance().getAmbientes();	
			Vector<SedeBeanData> 						sedes = ActividadBeanFuncion.getInstance().getSedes();	
			Vector<TipoActividadMiniBeanData> tipoactividades = ActividadBeanFuncion.getInstance().getTipoactividades();	

			request.setAttribute("ambientes", ambientes);
			request.setAttribute("tipoactividades", tipoactividades);
			request.setAttribute("sedes", sedes);
			
			request.setAttribute("actividad",actividadData );
			this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/modificaractividad.jsp");
		
		}

	}

}
