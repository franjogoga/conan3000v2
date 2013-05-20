package IngSoft.administracion.sede;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.SedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;


public class AccionEliminarSede extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			SedeBeanFuncion sedeFuncion= SedeBeanFuncion.getInstance();
			
			System.out.print("AccionEliminarSede -->  " + request.getParameter("codigo") );
			sedeFuncion.eliminarSede(request.getParameter("codigo"));
			
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/sede/buscarsede.jsp");
		}
		else
		{
		
		
		SedeBeanFuncion sedeFuncion= SedeBeanFuncion.getInstance(); 
		SedeBeanData sedeData=sedeFuncion.consultarEvento(request.getParameter("codigo"));	
		request.setAttribute("sede",sedeData );
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/sede/eliminarsede.jsp");
		}

	}

}
