package IngSoft.administracion.ambiente;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.AmbienteBeanData;
import IngSoft.administracion.bean.AmbienteBeanFunction;

public class AccionConsultarAmbiente extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		AmbienteBeanFunction ambienteFunction = AmbienteBeanFunction.getInstance();
		AmbienteBeanData ambienteData = ambienteFunction.consultarAmbiente(request.getParameter("codigo"));
		request.setAttribute("ambiente",ambienteData);
		this.direccionar(sc, request, response, "/IngSoft/administracion/ambiente/consultarambiente.jsp");
	}
}
