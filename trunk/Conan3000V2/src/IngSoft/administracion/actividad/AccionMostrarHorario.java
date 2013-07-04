package IngSoft.administracion.actividad;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ResultadoHorariodeactividadBeanData;
import IngSoft.administracion.bean.ActividadBeanFuncion;

public class AccionMostrarHorario extends CoAccion{


	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo").toString());
		
		System.out.print("AccionBuscarActividad ----->");

		

			
			
			ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance(); 

			Vector<ResultadoHorariodeactividadBeanData> resultados = actividadFuncion.buscarPlantillaHorariosActividad(request.getParameter("codigo"));
			
			
           System.out.print(" --> "+ resultados.get(0).getHorario());
			
			request.setAttribute("resultados", resultados);
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/agregarmatricula.jsp");	
			
	
		

		
		
	}

}
