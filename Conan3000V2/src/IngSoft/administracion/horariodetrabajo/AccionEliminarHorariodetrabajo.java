package IngSoft.administracion.horariodetrabajo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.administracion.bean.HorariodetrabajoBeanData;
import IngSoft.administracion.bean.HorariodetrabajoBeanFuncion;


public class AccionEliminarHorariodetrabajo extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			
			HorariodetrabajoBeanFuncion horariodetrabajoFuncion= HorariodetrabajoBeanFuncion.getInstance();
			horariodetrabajoFuncion.eliminarHorariodetrabajo(request.getParameter("codigo"));
			
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodetrabajo/buscarhorariodetrabajo.jsp");
			
		}
		else
		{
			
			
			HorariodetrabajoBeanFuncion horariodetrabajoFuncion= HorariodetrabajoBeanFuncion.getInstance(); 
			
			
			
			HorariodetrabajoBeanData  horariodetrabajo=horariodetrabajoFuncion.consultarHorariodetrabajo(request.getParameter("codigo"));

			request.setAttribute("horariodetrabajo",horariodetrabajo );

			
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodetrabajo/eliminarhorariodetrabajo.jsp");	
			
		}

		

	}

}
