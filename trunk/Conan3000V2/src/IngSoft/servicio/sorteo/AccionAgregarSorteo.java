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

public class AccionAgregarSorteo extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			SorteoBeanFuncion sorteoFuncion= SorteoBeanFuncion.getInstance();
			SorteoBeanData sorteoData=sorteoFuncion.crearSorteo(request, response);
			sorteoFuncion.agregarSorteo(sorteoData);
			this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/buscarsorteo.jsp");
		}
		SorteoBeanFuncion sorteoFunction= SorteoBeanFuncion.getInstance();
		Vector<SedeMiniBeanData> sedeMiniData=sorteoFunction.getSedes();
		request.setAttribute("sedes",sedeMiniData);
		this.direccionar(sc, request, response, "/IngSoft/servicio/sorteo/agregarsorteo.jsp");
	}

}
