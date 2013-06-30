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

public class AccionEliminarServicio extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		ServicioBeanFuncion servicioFuncion= ServicioBeanFuncion.getInstanceS();
		String codigo=request.getParameter("codigo");	
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){

			servicioFuncion.eliminarServicio(codigo);
			
			this.direccionar(sc, request, response, "/IngSoft/ventas/servicioproveedor/buscarservicio.jsp");
		}
		
		if(Integer.valueOf(request.getParameter("tipo"))==1){
		
		ServicioBeanData servicioData=servicioFuncion.consultarServicio(codigo);
		ProveedorBeanData proveedorData=servicioFuncion.consultarProveedor(codigo);
		
		request.setAttribute("proveedor", proveedorData);
		request.setAttribute("servicio", servicioData);

		this.direccionar(sc, request, response, "/IngSoft/ventas/servicioproveedor/eliminarservicio.jsp");
		}		
	}
	
}
