package IngSoft.administracion.horariodeactividad;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.administracion.bean.HorariodeactividadBeanData;
import IngSoft.administracion.bean.HorariodeactividadBeanFuncion;



public class AccionConsultarHorariodeactividad extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		System.out.print("entro aqui   -----x AccionConsultarHorariodeactividad x-------1--- ");
		
		HorariodeactividadBeanFuncion horariodeactividadFuncion= HorariodeactividadBeanFuncion.getInstance(); 
		
		System.out.print("entro aqui   -----x AccionConsultarHorariodeactividad x-------2--- "+ request.getParameter("codigo"));
		
		Vector<HorariodeactividadBeanData>  horariodeactividad=horariodeactividadFuncion.consultarHorariodeactividad(request.getParameter("codigo"));

		request.setAttribute("horariodeactividad",horariodeactividad );

		
		this.direccionar(sc, request, response, "/IngSoft/administracion/horariodeactividad/consultarhorariodeactividad.jsp");	
		

	}

}
