package IngSoft.servicio.sorteo;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.SorteoBeanData;
import IngSoft.servicio.bean.SorteoBeanFuncion;
import IngSoft.servicio.bean.SedeMiniBeanData;

public class AccionEliminarSorteo extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			SorteoBeanFuncion sorteoFuncion= SorteoBeanFuncion.getInstance();
			sorteoFuncion.eliminarSorteo(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/buscarsorteo.jsp");
		}
		if(Integer.valueOf(request.getParameter("tipo"))==1){
		SorteoBeanFuncion sorteoFuncion= SorteoBeanFuncion.getInstance();
		SorteoBeanData sorteoData=sorteoFuncion.consultarSorteo(request.getParameter("codigo"));
		Vector<SedeMiniBeanData> sedeMiniData=sorteoFuncion.getSedes();
		request.setAttribute("sedes",sedeMiniData );
		request.setAttribute("sorteo", sorteoData);
		this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/eliminarsorteo.jsp");
		}
		this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/buscarsorteo.jsp");
		
	}

}
