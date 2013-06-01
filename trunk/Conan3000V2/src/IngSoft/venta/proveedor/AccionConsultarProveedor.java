package IngSoft.venta.proveedor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.ProveedorBeanData;
import IngSoft.venta.bean.ProveedorBeanFuncion;

public class AccionConsultarProveedor extends CoAccion{
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		ProveedorBeanFuncion ProveedorFuncion= ProveedorBeanFuncion.getInstanceS();
		ProveedorBeanData ProveedorData=ProveedorFuncion.consultarProveedor(request.getParameter("codigo"));

		request.setAttribute("proveedor", ProveedorData);

		this.direccionar(sc, request, response, "/IngSoft/ventas/proveedor/consultarproveedor.jsp");
	}
	
	
	
}
