package IngSoft.administracion.perfiles;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.PerfilBeanData;
import IngSoft.administracion.bean.PerfilBeanFunction;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionAgregarPerfil extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {
		int tipo = Integer.parseInt(request.getParameter("tipo"));		
		if (tipo == 2) {			
			 PerfilBeanFunction funcionPerfil = PerfilBeanFunction.getInstance();
			 PerfilBeanData dataPerfil = funcionPerfil.crearPerfil(request, response);
			 funcionPerfil.agregarPerfil(dataPerfil);
			 this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/buscarperfil.jsp");
		}
		this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/agregarperfil.jsp");
	}
}
