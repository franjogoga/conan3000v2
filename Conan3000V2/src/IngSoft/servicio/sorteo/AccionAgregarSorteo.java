package IngSoft.servicio.sorteo;

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
import IngSoft.servicio.bean.SorteoBeanFuncion;
import IngSoft.servicio.bean.TipoEventoMiniBeanData;

public class AccionAgregarSorteo extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			EventoBeanFuncion eventoFuncion= EventoBeanFuncion.getInstance();
			EventoBeanData eventoData=eventoFuncion.crearEvento(request, response);
			eventoFuncion.agregarEvento(eventoData);
			this.direccionar(sc, request, response, "/IngSoft/servicio/evento/buscarsorteo.jsp");
		}
		SorteoBeanFuncion sorteoFunction= SorteoBeanFuncion.getInstance();
		Vector<SedeMiniBeanData> sedeMiniData=sorteoFunction.getSedes();
		Vector<TipoEventoMiniBeanData> tipoEventoMiniData=sorteoFunction.getTipoEvento();
		Vector<AmbienteMiniBeanData> AmbienteMiniData=sorteoFunction.getAmbientes();
		request.setAttribute("sedes",sedeMiniData);
		request.setAttribute("ambientes",AmbienteMiniData );
		request.setAttribute("tiposEvento",tipoEventoMiniData);
		this.direccionar(sc, request, response, "/IngSoft/servicio/evento/agregarsorteo.jsp");
	}

}
