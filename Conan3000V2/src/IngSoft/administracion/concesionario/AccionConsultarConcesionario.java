package IngSoft.administracion.concesionario;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ConcesionarioBeanData;
import IngSoft.administracion.bean.ConcesionarioBeanFunction;

public class AccionConsultarConcesionario extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response)  throws CoException{
		ConcesionarioBeanFunction concesionarioFunction = ConcesionarioBeanFunction.getInstance();
		ConcesionarioBeanData concesionarioData = concesionarioFunction.consultarConcesionario(request.getParameter("codigo"));
		request.setAttribute("concesionario",concesionarioData);
		this.direccionar(sc, request, response, "/IngSoft/administracion/concesionario/consultarconcesionario.jsp");
	}
}