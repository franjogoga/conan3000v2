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

public class AccionModificarPerfil extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {		
		PerfilBeanFunction funcionPerfil = PerfilBeanFunction.getInstance();		
		if (Integer.valueOf(request.getParameter("tipo"))==2) {
			PerfilBeanData dataPerfil=funcionPerfil.crearPerfil(request, response);
			dataPerfil.setCodigo(request.getParameter("codigo"));			
			funcionPerfil.modificarPerfil(dataPerfil);
			funcionPerfil.eliminarPerfilxaccionxcaso(dataPerfil.getCodigo());
			funcionPerfil.agregarAccionxcasoxperfil(request, response, dataPerfil.getCodigo());
			this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/exitoperfil.jsp");
		}		
		if (Integer.valueOf(request.getParameter("tipo"))==1) {			
			PerfilBeanData dataPerfil = funcionPerfil.consultarPerfil(request.getParameter("codigo"));
			Vector<CasosBeanData> casos = PerfilBeanFunction.getInstance().getCasos();
			Vector<CasosBeanData> casosxaccion = PerfilBeanFunction.getInstance().getCasosxaccion(dataPerfil.getCodigo());
			request.setAttribute("casos", casos);
			request.setAttribute("perfil", dataPerfil);		
			request.setAttribute("casosxaccion", casosxaccion);	
			this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/modificarperfil.jsp");
		}
	}
}
