package IngSoft.administracion.sede;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.administracion.bean.SedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;


public class AccionModificarSede extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
		
			
		SedeBeanFuncion sedeFuncion= SedeBeanFuncion.getInstance();
		SedeBeanData sedeoData=sedeFuncion.crearSedeModificada(request, response);
		sedeFuncion.modificarSede(sedeoData);
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/sede/buscarsede.jsp");
		
		}
		else
		{
		SedeBeanFuncion sedeFuncion= SedeBeanFuncion.getInstance(); 
		SedeBeanData sedeData=sedeFuncion.consultarSede(request.getParameter("codigo"));	
		request.setAttribute("sede",sedeData );
		this.direccionar(sc, request, response, "/IngSoft/administracion/sede/modificarsede.jsp");
		}

	}

}
