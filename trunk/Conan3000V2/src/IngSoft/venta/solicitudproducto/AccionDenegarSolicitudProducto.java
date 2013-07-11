package IngSoft.venta.solicitudproducto;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.SolicitudProductoBeanData;
import IngSoft.venta.bean.SolicitudProductoBeanFuncion;

@SessionScoped
public class AccionDenegarSolicitudProducto extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		String codigo=request.getParameter("codigo");
		
		SolicitudProductoBeanFuncion solicitudFuncion=SolicitudProductoBeanFuncion.getInstance();
		SolicitudProductoBeanData solicitud=solicitudFuncion.consultarSolicitudProducto(codigo);
		
		if(solicitud.getEstado().equalsIgnoreCase("Nueva")){
			solicitud.setEstado("Denegada");
			solicitudFuncion.modificarSolicitud(solicitud);
		}

		this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/buscarsolicitudproducto.jsp");
		
	}

}
