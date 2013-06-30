package IngSoft.venta.promocion;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.venta.bean.PromocionBeanData;
import IngSoft.venta.bean.PromocionBeanFuncion;
@SessionScoped
public class AccionEliminarPromocion extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			PromocionBeanFuncion promocionFuncion= PromocionBeanFuncion.getInstance();
			promocionFuncion.eliminarPromocion(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/buscarpromocion.jsp");
		}
		if(Integer.valueOf(request.getParameter("tipo"))==1){
		PromocionBeanFuncion promocionFuncion= PromocionBeanFuncion.getInstance();
		PromocionBeanData promocionData=promocionFuncion.consultarPromocion(request.getParameter("codigo"));
		
		request.setAttribute("promocion", promocionData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/eliminarpromocion.jsp");
		}
		//this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/buscarpromocion.jsp");
					
				
	}

}



	

