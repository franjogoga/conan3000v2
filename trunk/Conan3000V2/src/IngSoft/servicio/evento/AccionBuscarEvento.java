package IngSoft.servicio.evento;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.servicio.bean.EventoBeanFuncion;

public class AccionBuscarEvento extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		new EventoBeanFuncion().getTemp();
		this.direccionar(sc, request, response, "/IngSoft/servicio/evento/buscarevento.jsp");
		
	}

}
