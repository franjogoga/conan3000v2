package IngSoft.venta.promocion;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.venta.bean.PromocionBeanData;
import IngSoft.venta.bean.PromocionBeanFuncion;

public class AccionConsultarPromocion extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		PromocionBeanFuncion PromocionFuncion= PromocionBeanFuncion.getInstance();
		PromocionBeanData PromocionData=PromocionFuncion.consultarPromocion(request.getParameter("codigo"));

		request.setAttribute("promocion", PromocionData);

		this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/includes/consultarpromocion.jsp");
	}
	
}
