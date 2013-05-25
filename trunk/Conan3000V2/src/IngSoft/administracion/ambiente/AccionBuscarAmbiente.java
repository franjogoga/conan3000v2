package IngSoft.administracion.ambiente;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CriterioAmbienteBeanData;
import IngSoft.administracion.bean.CriterioAmbienteBeanFunction;
//import IngSoft.amdinistracion.bean.ResultadoAmbienteBeanData;

public class AccionBuscarAmbiente extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		//CriterioAmbienteBeanData criterioEventoData =new CriterioAmbienteBeanFunction().crearCriterio(request,response);
		//Vector<ResultadoAmbienteBeanData> resultados=new CriterioAmbienteBeanFunction().buscarA(criterioEventoData);
		
		//request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/servicio/evento/resultados.jsp");
		
	}

}
