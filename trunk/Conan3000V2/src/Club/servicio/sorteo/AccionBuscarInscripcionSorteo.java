package Club.servicio.sorteo;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.servicio.bean.CriterioInscripcionSorteoBeanData;
import IngSoft.servicio.bean.CriterioInscripcionSorteoBeanFuncion;
import IngSoft.servicio.bean.ResultadoInscripcionSorteoBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

@SessionScoped
public class AccionBuscarInscripcionSorteo extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		CriterioInscripcionSorteoBeanData  criterioInscripcionSorteoData =new CriterioInscripcionSorteoBeanFuncion().crearCriterio(request,response);
		Vector<ResultadoInscripcionSorteoBeanData> resultados=new CriterioInscripcionSorteoBeanFuncion().buscarPlantillaInscripcionSorteo(criterioInscripcionSorteoData);
		
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/Club/servicio/sorteo/buscarInscripcionSorteo.jsp");
		
	}

}
