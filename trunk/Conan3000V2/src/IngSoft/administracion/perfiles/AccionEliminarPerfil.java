package IngSoft.administracion.perfiles;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.PerfilBeanData;
import IngSoft.administracion.bean.PerfilBeanFunction;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionEliminarPerfil extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {
		if (Integer.valueOf(request.getParameter("tipo"))==2) {
			PerfilBeanFunction funcionPerfil = PerfilBeanFunction.getInstance();
			funcionPerfil.eliminarPerfil(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/buscarperfil.jsp");
		}
		if (Integer.valueOf(request.getParameter("tipo"))==1) {
			PerfilBeanFunction funcionPerfil = PerfilBeanFunction.getInstance();
			PerfilBeanData dataPerfil = funcionPerfil.consultarPerfil(request.getParameter("codigo"));
			request.setAttribute("perfil", dataPerfil);
			this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/eliminarperfil.jsp");
		}		
	}
}
