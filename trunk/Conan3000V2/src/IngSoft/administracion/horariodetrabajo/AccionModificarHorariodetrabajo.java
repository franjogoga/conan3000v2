package IngSoft.administracion.horariodetrabajo;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;


import IngSoft.administracion.bean.DiasBeanData;
import IngSoft.administracion.bean.HorariodetrabajoBeanData;
import IngSoft.administracion.bean.HorariodetrabajoBeanFuncion;



public class AccionModificarHorariodetrabajo extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
		
			
			/*
		HorariodetrabajoBeanFuncion horariodetrabajoFuncion= HorariodetrabajoBeanFuncion.getInstance();
		HorariodetrabajoBeanData horariodetrabajoData=horariodetrabajoFuncion.crearHorariodetrabajoModificada(request, response);
		horariodetrabajoFuncion.modificarHorariodetrabajo(horariodetrabajoData);
		    */
			
		this.direccionar(sc, request, response, "/IngSoft/administracion/horariodetrabajo/buscarhorariodetrabajo.jsp");
		
		}
		else
		{
			HorariodetrabajoBeanFuncion horariodetrabajoFuncion= HorariodetrabajoBeanFuncion.getInstance(); 
			Vector<HorariodetrabajoBeanData>  horariodetrabajo=horariodetrabajoFuncion.consultarHorariodetrabajo(request.getParameter("codigo"));
			
			Vector<DiasBeanData>  diassemana=horariodetrabajoFuncion.getDias();
			
			request.setAttribute("diassemana",diassemana );
			request.setAttribute("horariodetrabajo",horariodetrabajo );
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodetrabajo/modificarhorariodetrabajo.jsp");	
		
		}

	}

}
