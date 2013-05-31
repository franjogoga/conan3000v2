package IngSoft.administracion.socio;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.CriterioSocioBeanData;
import IngSoft.administracion.bean.CriterioSocioBeanFuncion;
import IngSoft.administracion.bean.ResultadoSocioBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionBuscarSocio extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {
		CriterioSocioBeanData criterioSocioData =new CriterioSocioBeanFuncion().crearCriterio(request, response);
		Vector<ResultadoSocioBeanData> resultados=new CriterioSocioBeanFuncion().buscarPlantillaSocio(criterioSocioData);				
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/administracion/socio/accionsocio.jsp");
	}
}
