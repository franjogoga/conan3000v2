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
public class AccionModificarServicio extends CoAccion {
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		ServicioBeanFuncion ServicioFuncion= ServicioBeanFuncion.getInstanceS();
		//ProveedorBeanFuncion ProveedorFuncion=ProveedorBeanFuncion.getInstanceP();
		String codigo=request.getParameter("codigo");
				
		if(Integer.valueOf(request.getParameter("tipo"))==2){
	
			ServicioBeanData ServicioData=ServicioFuncion.crearServicio(request, response);
			ServicioData.setCodServicio(codigo);
			//PersonaData.setCodigo(codigo);
			
			ServicioFuncion.modificarServicio(ServicioData);
			//PersonaFuncion.modificarPersona(PersonaData);
			
			this.direccionar(sc, request, response, "/IngSoft/ventas/servicioproveedor/buscarservicio.jsp");
		}	
		
		ServicioBeanData ServicioData=ServicioFuncion.consultarServicio(codigo);
		ProveedorBeanData ProveedorData=ServicioFuncion.consultarProveedor(codigo);  
		
		request.setAttribute("servicio", ServicioData);
		request.setAttribute("proveedor", ProveedorData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/servicioproveedor/modificarservicio.jsp");
	}

}
