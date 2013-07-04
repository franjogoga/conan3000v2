package IngSoft.servicio.sorteo;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.SorteoBeanData;
import IngSoft.servicio.bean.SorteoBeanFuncion;

public class AccionModificarSorteo extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		SorteoBeanFuncion sorteoFuncion= SorteoBeanFuncion.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			//System.out.println(request.getParameter("txtLSede"));
			//System.out.println(request.getParameter("txtLAmbiente"));
			
			String antSede=((String)request.getParameter("txtLSede"));
			SorteoBeanData sorteoData=sorteoFuncion.crearSorteo(request, response);
			sorteoData.setIdSorteo(request.getParameter("codigo"));
			sorteoFuncion.modificarSorteo(sorteoData, antSede);
			this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/buscarsorteo.jsp");
		}	
		SorteoBeanData sorteoData=sorteoFuncion.consultarSorteo(request.getParameter("codigo"));
		Vector<SedeMiniBeanData> sedeMiniData=sorteoFuncion.getSedes();
		request.setAttribute("sedes",sedeMiniData );
		request.setAttribute("sorteo", sorteoData);
		this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/modificarsorteo.jsp");
	}

}
