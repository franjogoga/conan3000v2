package IngSoft.servicio.evento;

import java.util.HashMap;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.EventoBeanData;
import IngSoft.servicio.bean.EventoBeanFuncion;
import IngSoft.servicio.bean.SedeMiniBeanData;

public class AccionBuscarEvento extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		//HttpSession sesion= request.getSession(true);
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			EventoBeanFuncion eventoFuncion= EventoBeanFuncion.getInstance();
			HashMap<String, Object> map =eventoFuncion.crearCriterio(request,response);
		Vector<EventoBeanData> resultados1=eventoFuncion.buscarSolicitudesEventoSede(map);
		Vector<EventoBeanData> resultados2=eventoFuncion.buscarSolicitudesEventoSocio(map);
		Vector<EventoBeanData> resultados= new Vector<EventoBeanData>();
		resultados.addAll(resultados1);
		resultados.addAll(resultados2);
		resultados.trimToSize();
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/servicio/evento/resultados.jsp");
		}
		if(tipo==1){
			//sesion.removeAttribute("resultados");
			EventoBeanFuncion eventoFuncion= EventoBeanFuncion.getInstance();
			Vector<SedeMiniBeanData> sedeMiniData=eventoFuncion.getSedes();
			request.setAttribute("sedes",sedeMiniData );			
			this.direccionar(sc, request, response, "/IngSoft/servicio/evento/buscarevento.jsp");
			} 
		
		
	}

}
