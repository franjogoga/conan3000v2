package IngSoft.servicio.juridica;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.*;


public class AccionModificarJuridica extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		
		JuridicaBeanFuncion juridicaFuncion= JuridicaBeanFuncion.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
		
			
			//String RazonSocial=(request.getParameter("txtRazonSocial"));
			PersonaJuridicaBeanData juridicaData=juridicaFuncion.crearJuridica(request, response);
			juridicaData.setCodigo(request.getParameter("codigo"));
		    juridicaFuncion.modificarJuridica(juridicaData);
			this.direccionar(sc, request, response, "/IngSoft/servicio/juridica/juridicabuscar.jsp");
		}	
	    PersonaJuridicaBeanData JuridicaData = juridicaFuncion.consultarJuridica(request.getParameter("codigo"));
		request.setAttribute("juridica", JuridicaData);
		this.direccionar(sc, request, response, "/IngSoft/servicio/juridica/juridicamodificar.jsp");
	}
}
