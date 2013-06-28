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
import IngSoft.administracion.bean.ResultadoSedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;
import IngSoft.administracion.bean.TipoActividadMiniBeanData;
import IngSoft.administracion.bean.DistritoBeanData;
import IngSoft.administracion.bean.ProvinciaBeanData;
import IngSoft.administracion.bean.ResultadoActividadBeanData;
import IngSoft.administracion.bean.ResultadoActividadBeanData;
import IngSoft.administracion.bean.ActividadBeanFuncion;

public class AccionBuscarMatriculaActividad extends CoAccion{


	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo").toString());
		
		

		
		
		if(tipo==1){
			
			
			Vector<TipoActividadMiniBeanData> tipoactividades = ActividadBeanFuncion.getInstance().getTipoactividades();
			request.setAttribute("tipoactividades", tipoactividades);
			
			System.out.print("tipo =1  ----->"+ tipoactividades.size());

			this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/buscarmatricula.jsp");
			
		}
		
		if(tipo==2){
			CriterioActividadBeanData criterioActividadData =new CriterioActividadBeanFunction().crearCriterio(request,response);
			Vector<ResultadoActividadBeanData> resultados=new CriterioActividadBeanFunction().buscarPlantillaMatriculaActividadHorario(criterioActividadData);
			
			 ActividadBeanFuncion actividadFuncion= ActividadBeanFuncion.getInstance(); 
			 
			Vector<ResultadoActividadBeanData> resultados2= actividadFuncion.getNumeroInscritos();
			
			
			
			//Vector<TipoActividadMiniBeanData> tipoactividades = ActividadBeanFuncion.getInstance().getTipoactividades();	

			//request.setAttribute("tipoactividades", tipoactividades);
			
			Vector<TipoActividadMiniBeanData> tipoactividades = ActividadBeanFuncion.getInstance().getTipoactividades();
			request.setAttribute("tipoactividades", tipoactividades);
			
			request.setAttribute("resultados2", resultados2);
			request.setAttribute("resultados", resultados);
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/actividad/buscarmatricula.jsp");	
			
		}
		

		
		
	}

}
