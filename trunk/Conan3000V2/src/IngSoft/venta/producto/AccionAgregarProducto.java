package IngSoft.venta.producto;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.ProductoBeanData;
import IngSoft.venta.bean.ProductoBeanFunction;
import IngSoft.venta.bean.ProveedorBeanData;


public class AccionAgregarProducto extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub

				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					ProductoBeanFunction productoFunction= ProductoBeanFunction.getInstance();
					ProductoBeanData productoData=productoFunction.crearProducto(request, response);
					String nombre=request.getParameter("txtProveedor");
					ProveedorBeanData proveedorData=productoFunction.BuscarProveedor(nombre);
					String codigo=proveedorData.getIdProveedor();
					productoData.setIdProveedor(codigo);
					//membresiaFunction.modificarSocio(membresiaData.getCodigoSocio());
					productoFunction.agregarProducto(productoData);
					response.setContentType("text/plain");  
				    response.setCharacterEncoding("UTF-8");
				    try {
						response.getWriter().write("/IngSoft/ventas/producto/SMVProducto?accion=Buscar&tipo=1");
					} catch (IOException e) {				
						e.printStackTrace();
					}
				}
				    if(tipo==1){
				      
					    this.direccionar(sc, request, response, "/IngSoft/ventas/producto/agregarproducto.jsp");
				    }
				
				
				
				
							
	}

}
			
