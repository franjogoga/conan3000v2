package IngSoft.venta.traslado;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.TrasladoBeanData;
import IngSoft.venta.bean.TrasladoBeanFuncion;

public class AccionAgregarTraslado extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					
					TrasladoBeanFuncion trasladoFuncion= TrasladoBeanFuncion.getInstance();
					TrasladoBeanData trasladoData=trasladoFuncion.crearTraslado(request, response);

					trasladoFuncion.agregarTraslado(trasladoData);

					//aca agregar el codigo para que se pase el codigo que se ha generado
					
					this.direccionar(sc, request, response, "/IngSoft/ventas/membresia/buscarmembresia.jsp");
				
				}
				//TrasladoBeanFuncion trasladoFunction= TrasladoBeanFuncion.getInstance();
							
										
				this.direccionar(sc, request, response, "/IngSoft/ventas/membresia/trasladomembresia.jsp");
				}
}

	

