package IngSoft.venta.pago;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

import IngSoft.venta.bean.EgresoBeanData;
import IngSoft.venta.bean.EgresoBeanFunction;

public class AccionAgregarEgreso extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int tipo=Integer.parseInt(request.getParameter("tipo"));
				EgresoBeanFunction EgresoFunction= EgresoBeanFunction.getInstance();
				if(tipo==2){
					
					EgresoBeanData pagoData=EgresoFunction.crearEgreso(request, response);
					
					EgresoFunction.agregarEgreso(pagoData);
					this.direccionar(sc, request, response, "/IngSoft/ventas/pago/buscaregreso.jsp");
				}
				
				this.direccionar(sc, request, response, "/IngSoft/ventas/pago/registraregreso.jsp");
					
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

