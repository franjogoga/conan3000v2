package IngSoft.administracion.horariodeactividad;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;


import IngSoft.administracion.bean.ActividadDiaSemanaBeanData;
import IngSoft.administracion.bean.ActividadDiaSemanaBeanFunction;
import IngSoft.administracion.bean.DiasBeanData;
import IngSoft.administracion.bean.HorarioDiaSemanaBeanData;
import IngSoft.administracion.bean.HorarioDiaSemanaBeanFunction;
import IngSoft.administracion.bean.HorariodeactividadBeanData;
import IngSoft.administracion.bean.HorariodeactividadBeanFuncion;
import IngSoft.administracion.bean.HorariodeactividadBeanData;
import IngSoft.administracion.bean.HorariodeactividadBeanFuncion;
import IngSoft.administracion.bean.ResultadoActividadBeanData;



public class AccionModificarHorariodeactividad extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
		
			System.out.print( "codigoActividad --> "+    request.getParameter("codigo")  +" --> ");
			System.out.print( "estado Actividad --> "+    request.getParameter("optionsRadios")  +" --> ");
			
			HorariodeactividadBeanFuncion horariodeactividadFuncion= HorariodeactividadBeanFuncion.getInstance();
			HorariodeactividadBeanData horariodeactividadData=horariodeactividadFuncion.crearHorariodeactividadModificada(request, response);
			horariodeactividadFuncion.modificarHorariodeactividad(horariodeactividadData);
			
			
			for(int i=0; i<7;i++)
			{
			
				//if( request.getParameter("checkDia"+i)!=null){
				if(    request.getParameter("estadoDia"+i).equalsIgnoreCase("Activo") ||  request.getParameter("estadoDia"+i).equalsIgnoreCase("Inactivo")   )   {
				


				ActividadDiaSemanaBeanFunction actividadDiaSemanaFunction = ActividadDiaSemanaBeanFunction.getInstance();
				ActividadDiaSemanaBeanData     horarioDiaSemanaData = actividadDiaSemanaFunction.crearHorarioDiaSemanaMoficado(  
						request.getParameter("checkDia"+i)  , 
						request.getParameter("codigo")  , 
						request.getParameter("cmbHoraInicio"+i), 
						request.getParameter("cmbHoraFin"+i) , 
						request.getParameter("estadoDia"+i)
						);
				
				System.out.print("Saliendo  del seteo ------------------------------------------");
				
				
				System.out.print(horarioDiaSemanaData.getCodigoDia()  +" --> ");
				System.out.print(horarioDiaSemanaData.getCodigoActividad() +" --> ");
				System.out.print(horarioDiaSemanaData.getHoraInicio()   +" --> ");
				System.out.print(horarioDiaSemanaData.getHoraFin()  +" --> "); 	
				System.out.print(horarioDiaSemanaData.getEstado()  +" --> "); 
				
				actividadDiaSemanaFunction.modificarActividadDiaSemanaBeanData(horarioDiaSemanaData);
				
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
			HorariodeactividadBeanData  horariodeactividad=horariodeactividadFuncion.consultarHorariodeactividad(request.getParameter("codigo"));
			
			
			Vector<ResultadoActividadBeanData>       actividades = horariodeactividadFuncion.getActividades();
			
			Vector<DiasBeanData>  diassemana=horariodeactividadFuncion.getDias();
			
			
			request.setAttribute("horariodeactividad",horariodeactividad );
			request.setAttribute("actividades",actividades );
			request.setAttribute("horasDelDia",horasDelDia );
			request.setAttribute("diassemana",diassemana );
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodeactividad/modificarhorariodeactividad.jsp");	
		
		}

	}

}
