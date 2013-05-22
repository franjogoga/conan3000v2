package IngSoft.administracion.perfiles;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.PerfilBeanData;
import IngSoft.administracion.bean.PerfilBeanFunction;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionModificarPerfil extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {		
		PerfilBeanFunction funcionPerfil = PerfilBeanFunction.getInstance();
		if (Integer.valueOf(request.getParameter("tipo"))==2) {
			PerfilBeanData dataPerfil=funcionPerfil.crearPerfil(request, response);
			dataPerfil.setCodigo(request.getParameter("codigo"));
			funcionPerfil.modificarPerfil(dataPerfil);
			this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/buscarperfil.jsp");
		}
		PerfilBeanData dataPerfil=funcionPerfil.consultarPerfil(request.getParameter("codigo"));
		request.setAttribute("perfil", dataPerfil);
		this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/modificarperfil.jsp");
	}
}
