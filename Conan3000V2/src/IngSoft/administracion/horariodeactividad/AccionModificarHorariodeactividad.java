package IngSoft.administracion.horariodeactividad;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;


import IngSoft.administracion.bean.DiasBeanData;
import IngSoft.administracion.bean.HorariodeactividadBeanData;
import IngSoft.administracion.bean.HorariodeactividadBeanFuncion;



public class AccionModificarHorariodeactividad extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
		
			
			/*
		HorariodeactividadBeanFuncion horariodeactividadFuncion= HorariodeactividadBeanFuncion.getInstance();
		HorariodeactividadBeanData horariodeactividadData=horariodeactividadFuncion.crearHorariodeactividadModificada(request, response);
		horariodeactividadFuncion.modificarHorariodeactividad(horariodeactividadData);
		    */
			
		this.direccionar(sc, request, response, "/IngSoft/administracion/horariodeactividad/buscarhorariodeactividad.jsp");
		
		}
		else
		{
			HorariodeactividadBeanFuncion horariodeactividadFuncion= HorariodeactividadBeanFuncion.getInstance(); 
			HorariodeactividadBeanData  horariodeactividad=horariodeactividadFuncion.consultarHorariodeactividad(request.getParameter("codigo"));
			
			Vector<DiasBeanData>  diassemana=horariodeactividadFuncion.getDias();
			
			request.setAttribute("diassemana",diassemana );
			request.setAttribute("horariodeactividad",horariodeactividad );
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodeactividad/modificarhorariodeactividad.jsp");	
		
		}

	}

}
