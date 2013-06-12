package Club.servicio.sorteo;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.servicio.bean.InscripcionBeanData;
import IngSoft.servicio.bean.InscripcionBeanFuncion;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.SorteoBeanData;

public class AccionInscripcionSorteo extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		InscripcionBeanFuncion sorteoFuncion= InscripcionBeanFuncion.getInstance();
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			InscripcionBeanData sorteoData=sorteoFuncion.crearInscripcion(request, response);
			if (sorteoFuncion.agregarInscripcion(sorteoData)){
				request.setAttribute("sorteo",sorteoData );
				this.direccionar(sc, request, response, "/Club/servicio/sorteo/generarInscripcion.jsp");
			}
			else{
				this.direccionar(sc, request, response, "/Club/servicio/sorteo/inscripcionRepetida.jsp");
			}
		}
		
		SorteoBeanData sorteoData=sorteoFuncion.consultarSorteo(request.getParameter("codigo"));
		Vector<SedeMiniBeanData> sedeMiniData=sorteoFuncion.getSedes();
		request.setAttribute("sedes",sedeMiniData );
		request.setAttribute("sorteo", sorteoData);
		this.direccionar(sc, request, response, "/Club/servicio/sorteo/inscripcionSorteo.jsp");
	}

}
