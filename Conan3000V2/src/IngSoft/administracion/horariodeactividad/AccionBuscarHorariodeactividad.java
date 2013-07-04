package IngSoft.administracion.horariodeactividad;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;



import IngSoft.administracion.bean.CriterioHorariodeactividadBeanData;
import IngSoft.administracion.bean.CriterioHorariodeactividadBeanFunction;
import IngSoft.administracion.bean.ResultadoHorariodeactividadBeanData;


public class AccionBuscarHorariodeactividad extends CoAccion{


	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo").toString());
		

		 System.out.print("----------   AccionBuscarHorariodeactividad   ----------------->");
		
		if(tipo==1){
			

			
		}
		
		if(tipo==2){
			CriterioHorariodeactividadBeanData criterioActividadData =new CriterioHorariodeactividadBeanFunction().crearCriterio(request,response);
			Vector<ResultadoHorariodeactividadBeanData> resultados=new CriterioHorariodeactividadBeanFunction().buscarPlantillaHorariodeactividad(criterioActividadData);


			   
			
			request.setAttribute("resultados", resultados);
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodeactividad/buscarhorariodeactividad.jsp");	
			
		}
		

		
		
	}

}
