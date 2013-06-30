package IngSoft.venta.promocion;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.AmbienteMiniBeanData;
import IngSoft.servicio.bean.EventoBeanData;
import IngSoft.servicio.bean.EventoBeanFuncion;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.TipoEventoMiniBeanData;
import IngSoft.venta.bean.PromocionBeanData;
import IngSoft.venta.bean.PromocionBeanFuncion;
@SessionScoped
public class AccionModificarPromocion extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		PromocionBeanFuncion PromocionFuncion= PromocionBeanFuncion.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
	
			PromocionBeanData PromocionData=PromocionFuncion.crearPromocion(request, response);
			PromocionData.setIdPromocion(request.getParameter("codigo"));
			PromocionFuncion.modificarPromocion(PromocionData);
			this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/buscarpromocion.jsp");
		}	
		PromocionBeanData PromocionData=PromocionFuncion.consultarPromocion(request.getParameter("codigo"));

		request.setAttribute("promocion", PromocionData);
		this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/modificarpromocion.jsp");
	}
}
