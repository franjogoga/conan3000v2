package IngSoft.venta.producto;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.ProductoBeanData;
import IngSoft.venta.bean.ProductoBeanFunction;


public class AccionAgregarProducto extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub

				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					ProductoBeanFunction productoFunction= ProductoBeanFunction.getInstance();
					ProductoBeanData productoData=productoFunction.crearProducto(request, response);
					productoFunction.agregarProducto(productoData);
					this.direccionar(sc, request, response, "/IngSoft/ventas/producto/buscarproducto.jsp");
				}
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/producto/agregarproducto.jsp");
							
	}

}
