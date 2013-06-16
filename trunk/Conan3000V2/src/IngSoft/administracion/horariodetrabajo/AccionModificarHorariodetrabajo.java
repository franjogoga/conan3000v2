package IngSoft.administracion.horariodetrabajo;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;


import IngSoft.administracion.bean.DiasBeanData;
import IngSoft.administracion.bean.HorarioDiaSemanaBeanData;
import IngSoft.administracion.bean.HorarioDiaSemanaBeanFunction;
import IngSoft.administracion.bean.HorariodetrabajoBeanData;
import IngSoft.administracion.bean.HorariodetrabajoBeanFuncion;



public class AccionModificarHorariodetrabajo extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		

		
		
		
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
		
			System.out.print(  "modificar 2 horario de trabajo" );
			System.out.print(  request.getParameter("checkDia") );
			
	
		//modificamos	a la tabla Horario
		HorariodetrabajoBeanFuncion horariodetrabajoFuncion= HorariodetrabajoBeanFuncion.getInstance();
		HorariodetrabajoBeanData horariodetrabajoData=horariodetrabajoFuncion.crearHorariodetrabajoModificada(request, response);
		horariodetrabajoFuncion.modificarHorariodetrabajo(horariodetrabajoData);
		 
		
		//modificamos a la tabla horarioxdia_semana
		
		for(int i=0; i<7;i++)
		{
		
			if( request.getParameter("checkDia"+i)!=null){
			//if(    request.getParameter("estadoDia"+i).equalsIgnoreCase("Activo") ||  request.getParameter("estadoDia"+i).equalsIgnoreCase("Inactivo")   )   {
			
			System.out.print("Antes de entrar Codigo Dia -->"+ request.getParameter("checkDia"+i) );
			System.out.print(" Codigo Horario --> "+  request.getParameter("codigo")  );
			System.out.print("Hora inicio-->"+ request.getParameter("cmbHoraInicio"+i) );
			System.out.print("Hora Fin --> "+ request.getParameter("cmbHoraFin"+i));
			System.out.print("Estado --> "+ request.getParameter("estadoDia"+i));

			HorarioDiaSemanaBeanFunction horarioDiaSemanaFunction = HorarioDiaSemanaBeanFunction.getInstance();
			
			
			
			
			HorarioDiaSemanaBeanData     horarioDiaSemanaData = horarioDiaSemanaFunction.crearHorarioDiaSemanaMoficado(  
					request.getParameter("checkDia"+i)  , 
					request.getParameter("codigo")  , 
					request.getParameter("cmbHoraInicio"+i), 
					request.getParameter("cmbHoraFin"+i) , 
					request.getParameter("estadoDia"+i)
					);
			
			System.out.print("Saliendo  del seteo ------------------------------------------");
			
			
			System.out.print(horarioDiaSemanaData.getCodigoDia()  +" --> ");
			System.out.print(horarioDiaSemanaData.getCodigoHorario() +" --> ");
			System.out.print(horarioDiaSemanaData.getHoraInicio()   +" --> ");
			System.out.print(horarioDiaSemanaData.getHoraFin()  +" --> "); 	
			System.out.print(horarioDiaSemanaData.getEstado()  +" --> "); 
			
			horarioDiaSemanaFunction.modificarHorarioDiaSemanaBeanData(horarioDiaSemanaData);
			
		    }
		
		}
		
			
		this.direccionar(sc, request, response, "/IngSoft/administracion/horariodetrabajo/buscarhorariodetrabajo.jsp");
		
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
			
			
			HorariodetrabajoBeanFuncion horariodetrabajoFuncion= HorariodetrabajoBeanFuncion.getInstance(); 
			HorariodetrabajoBeanData  horariodetrabajo=horariodetrabajoFuncion.consultarHorariodetrabajo(request.getParameter("codigo"));
			
			Vector<DiasBeanData>  diassemana=horariodetrabajoFuncion.getDias();
			
			
			
			request.setAttribute("horasDelDia",horasDelDia );
			request.setAttribute("diassemana",diassemana );
			request.setAttribute("horariodetrabajo",horariodetrabajo );
			this.direccionar(sc, request, response, "/IngSoft/administracion/horariodetrabajo/modificarhorariodetrabajo.jsp");	
		
		}

	}

}
