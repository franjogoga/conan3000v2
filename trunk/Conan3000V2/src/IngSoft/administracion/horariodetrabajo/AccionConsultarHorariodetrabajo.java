package IngSoft.administracion.horariodetrabajo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.administracion.bean.HorariodetrabajoBeanData;
import IngSoft.administracion.bean.HorariodetrabajoBeanFuncion;



public class AccionConsultarHorariodetrabajo extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		
		HorariodetrabajoBeanFuncion horariodetrabajoFuncion= HorariodetrabajoBeanFuncion.getInstance(); 
		
	
		
		HorariodetrabajoBeanData  horariodetrabajo=horariodetrabajoFuncion.consultarHorariodetrabajo(request.getParameter("codigo"));
		System.out.print(" "+ horariodetrabajo.toString());
		
		request.setAttribute("horariodetrabajo",horariodetrabajo );

		
		this.direccionar(sc, request, response, "/IngSoft/administracion/horariodetrabajo/consultarhorariodetrabajo.jsp");	
		

	}

}
