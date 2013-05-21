package IngSoft.administracion.sede;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.administracion.bean.SedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;


public class AccionConsultarSede extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		SedeBeanFuncion sedeFuncion= SedeBeanFuncion.getInstance();
		
		 System.out.print("--- AccionConsultarSede 1 -->"+  request.getParameter("codigo") ) ;
		 
		 
		SedeBeanData sedeData=sedeFuncion.consultarSede(request.getParameter("codigo"));

		 System.out.print("--- -------- AccionConsultarSede 2-->"+  sedeData.getDepartamento() ) ;
	
		
		
		request.setAttribute("sede",sedeData );



		this.direccionar(sc, request, response, "/IngSoft/administracion/sede/consultarsede.jsp");
		

	}

}
