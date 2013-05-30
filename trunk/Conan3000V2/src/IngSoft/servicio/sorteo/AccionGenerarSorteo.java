package IngSoft.servicio.sorteo;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.AmbienteMiniBeanData;
import IngSoft.servicio.bean.BungalowxSorteData;
import IngSoft.servicio.bean.SocioBeanData;
import IngSoft.servicio.bean.SocioInscritoBeanData;
import IngSoft.servicio.bean.SorteoBeanData;
import IngSoft.servicio.bean.SorteoBeanFuncion;
import IngSoft.servicio.bean.TipoEventoMiniBeanData;

public class AccionGenerarSorteo extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		SorteoBeanFuncion sorteoFuncion= SorteoBeanFuncion.getInstance();
		SorteoBeanData sorteoData=sorteoFuncion.consultarSorteo(request.getParameter("codigo"));
		int cant_ganadores = sorteoFuncion.getCantidad(sorteoData.getIdSorteo());
		if (sorteoFuncion.haySorteo(sorteoData.getIdSorteo())){
			Vector<SocioInscritoBeanData> listaInscritos=sorteoFuncion.getInscritos(sorteoData.getIdSorteo());
			
			Vector<String> listaGanadores=sorteoFuncion.getGanadores(listaInscritos,cant_ganadores,sorteoData.getIdSorteo());
			/*Vector<SocioBeanData> nombreGanadores=sorteoFuncion.getNombGanadores(listaGanadores);
			Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFuncion.getTipoEvento();
			Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFuncion.getAmbientes();*/
			
			/*request.setAttribute("ganadores", nombreGanadores);*/
			request.setAttribute("lista", listaGanadores);
			this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/generarsorteo.jsp");
			
		}
		Vector<String> listaGanadores=sorteoFuncion.consultaGanadores(sorteoData.getIdSorteo(),cant_ganadores);
		request.setAttribute("lista", listaGanadores);
		this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/generarsorteo.jsp");
		
	}

}
