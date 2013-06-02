package IngSoft.venta.producto;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.ProductoBeanData;
import IngSoft.venta.bean.ProductoBeanFunction;

public class AccionConsultarProducto extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		ProductoBeanFunction ProductoFuncion= ProductoBeanFunction.getInstance();
		ProductoBeanData ProductoData=ProductoFuncion.consultarProducto(request.getParameter("codigo"));

		request.setAttribute("producto", ProductoData);

		this.direccionar(sc, request, response, "/IngSoft/ventas/producto/verproducto.jsp");
	}
	

}
