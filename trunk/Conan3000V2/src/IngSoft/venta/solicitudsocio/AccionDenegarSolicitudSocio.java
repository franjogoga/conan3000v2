package IngSoft.venta.solicitudsocio;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.SolicitudSocioBeanFuncion;
import IngSoft.venta.bean.SolicitudsocioBeanData;

public class AccionDenegarSolicitudSocio extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		String codigo=request.getParameter("codigo");
		
		SolicitudSocioBeanFuncion solicitudFuncion=SolicitudSocioBeanFuncion.getInstanceS();
		SolicitudsocioBeanData solicitud=solicitudFuncion.consultarSolicitud(codigo);
		
		if(solicitud.getEstado().equalsIgnoreCase("Nueva")){
			solicitud.setEstado("Denegada");
			solicitudFuncion.modificarSolicitud(solicitud);
		}

		this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/buscarsolicitudsocio.jsp");
		
	}

}
