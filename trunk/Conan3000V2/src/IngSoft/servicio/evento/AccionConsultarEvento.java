package IngSoft.servicio.evento;

import java.util.List;
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

public class AccionConsultarEvento extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		EventoBeanFuncion eventoFuncion= EventoBeanFuncion.getInstance();
		EventoBeanData eventoData=eventoFuncion.consultarEvento(request.getParameter("codigo"));
		Vector<SedeMiniBeanData> sedeMiniData=eventoFuncion.getSedes();
		Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFuncion.getTipoEvento();
		Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFuncion.getAmbientes();
		request.setAttribute("sedes",sedeMiniData );
		request.setAttribute("ambientes",AmbienteMiniData );
		request.setAttribute("tiposEvento",tipoEventoMiniData);
		request.setAttribute("evento", eventoData);

		this.direccionar(sc, request, response, "/IngSoft/servicio/evento/consultarevento.jsp");
		

	}

}