package IngSoft.venta.ventaproducto;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.EventoBeanFuncion;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.venta.bean.*;






public class AccionRegistrarVenta extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub

				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					
					System.out.println("ante de Get Instance");
					VentaBeanFunction VentaFunction= VentaBeanFunction.getInstance();
					VentaBeanData VentaData=VentaFunction.crearVenta(request, response);
					System.out.println("despues del crearVenta");
					
					VentaFunction.registrarVenta(VentaData);
					
					//String[] valores = request.getParameterValues("txtProductos");
					
					//for (int i=0; i<valores.length; i++) {
					//	System.out.println(valores[i]);
					//}
					
					
					
					//response.setContentType("text/plain");  
				    //response.setCharacterEncoding("UTF-8");
				   // try {
					//	response.getWriter().write( "/IngSoft/ventas/producto/SMVVentaProductos?accion=Buscar&tipo=1");
				//	} catch (IOException e) {				
					//	e.printStackTrace();
				//	}
					System.out.println("despues del crearVenta");
					this.direccionar(sc, request, response, "/IngSoft/ventas/ventaproducto/buscarventaproducto.jsp");
				}
				    if(tipo==1){
				    	VentaBeanFunction VentaFunction= VentaBeanFunction.getInstance();
				    	EventoBeanFuncion eventoFunction=EventoBeanFuncion.getInstance();
				    	CriterioProductoBeanFunction productoFunction=new CriterioProductoBeanFunction();
				    	Vector<SedeMiniBeanData> sedeMiniData=eventoFunction.getSedes();
				    	Vector<VentaBeanData> productos=VentaFunction.buscarProductos();
				    	
				    	request.setAttribute("sedes", sedeMiniData);
				    	request.setAttribute("productos",productos);
				    	
				    	
					    this.direccionar(sc, request, response, "/IngSoft/ventas/ventaproducto/registrarventaproducto.jsp");
				    }
				
				}

}
	