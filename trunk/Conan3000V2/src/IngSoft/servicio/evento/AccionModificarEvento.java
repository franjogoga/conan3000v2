package IngSoft.servicio.evento;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;

public class AccionModificarEvento extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.direccionar(sc, request, response, "/IngSoft/servicio/evento/modificarevento.jsp");
	}

}
