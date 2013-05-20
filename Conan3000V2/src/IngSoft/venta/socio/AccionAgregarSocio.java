package IngSoft.venta.socio;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.SocioBeanData;
import IngSoft.venta.bean.SocioBeanFuncion;


public class AccionAgregarSocio extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					SocioBeanFuncion socioFuncion= SocioBeanFuncion.getInstance();
					SocioBeanData socioData=socioFuncion.crearSocio(request, response);
					socioFuncion.agregarSocio(socioData);
					this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/trasladomembresia.jsp");
				}
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/socio/agregarsocio.jsp");
				}
}
