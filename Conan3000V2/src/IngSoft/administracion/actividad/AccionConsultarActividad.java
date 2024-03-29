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
import IngSoft.administracion.bean.ResultadoEmpleadoBeanData;
import IngSoft.administracion.bean.SedeBeanData;
import IngSoft.administracion.bean.TipoActividadMiniBeanData;


public class AccionConsultarActividad extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance(); 
		ActividadBeanData actividadData=actividadFuncion.consultarActividad(request.getParameter("codigo"));
		
		Vector<AmbienteBeanData> 				ambientes = ActividadBeanFuncion.getInstance().getAmbientes();	
		Vector<SedeBeanData> 						sedes = ActividadBeanFuncion.getInstance().getSedes();	
		Vector<TipoActividadMiniBeanData> tipoactividades = ActividadBeanFuncion.getInstance().getTipoactividades();	
		Vector<ResultadoEmpleadoBeanData> 				empleados = ActividadBeanFuncion.getInstance().getEmpleados();	
		

		request.setAttribute("ambientes", ambientes);
		request.setAttribute("tipoactividades", tipoactividades);
		request.setAttribute("sedes", sedes);
		request.setAttribute("empleados", empleados);
		request.setAttribute("actividad",actividadData );
		
		
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/consultaractividad.jsp");
		

	}

}
