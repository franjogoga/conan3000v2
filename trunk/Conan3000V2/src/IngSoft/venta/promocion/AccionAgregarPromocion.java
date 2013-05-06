package IngSoft.venta.promocion;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.venta.bean.PromocionBeanData;
import IngSoft.venta.bean.PromocionBeanFuncion;

public class AccionAgregarPromocion extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				if(tipo==2){
					PromocionBeanFuncion promocionFuncion= PromocionBeanFuncion.getInstance();
					PromocionBeanData promocionData=promocionFuncion.crearPromocion(request, response);
					promocionFuncion.agregarPromocion(promocionData);
					this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/buscarpromocion.jsp");
				}
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/promociones/agregarpromocion.jsp");
					
				//EventoBeanFuncion eventoFunction= EventoBeanFuncion.getInstance();
				//Vector<SedeMiniBeanData> sedeMiniData=eventoFunction.getSedes();
				//Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFunction.getTipoEvento();
				//Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFunction.getAmbientes();
				//request.setAttribute("sedes",sedeMiniData );
				//request.setAttribute("ambientes",AmbienteMiniData );
				//request.setAttribute("tiposEvento",tipoEventoMiniData);
				//this.direccionar(sc, request, response, "/IngSoft/servicio/evento/agregarevento.jsp");			
	}

}
