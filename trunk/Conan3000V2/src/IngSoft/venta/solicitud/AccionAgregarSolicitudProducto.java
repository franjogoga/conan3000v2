package IngSoft.venta.solicitud;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.SolicitudProductoBeanData;
import IngSoft.venta.bean.SolicitudProductoBeanFuncion;


public class AccionAgregarSolicitudProducto extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					SolicitudProductoBeanFuncion solproductoFunction= SolicitudProductoBeanFuncion.getInstance();
					SolicitudProductoBeanData solproductoData=solproductoFunction.crearSolProducto(request, response);
					solproductoFunction.agregarSolicitudProducto(solproductoData);
					response.setContentType("text/plain");  
				    response.setCharacterEncoding("UTF-8");
				    try {
						response.getWriter().write( "/IngSoft/ventas/solicitud/SMVSolicitudProducto?accion=Buscar&tipo=1");
					} catch (IOException e) {				
						e.printStackTrace();
					}
				}
				    if(tipo==1){
				    	
				    	
				        this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/agregarsolicitudproducto.jsp");
				    }
							
	}

}
			
