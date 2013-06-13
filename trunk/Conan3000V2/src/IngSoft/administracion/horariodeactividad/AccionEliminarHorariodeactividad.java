package IngSoft.administracion.horariodeactividad;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.administracion.bean.ActividadBeanData;
import IngSoft.administracion.bean.ActividadBeanFuncion;
import IngSoft.administracion.bean.AmbienteBeanData;
import IngSoft.administracion.bean.HorariodeactividadBeanData;
import IngSoft.administracion.bean.HorariodeactividadBeanFuncion;
import IngSoft.administracion.bean.ResultadoEmpleadoBeanData;
import IngSoft.administracion.bean.SedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;
import IngSoft.administracion.bean.TipoActividadMiniBeanData;


public class AccionEliminarHorariodeactividad extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			/*
			HorariodeactividadBeanFuncion horariodeactividadFuncion= HorariodeactividadBeanFuncion.getInstance();
			horariodeactividadFuncion.eliminarHorariodeactividad(request.getParameter("codigo"));
			
			*/
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodeactividad/buscarhorariodeactividad.jsp");
			
		}
		else
		{
			System.out.print("entro aqui   -----x AccionConsultarHorariodeactividad x-------1--- ");
			
			HorariodeactividadBeanFuncion horariodeactividadFuncion= HorariodeactividadBeanFuncion.getInstance(); 
			
			System.out.print("entro aqui   -----x AccionConsultarHorariodeactividad x-------2--- "+ request.getParameter("codigo"));
			
			HorariodeactividadBeanData  horariodeactividad=horariodeactividadFuncion.consultarHorariodeactividad(request.getParameter("codigo"));

			request.setAttribute("horariodeactividad",horariodeactividad );

			
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodeactividad/eliminarhorariodeactividad.jsp");	
			
		}

		

	}

}
