package IngSoft.servicio.juridica;

import java.util.List;
import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.*;

@SessionScoped
public class AccionConsultarJuridica extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
		HttpServletResponse response)  throws CoException{
		JuridicaBeanFuncion JuridicaFuncion= JuridicaBeanFuncion.getInstance();
		PersonaJuridicaBeanData JuridicaData= JuridicaFuncion.consultarJuridica(request.getParameter("codigo"));
		request.setAttribute("Juridica", JuridicaData);

		this.direccionar(sc, request, response, "/IngSoft/servicio/juridica/juridicaconsultar.jsp");
		

	}

}
