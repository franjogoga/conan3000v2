package IngSoft.administracion.sede;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CriterioSedeBeanData;
import IngSoft.administracion.bean.CriterioSedeBeanFunction;
import IngSoft.administracion.bean.ResultadoSedeBeanData;

public class AccionBuscarSede extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		CriterioSedeBeanData criterioSedeData =new CriterioSedeBeanFunction().crearCriterio(request,response);
		Vector<ResultadoSedeBeanData> resultados=new CriterioSedeBeanFunction().buscarPlantillaSede(criterioSedeData);

		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/administracion/sede/buscarsede.jsp");
		
	}

}
