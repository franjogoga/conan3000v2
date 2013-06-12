package IngSoft.administracion.jornada;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import IngSoft.administracion.bean.CriterioJornadaBeanData;

import IngSoft.administracion.bean.CriterioJornadaBeanFuncion;

import IngSoft.administracion.bean.JornadaBeanData;
import IngSoft.administracion.bean.JornadaBeanFuncion;

import IngSoft.administracion.bean.ResultadoJornadaBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;


public class AccionMarcarJornadaEmpleado extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo").toString());
		
		
		
		System.out.print("paso 0 codigo "+ request.getParameter("txtNombreJornada") +" fecha " + request.getParameter("fFechaJornada")  +"  hora "+ request.getParameter("reloj") );  
	
		//if(Integer.valueOf(request.getParameter("tipo"))==2){
		
					JornadaBeanFuncion jornadaFuncion= JornadaBeanFuncion.getInstance();
				   
					System.out.print("paso 1 codigo "+ request.getParameter("txtNombreJornada") );   
					
					boolean actualizo =  jornadaFuncion.actualizarFlagEmpleado(request.getParameter("txtNombreJornada"));
					
					System.out.print("paso 1.1 codigo "+ request.getParameter("txtNombreJornada") + "actualizo "+ actualizo );
				if(	 actualizo )
				{   
					 System.out.print("paso 2 codigo ");
					JornadaBeanData jornaData=jornadaFuncion.crearJornada(request, response);  
					
					 System.out.print("paso 3 codigo "+ request.getParameter("txtNombreJornada") ); 
									  jornadaFuncion.agregarJornada(jornaData,  request.getParameter("txtNombreJornada")    );
				}
				
       // }
		
		
		
		CriterioJornadaBeanData criterioJornadaData =new CriterioJornadaBeanFuncion().crearCriterio(request,response);
		Vector<ResultadoJornadaBeanData> resultados=new CriterioJornadaBeanFuncion().buscarPlantillaJornada(criterioJornadaData);

		
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/administracion/jornada/marcarjornada.jsp");	
		
		
		
		
		
		
		
		
	}
}
