package IngSoft.servicio.juridica;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.PersonaJuridicaBeanData;
import IngSoft.servicio.bean.JuridicaBeanFuncion;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.SorteoBeanData;
import IngSoft.servicio.bean.SorteoBeanFuncion;

public class AccionAgregarJuridica extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		
		if(tipo==2){
			JuridicaBeanFuncion JuridicaFuncion= JuridicaBeanFuncion.getInstance();
			PersonaJuridicaBeanData JuridicaData=JuridicaFuncion.crearJuridica(request, response);
			JuridicaFuncion.agregarJuridica(JuridicaData);
			this.direccionar(sc, request, response, "/IngSoft/servicio/juridica/juridicabuscar.jsp");
		}
		
		
		this.direccionar(sc, request, response, "/IngSoft/servicio/juridica/juridicaagregar.jsp");
	}

}
