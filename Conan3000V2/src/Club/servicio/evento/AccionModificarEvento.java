package Club.servicio.evento;

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

public class AccionModificarEvento extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		EventoBeanFuncion eventoFuncion= EventoBeanFuncion.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			//System.out.println(request.getParameter("txtLSede"));
			//System.out.println(request.getParameter("txtLAmbiente"));
			
			String antSede[]=((String)request.getParameter("txtLSede")).split("/");
			String antAmb[]=((String)request.getParameter("txtLAmbiente")).split("/");
			EventoBeanData eventoData=eventoFuncion.crearEvento(request, response);
			eventoData.setCodigo(request.getParameter("codigo"));
			//eventoFuncion.modificarEvento(eventoData, antSede, antAmb);
			this.direccionar(sc, request, response, "/Club/servicio/evento/buscarevento.jsp");
		}	
		//EventoBeanData eventoData=eventoFuncion.consultarEvento(request.getParameter("codigo"));
		Vector<SedeMiniBeanData> sedeMiniData=eventoFuncion.getSedes();
		Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFuncion.getTipoEvento();
		Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFuncion.getAmbientes();
		request.setAttribute("sedes",sedeMiniData );
		request.setAttribute("ambientes",AmbienteMiniData );
		request.setAttribute("tiposEvento",tipoEventoMiniData);
		//request.setAttribute("evento", eventoData);
		this.direccionar(sc, request, response, "/Club/servicio/evento/modificarevento.jsp");
	}

}
