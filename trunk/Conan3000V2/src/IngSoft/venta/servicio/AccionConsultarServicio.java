package IngSoft.venta.servicio;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.ProveedorBeanData;
import IngSoft.venta.bean.ServicioBeanData;
import IngSoft.venta.bean.ServicioBeanFuncion;
@SessionScoped
public class AccionConsultarServicio extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		String codigo=request.getParameter("codigo");

		ServicioBeanFuncion ServicioFuncion= ServicioBeanFuncion.getInstanceS();
		ServicioBeanData ServicioData=ServicioFuncion.consultarServicio(codigo);
		ProveedorBeanData ProveedorData=ServicioFuncion.consultarProveedor(codigo);
		
		request.setAttribute("proveedor",ProveedorData);
		request.setAttribute("servicio", ServicioData);

		this.direccionar(sc, request, response, "/IngSoft/ventas/servicioproveedor/consultarservicio.jsp");
	}

}
