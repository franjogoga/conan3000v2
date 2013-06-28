package IngSoft.venta.ventaproducto;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.*;






public class AccionRegistrarVenta extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub

				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					VentaBeanFunction VentaFunction= VentaBeanFunction.getInstance();
					VentaBeanData VentaData=VentaFunction.crearVenta(request, response);
					VentaFunction.registrarVenta(VentaData);
					
					//response.setContentType("text/plain");  
				    //response.setCharacterEncoding("UTF-8");
				    try {
						response.getWriter().write( "/IngSoft/ventas/producto/SMVProducto?accion=Buscar&tipo=1");
					} catch (IOException e) {				
						e.printStackTrace();
					}
				}
				    if(tipo==1){
				      
					    this.direccionar(sc, request, response, "/IngSoft/ventas/ventaproducto/registrarventaproducto.jsp");
				    }
				
				
				
				
							
	}

}
	