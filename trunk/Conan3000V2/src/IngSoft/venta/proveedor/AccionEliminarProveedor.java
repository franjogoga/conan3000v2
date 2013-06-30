package IngSoft.venta.proveedor;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.ProveedorBeanData;
import IngSoft.venta.bean.ProveedorBeanFuncion;
@SessionScoped
public class AccionEliminarProveedor extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			ProveedorBeanFuncion proveedorFuncion= ProveedorBeanFuncion.getInstanceS();
			proveedorFuncion.eliminarProveedor(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/ventas/proveedor/buscarproveedor.jsp");
		}
		if(Integer.valueOf(request.getParameter("tipo"))==1){
		ProveedorBeanFuncion proveedorFuncion= ProveedorBeanFuncion.getInstanceS();
		ProveedorBeanData proveedorData=proveedorFuncion.consultarProveedor(request.getParameter("codigo"));
		
		request.setAttribute("proveedor", proveedorData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/proveedor/eliminarproveedor.jsp");
		}
		//this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/buscarpromocion.jsp");
			
	}
	
}
