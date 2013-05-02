package IngSoft.servicio.evento;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.servicio.bean.AmbienteMiniBeanData;
import IngSoft.servicio.bean.EventoBeanFuncion;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.TipoEventoMiniBeanData;

public class AccionAgregarEvento extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		EventoBeanFuncion eventoFunction= new EventoBeanFuncion();
		Vector<SedeMiniBeanData> sedeMiniData=eventoFunction.getSedes();
		Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFunction.getTipoEvento();
		Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFunction.getAmbientes();
		request.setAttribute("sedes",sedeMiniData );
		request.setAttribute("ambientes",AmbienteMiniData );
		request.setAttribute("tiposEvento",tipoEventoMiniData);
		this.direccionar(sc, request, response, "/IngSoft/servicio/evento/agregarevento.jsp");
	}

}
