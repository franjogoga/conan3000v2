package IngSoft.administracion.socio;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.SocioBeanFunction;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionVitalizarSocio extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {
		SocioBeanFunction funcion = SocioBeanFunction.getInstance();			
		boolean resultado = funcion.vitalizarSocio(request.getParameter("codigo"));		
		this.direccionar(sc, request, response, "/IngSoft/administracion/socio/exitosocio.jsp");
	}
}
