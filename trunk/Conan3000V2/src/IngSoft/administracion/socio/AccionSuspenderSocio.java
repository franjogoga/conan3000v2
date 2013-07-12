package IngSoft.administracion.socio;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.SocioBeanFunction;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionSuspenderSocio extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {
		SocioBeanFunction funcion = SocioBeanFunction.getInstance();					
		if (Integer.valueOf(request.getParameter("tipo"))==1) {
			String codigoSocio = request.getParameter("codigo");
			request.setAttribute("codigoSocio", codigoSocio);
			this.direccionar(sc, request, response, "/IngSoft/administracion/socio/suspendersocio.jsp");
		}
		if (Integer.valueOf(request.getParameter("tipo"))==2) {
			boolean resultado = funcion.suspenderSocio(request.getParameter("codigo"), request.getParameter("txtMotivo"));			
			this.direccionar(sc, request, response, "/IngSoft/administracion/socio/accionsocio.jsp");
		}
	}

}
