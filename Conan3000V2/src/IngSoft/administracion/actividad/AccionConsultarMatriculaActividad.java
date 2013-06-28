package IngSoft.administracion.actividad;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CriterioActividadBeanData;
import IngSoft.administracion.bean.CriterioActividadBeanFunction;
import IngSoft.administracion.bean.CriterioActividadBeanData;
import IngSoft.administracion.bean.CriterioSedeBeanData;
import IngSoft.administracion.bean.CriterioSedeBeanFunction;
import IngSoft.administracion.bean.DepartamentoBeanData;
import IngSoft.administracion.bean.MatriculaBeanData;
import IngSoft.administracion.bean.ResultadoSedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;
import IngSoft.administracion.bean.TipoActividadMiniBeanData;
import IngSoft.administracion.bean.DistritoBeanData;
import IngSoft.administracion.bean.ProvinciaBeanData;
import IngSoft.administracion.bean.ResultadoActividadBeanData;
import IngSoft.administracion.bean.ResultadoActividadBeanData;
import IngSoft.administracion.bean.ActividadBeanFuncion;

public class AccionConsultarMatriculaActividad extends CoAccion{


	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo").toString());
		
		

		 System.out.print("tipo xxxx --> "+ tipo );
		
		if(tipo==2){
			


			 
			 System.out.print("codigoAct --> "+request.getParameter("codigoAct")   );
			 System.out.print("codigoSoc --> "+request.getParameter("codigoSoc")   );
			 System.out.print("codigoFam --> "+request.getParameter("codigoFam")   );
			 System.out.print("horario 	 --> "+request.getParameter("horario")   );
			 
			 ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance(); 
			 
			 actividadFuncion.eliminarMatriculaActividad(
					 request.getParameter("codigoAct"),
					 request.getParameter("codigoSoc"),
					 request.getParameter("codigoFam"),
					 request.getParameter("horario")
					 
					 );
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/buscarmatricula.jsp");
			
		}
		else
		{
			
			System.out.print("------> entrar -----> AccionConsultarMatriculaActividad ---> "+ request.getParameter("codigo") );
			
			ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance(); 
			
			Vector<MatriculaBeanData> resultados= actividadFuncion.getMatriculadosActividad(request.getParameter("codigo"),request.getParameter("horario"));

			request.setAttribute("resultados", resultados);
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/consultarmatricula.jsp");	
			
		}
		

		
		
	}

}
