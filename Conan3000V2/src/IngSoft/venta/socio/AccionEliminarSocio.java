package IngSoft.venta.socio;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.PromocionBeanData;
import IngSoft.venta.bean.PromocionBeanFuncion;
import IngSoft.venta.bean.SocioBeanData;
import IngSoft.venta.bean.SocioBeanFuncion;

public class AccionEliminarSocio extends CoAccion{
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			SocioBeanFuncion socioFuncion= SocioBeanFuncion.getInstanceS();
			socioFuncion.eliminarSocio(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/ventas/socio/buscarsocio.jsp");
		}
		
		if(Integer.valueOf(request.getParameter("tipo"))==1){
		SocioBeanFuncion socioFuncion= SocioBeanFuncion.getInstanceS();
		SocioBeanData socioData=socioFuncion.consultarSocio(request.getParameter("codigo"));
		
		request.setAttribute("socio", socioData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/socio/eliminarsocio.jsp");
		}
		//this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/buscarpromocion.jsp");				
	}
}
