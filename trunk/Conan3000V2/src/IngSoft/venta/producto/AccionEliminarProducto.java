package IngSoft.venta.producto;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.MembresiaBeanData;
import IngSoft.venta.bean.MembresiaBeanFunction;
import IngSoft.venta.bean.ProductoBeanData;
import IngSoft.venta.bean.ProductoBeanFunction;
@SessionScoped
public class AccionEliminarProducto extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			ProductoBeanFunction productoFuncion= ProductoBeanFunction.getInstance();
			productoFuncion.eliminarProducto(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/ventas/producto/buscarproducto.jsp");
		}
		if(Integer.valueOf(request.getParameter("tipo"))==1){
			ProductoBeanFunction productoFuncion= ProductoBeanFunction.getInstance();
		ProductoBeanData productoData=productoFuncion.consultarProducto(request.getParameter("codigo"));
		
		request.setAttribute("producto", productoData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/producto/eliminarproducto.jsp");
		}
		//this.direccionar(sc, request, response, "/IngSoft/ventas/membresiaes/buscarmembresia.jsp");
					
				
	}
	
}
