package IngSoft.administracion.perfiles;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.PerfilBeanData;
import IngSoft.administracion.bean.PerfilBeanFunction;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionConsultarPerfil extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {		
		PerfilBeanFunction funcionPerfil = PerfilBeanFunction.getInstance();
		PerfilBeanData dataPerfil = funcionPerfil.consultarPerfil(request.getParameter("codigo"));
		request.setAttribute("perfil", dataPerfil);
		this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/consultarperfil.jsp");
	}
}
