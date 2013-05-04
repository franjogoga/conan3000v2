package IngSoft.servicio.evento;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.servicio.bean.EventoBeanData;

public class AccionConsultarEvento extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) {
		this.direccionar(sc, request, response, "/IngSoft/servicio/evento/consultarevento.jsp");
		

	}

}
