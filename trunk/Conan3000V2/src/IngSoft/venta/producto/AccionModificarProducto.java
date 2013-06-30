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
public class AccionModificarProducto extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		ProductoBeanFunction ProductoFunction= ProductoBeanFunction.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
	
			ProductoBeanData ProductoData=ProductoFunction.crearProducto(request, response);
			ProductoData.setIdProdProveedor(request.getParameter("codigo"));
			ProductoFunction.modificarProducto(ProductoData);
			this.direccionar(sc, request, response, "/IngSoft/ventas/producto/buscarproducto.jsp");
		}	
		ProductoBeanData ProductoData=ProductoFunction.consultarProducto(request.getParameter("codigo"));

		request.setAttribute("producto", ProductoData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/producto/modificarproducto.jsp");
	}
	
}
