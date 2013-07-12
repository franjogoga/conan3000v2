package IngSoft.venta.solicitudproducto;


import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.EventoBeanFuncion;
import IngSoft.venta.bean.SolicitudProductoBeanData;
import IngSoft.venta.bean.SolicitudProductoBeanFuncion;


public class AccionAgregarSolicitudProducto extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				EventoBeanFuncion eventoFunction= EventoBeanFuncion.getInstance();
				if(tipo==2){
					SolicitudProductoBeanFuncion solproductoFunction= SolicitudProductoBeanFuncion.getInstance();
					SolicitudProductoBeanData solproductoData=solproductoFunction.crearSolProducto(request, response);
					solproductoFunction.agregarSolicitudProducto(solproductoData);
					request.setAttribute("solicitudProducto", solproductoData);
					
					  this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/buscarsolicitudproducto.jsp");  }
				    if(tipo==1){
				    	Vector<SedeMiniBeanData> sedeMiniData=eventoFunction.getSedes();
						request.setAttribute("sedes",sedeMiniData );
				        this.direccionar(sc, request, response, "/IngSoft/ventas/solicitud/agregarsolicitudproducto.jsp");
				    }
			  }
}

							
	


			
