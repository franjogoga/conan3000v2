package IngSoft.servicio.juridica;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.*;
@SessionScoped

public class AccionEliminarJuridica extends CoAccion {


	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			JuridicaBeanFuncion juridicaFuncion= JuridicaBeanFuncion.getInstance();
			juridicaFuncion.eliminarJuridica(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/servicio/juridica/juridicabuscar.jsp");
		}
		if(Integer.valueOf(request.getParameter("tipo"))==1){
		JuridicaBeanFuncion juridicaFuncion= JuridicaBeanFuncion.getInstance();
		PersonaJuridicaBeanData juridicaData = juridicaFuncion.consultarJuridica(request.getParameter("codigo"));
		request.setAttribute("juridica", juridicaData);
		
		this.direccionar(sc, request, response, "/IngSoft/servicio/juridica/juridicaeliminar.jsp");
		}
		this.direccionar(sc, request, response, "/IngSoft/servicio/juridica/juridicabuscar.jsp");
		
	}

}
