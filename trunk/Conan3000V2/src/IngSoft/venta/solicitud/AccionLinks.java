package IngSoft.venta.solicitud;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionLinks extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		

					String combo=request.getParameter("cmbTiposolicitud");
					
					if (combo.equals("Productos")){					
					this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/agregarsolicitudproducto.jsp");}
				   
					//if (combo.equalsIgnoreCase("Productos")){					
						//this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/agregarsolicitudproducto.jsp");}

					if (combo.equals("Socio")){					
					this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/buscarsolicitudsocio.jsp");}

					if (combo.equals("Servicio de proveedores")){					
					this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/agregarsolicitudservicio.jsp");}
			
	}	
}
