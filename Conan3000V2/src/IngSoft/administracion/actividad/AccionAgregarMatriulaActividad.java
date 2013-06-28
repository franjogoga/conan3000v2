package IngSoft.administracion.actividad;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ActividadBeanData;
import IngSoft.administracion.bean.CriterioActividadBeanData;
import IngSoft.administracion.bean.CriterioActividadBeanFunction;
import IngSoft.administracion.bean.CriterioActividadBeanData;
import IngSoft.administracion.bean.CriterioSedeBeanData;
import IngSoft.administracion.bean.CriterioSedeBeanFunction;
import IngSoft.administracion.bean.DepartamentoBeanData;
import IngSoft.administracion.bean.MatriculaBeanData;
import IngSoft.administracion.bean.ResultadoHorariodeactividadBeanData;
import IngSoft.administracion.bean.ResultadoSedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;
import IngSoft.administracion.bean.TipoActividadMiniBeanData;
import IngSoft.administracion.bean.DistritoBeanData;
import IngSoft.administracion.bean.ProvinciaBeanData;
import IngSoft.administracion.bean.ResultadoActividadBeanData;
import IngSoft.administracion.bean.ResultadoActividadBeanData;
import IngSoft.administracion.bean.ActividadBeanFuncion;

public class AccionAgregarMatriulaActividad extends CoAccion{


	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo").toString());
		
		
		System.out.print("AccionAgregarMatricul");
		
        // codigoActividad  checkDia codigosocio  codigofamiliar  monto 
			
			
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			System.out.print("AccionAgregarMatriculaActividad ----->");
			
			for(int i=0; i<7;i++)
			{
				
				if( request.getParameter("checkDia"+i)!=null){
					
				 System.out.print("horario --> "+ request.getParameter("checkDia"+i)   );
				 System.out.print("codigoActividad --> "+ request.getParameter("codigoActividad")   );
				 System.out.print("codigosocio --> "+ request.getParameter("codigosocio")   );
				 System.out.print("codigofamiliar --> "+ request.getParameter("codigofamiliar")   );
				 System.out.print("monto --> "+ request.getParameter("monto")   );
				 
				 
				 
				 ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance(); 
				 
				 MatriculaBeanData matriculaData = actividadFuncion.crearMatriculaActividad(
						 request.getParameter("codigoActividad"),
						 request.getParameter("codigosocio"),
						 request.getParameter("codigofamiliar"),
						 request.getParameter("checkDia"+i), 
						 request.getParameter("monto")
						 );
				 
				 actividadFuncion.agregarMatriculaActividad(matriculaData);
				 
				}
				
				
			}
		

		
			this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/buscarmatricula.jsp");
			
		}
		else
		{
		
		
			ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance(); 

			Vector<ResultadoHorariodeactividadBeanData> resultados = actividadFuncion.buscarPlantillaHorariosActividad(request.getParameter("codigo"));
			
			
           System.out.print(" --> "+ resultados.get(0).getHorario());
			
			request.setAttribute("resultados", resultados);
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/agregarmatricula.jsp");	
			
		}
		

		
		
	}

}
