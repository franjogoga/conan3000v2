package IngSoft.administracion.horariodeactividad;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.administracion.bean.HorariodeactividadBeanData;
import IngSoft.administracion.bean.HorariodeactividadBeanFuncion;


public class AccionEliminarHorariodeactividad extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			
			HorariodeactividadBeanFuncion horariodeactividadFuncion= HorariodeactividadBeanFuncion.getInstance();
			horariodeactividadFuncion.eliminarHorariodeactividad(request.getParameter("codigo"));
			
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodeactividad/buscarhorariodeactividad.jsp");
			
		}
		else
		{
			
			
			HorariodeactividadBeanFuncion horariodeactividadFuncion= HorariodeactividadBeanFuncion.getInstance(); 
			HorariodeactividadBeanData  horariodeactividad=horariodeactividadFuncion.consultarHorariodeactividad(request.getParameter("codigo"));

			System.out.print(  horariodeactividad.getCodigo()             );
			System.out.print(  horariodeactividad.getNombre()            );
			System.out.print(  horariodeactividad.getCodDiasemana()       );
			System.out.print(  horariodeactividad.getDiaSemana()            );
			System.out.print(  horariodeactividad.getEstadosDias()             );
			System.out.print(  horariodeactividad.getHoraFin()             );
			System.out.print(  horariodeactividad.getHoraInicio()            );
			System.out.print(  horariodeactividad.getEstado()             );
			
			
			request.setAttribute("horariodeactividad",horariodeactividad );

			
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodeactividad/eliminarhorariodeactividad.jsp");	
			
		}

		

	}

}
