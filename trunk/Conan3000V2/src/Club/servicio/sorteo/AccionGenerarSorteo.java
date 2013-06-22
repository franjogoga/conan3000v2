package Club.servicio.sorteo;

import java.util.List;
import java.util.Vector;

import javax.faces.bean.SessionScoped;
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

@SessionScoped
public class AccionGenerarSorteo extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		SorteoBeanFuncion sorteoFuncion= SorteoBeanFuncion.getInstance();
		String idSocio = (String)request.getSession().getAttribute("idSocio");
		String codSorteo = request.getParameter("codigo");
		SorteoBeanData sorteoData=sorteoFuncion.consultarSorteo(codSorteo);
		int cant_ganadores = sorteoFuncion.getCantidad2(sorteoData.getIdSorteo());
		int flag=0;
		if (sorteoFuncion.haySorteo2(sorteoData.getIdSorteo())){
			Vector<String> listaGanadores=sorteoFuncion.consultaGanadores(sorteoData.getIdSorteo(),cant_ganadores);
			String nombSocio = sorteoFuncion.getNombSocio(idSocio);
			for (int i=0; i<cant_ganadores; i++)
			{
				if ((listaGanadores).get(i).equals(nombSocio)){flag=1; break;}
			}	
			
			request.setAttribute("codSorteo", codSorteo);
			request.setAttribute("flag", flag);
			request.setAttribute("lista", listaGanadores);
			this.direccionar(sc, request, response, "/Club/servicio/sorteo/generarsorteo.jsp");
			
		}
		
		Vector<String> listaGanadores=sorteoFuncion.consultaGanadores(sorteoData.getIdSorteo(),cant_ganadores);
		request.setAttribute("lista", listaGanadores);
		this.direccionar(sc, request, response, "/Club/servicio/sorteo/generarsorteoHecho.jsp");
		
	}

}
