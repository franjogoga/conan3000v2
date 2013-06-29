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

public class AccionEliminarPerfil extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {
		if (Integer.valueOf(request.getParameter("tipo"))==2) {
			PerfilBeanFunction funcionPerfil = PerfilBeanFunction.getInstance();
			funcionPerfil.eliminarPerfil(request.getParameter("codigo"));
			funcionPerfil.eliminarPerfilxaccionxcaso(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/buscarperfil.jsp");
		}
		if (Integer.valueOf(request.getParameter("tipo"))==1) { 
			PerfilBeanFunction funcionPerfil = PerfilBeanFunction.getInstance();
			PerfilBeanData dataPerfil = funcionPerfil.consultarPerfil(request.getParameter("codigo"));
			Vector<CasosBeanData> casos = PerfilBeanFunction.getInstance().getCasos();
			Vector<CasosBeanData> casosxaccion = PerfilBeanFunction.getInstance().getCasosxaccion(dataPerfil.getCodigo());
			request.setAttribute("casos", casos);
			request.setAttribute("perfil", dataPerfil);		
			request.setAttribute("casosxaccion", casosxaccion);			
			this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/eliminarperfil.jsp");
		}		
	}
}
