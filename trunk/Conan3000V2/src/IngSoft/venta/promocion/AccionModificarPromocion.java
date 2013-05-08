package IngSoft.venta.promocion;

import java.util.Vector;

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

public class AccionModificarPromocion extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		PromocionBeanFuncion PromocionFuncion= PromocionBeanFuncion.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			//System.out.println(request.getParameter("txtLSede"));
			//System.out.println(request.getParameter("txtLAmbiente"));
			
			//String antSede[]=((String)request.getParameter("txtLSede")).split("/");
			//String antAmb[]=((String)request.getParameter("txtLAmbiente")).split("/");
			PromocionBeanData PromocionData=PromocionFuncion.crearPromocion(request, response);
			PromocionData.setIdPromocion(request.getParameter("codigo"));
			PromocionFuncion.modificarPromocion(eventoData, antSede, antAmb);
			this.direccionar(sc, request, response, "/IngSoft/servicio/evento/buscarevento.jsp");
		}	
		PromocionBeanData PromocionData=PromocionFuncion.consultarPromocion(request.getParameter("codigo"));

		request.setAttribute("promocion", PromocionData);
		this.direccionar(sc, request, response, "/IngSoft/venta/promociones/modificarpromocion.jsp");
	}
}
