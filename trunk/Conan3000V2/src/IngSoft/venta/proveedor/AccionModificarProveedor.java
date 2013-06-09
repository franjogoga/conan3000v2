package IngSoft.venta.proveedor;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.PromocionBeanData;
import IngSoft.venta.bean.PromocionBeanFuncion;
import IngSoft.venta.bean.ProveedorBeanData;
import IngSoft.venta.bean.ProveedorBeanFuncion;

public class AccionModificarProveedor extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		
		ProveedorBeanFuncion ProveedorFuncion= ProveedorBeanFuncion.getInstanceS();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
	
			ProveedorBeanData ProveedorData=ProveedorFuncion.crearProveedor(request, response);
			ProveedorData.setIdProveedor(request.getParameter("codigo"));
			ProveedorFuncion.modificarProveedor(ProveedorData);
			this.direccionar(sc, request, response, "/IngSoft/ventas/proveedor/buscarproveedor.jsp");
		}	
		if(Integer.valueOf(request.getParameter("tipo"))==1){
		ProveedorBeanData ProveedorData=ProveedorFuncion.consultarProveedor(request.getParameter("codigo"));

		request.setAttribute("proveedor", ProveedorData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/proveedor/modificarproveedor.jsp");
		}
	}
}
