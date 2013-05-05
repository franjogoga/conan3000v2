package IngSoft.servicio.sorteo;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.CriterioSorteoBeanData;
import IngSoft.servicio.bean.CriterioSorteoBeanFuncion;
import IngSoft.servicio.bean.ResultadoSorteoBeanData;

public class AccionBuscarSorteo extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		CriterioSorteoBeanData criterioSorteoData =new CriterioSorteoBeanFuncion().crearCriterio(request,response);
		Vector<ResultadoSorteoBeanData> resultados=new CriterioSorteoBeanFuncion().buscarPlantillaSorteo(criterioSorteoData);

		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/servicio/evento/buscarsorteo.jsp");
		
	}

}
