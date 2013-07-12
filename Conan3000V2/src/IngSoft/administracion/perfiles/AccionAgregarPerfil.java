package IngSoft.administracion.perfiles;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.CasosBeanData;
import IngSoft.administracion.bean.PerfilBeanData;
import IngSoft.administracion.bean.PerfilBeanFunction;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionAgregarPerfil extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {
		int tipo = Integer.parseInt(request.getParameter("tipo"));		
		if (tipo == 2) { //desde la ventana agregar da click al boton agregar
			
			PerfilBeanFunction funcionPerfil = PerfilBeanFunction.getInstance();
			PerfilBeanData dataPerfil = funcionPerfil.crearPerfil(request, response);
			funcionPerfil.agregarPerfil(dataPerfil);			
			funcionPerfil.agregarAccionxcasoxperfil(request, response, dataPerfil.getCodigo());						
			this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/exitoperfil.jsp");
		}
		if (tipo == 1) { //desde la ventana buscar da click al boton agregar			
			Vector<CasosBeanData> casos = PerfilBeanFunction.getInstance().getCasos();
			request.setAttribute("casos", casos);
			this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/agregarperfil.jsp");
		}
	}
}
