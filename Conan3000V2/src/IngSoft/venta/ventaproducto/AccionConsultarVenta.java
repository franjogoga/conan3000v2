package IngSoft.venta.ventaproducto;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.*;

public class AccionConsultarVenta extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		VentaBeanFunction ventaFuncion= VentaBeanFunction.getInstance();
		VentaBeanData VentaData=ventaFuncion.consultarVenta(request.getParameter("codigo"));

		System.out.println(request.getParameter("txtVenta"));
		request.setAttribute("producto", VentaData);

		
		
		this.direccionar(sc, request, response, "/IngSoft/ventas/ventaproducto/verventaproducto.jsp");
	}
	

}
