package IngSoft.administracion.sede;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.general.CoAccion;
import IngSoft.general.CoException;


import IngSoft.administracion.bean.SedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;

public class AccionAgregarSede extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		
		if(tipo==2){
			
		SedeBeanFuncion sedeFuncion= SedeBeanFuncion.getInstance();
		SedeBeanData sedeoData=sedeFuncion.crearSede(request, response);
		
		sedeFuncion.agregarSede(sedeoData);
		
		
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/sedes/buscarsede.jsp");
		}

		
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/sedes/agregarsede.jsp");
	}

}
