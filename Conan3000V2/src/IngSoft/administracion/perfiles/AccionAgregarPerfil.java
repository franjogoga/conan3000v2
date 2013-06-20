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
		if (tipo == 2) { //desde el agregar da click a agregar
			 PerfilBeanFunction funcionPerfil = PerfilBeanFunction.getInstance();
			 PerfilBeanData dataPerfil = funcionPerfil.crearPerfil(request, response);
			 funcionPerfil.agregarPerfil(dataPerfil);
			 this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/buscarperfil.jsp");
		}
		if (tipo == 1) { //desde la ventana buscar da click a agregar
			this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/agregarperfil.jsp");
		}
	}
}
