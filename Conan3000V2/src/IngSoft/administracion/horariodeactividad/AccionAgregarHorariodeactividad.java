package IngSoft.administracion.horariodeactividad;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;


import IngSoft.administracion.bean.HorariodeactividadBeanFuncion;


import IngSoft.administracion.bean.DiasBeanData;
import IngSoft.administracion.bean.ActividadDiaSemanaBeanData;
import IngSoft.administracion.bean.ActividadDiaSemanaBeanFunction;
import IngSoft.administracion.bean.HorariodeactividadBeanData;
import IngSoft.administracion.bean.HorariodetrabajoBeanData;
import IngSoft.administracion.bean.HorariodetrabajoBeanFuncion;
import IngSoft.administracion.bean.ResultadoActividadBeanData;


public class AccionAgregarHorariodeactividad extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
		
	
		
			
			System.out.print(  "codActividad ---> "+request.getParameter("codActividad") );
			
		for(int i=0; i<7;i++)
		{
		if( request.getParameter("checkDia"+i)!=null){
			ActividadDiaSemanaBeanFunction actividadDiaSemanaFunction = ActividadDiaSemanaBeanFunction.getInstance();
			ActividadDiaSemanaBeanData     horarioDiaSemanaData = actividadDiaSemanaFunction.crearHorarioDiaSemana(   request.getParameter("checkDia"+i)  , request.getParameter("codActividad"), request.getParameter("cmbHoraInicio"+i), request.getParameter("cmbHoraFin"+i) );
			actividadDiaSemanaFunction.agregarHorarioDiaSemana(horarioDiaSemanaData);
		}
		
		}
		
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/horariodeactividad/buscarhorariodeactividad.jsp");
		
		}
		else
		{
			
			
			Vector<String> horasDelDia = new  Vector<String>() ;
			for(int i=8;i<23;i++){
				
				if(i<10)
				{   horasDelDia.add("0"+i+":00");
				    horasDelDia.add("0"+i+":30");
					
				}
				else{
					    horasDelDia.add( i+":00");
					    horasDelDia.add( i+":30");
				}
			}
			
			

			HorariodeactividadBeanFuncion horariodeactividadFuncion= HorariodeactividadBeanFuncion.getInstance(); 
			
			Vector<ResultadoActividadBeanData>       actividades = horariodeactividadFuncion.getActividades();
			
			Vector<DiasBeanData>  diassemana=horariodeactividadFuncion.getDias();
			
			
			request.setAttribute("actividades",actividades );
			request.setAttribute("horasDelDia",horasDelDia );
			request.setAttribute("diassemana",diassemana );
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodeactividad/agregarhorariodeactividad.jsp");	
		
		
		}

	}

}
