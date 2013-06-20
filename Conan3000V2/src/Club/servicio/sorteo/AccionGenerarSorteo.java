package Club.servicio.sorteo;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String nombre = (String)request.getSession().getAttribute("nombre");
		String idSocio = (String)request.getSession().getAttribute("idSocio");
		SorteoBeanData sorteoData=sorteoFuncion.consultarSorteo(request.getParameter("codigo"));
		int cant_ganadores = sorteoFuncion.getCantidad(sorteoData.getIdSorteo());
		int flag=0;
		if (sorteoFuncion.haySorteo(sorteoData.getIdSorteo())){
			Vector<SocioInscritoBeanData> listaInscritos=sorteoFuncion.getInscritos(sorteoData.getIdSorteo());
			
			for (int i=0; i<listaInscritos.size(); i++)
			{
				if ((listaInscritos).get(i).getIdSocio().equals(idSocio)){flag=1; break;}
			}	
			
			Vector<String> listaGanadores=sorteoFuncion.getGanadores(listaInscritos,cant_ganadores,sorteoData.getIdSorteo());
			/*Vector<SocioBeanData> nombreGanadores=sorteoFuncion.getNombGanadores(listaGanadores);
			Vector<TipoEventoMiniBeanData> tipoEventoMiniData=eventoFuncion.getTipoEvento();
			Vector<AmbienteMiniBeanData> AmbienteMiniData=eventoFuncion.getAmbientes();*/
			
			request.setAttribute("flag", flag);
			request.setAttribute("lista", listaGanadores);
			this.direccionar(sc, request, response, "/Club/servicio/sorteo/generarsorteo.jsp");
			
		}
		
		Vector<String> listaGanadores=sorteoFuncion.consultaGanadores(sorteoData.getIdSorteo(),cant_ganadores);
		request.setAttribute("lista", listaGanadores);
		this.direccionar(sc, request, response, "/Club/servicio/sorteo/generarsorteo.jsp");
		
	}

}
