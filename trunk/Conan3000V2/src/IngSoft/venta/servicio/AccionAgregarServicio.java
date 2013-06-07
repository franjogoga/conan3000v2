package IngSoft.venta.servicio;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.venta.bean.ProveedorBeanData;
import IngSoft.venta.bean.ServicioBeanFuncion;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.ServicioBeanData;

public class AccionAgregarServicio extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub

				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					ServicioBeanFuncion servicioFunction= ServicioBeanFuncion.getInstanceS();
					ServicioBeanData servicioData=servicioFunction.crearServicio(request, response);
					String nombre=request.getParameter("txtNombreProv").equals("")?request.getParameter("txtNombreProv"):request.getParameter("txtNombreProv");
					ProveedorBeanData proveedorData=servicioFunction.BuscarProveedor(nombre);
					
					String codigo=proveedorData.getIdProveedor();
					servicioData.setCodProveedor(codigo);
					//servicioData.setCodProveedor(codigo);
					servicioFunction.agregarServicio(servicioData);
					this.direccionar(sc, request, response, "/IngSoft/ventas/servicioproveedor/buscarservicio.jsp");
				}
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/servicioproveedor/agregarservicio.jsp");		
	}

}
