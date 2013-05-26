package IngSoft.administracion.ambiente;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CriterioAmbienteBeanData;
import IngSoft.administracion.bean.CriterioAmbienteBeanFunction;
import IngSoft.administracion.bean.ResultadoAmbienteBeanData;

public class AccionBuscarAmbiente extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		CriterioAmbienteBeanData criterioAmbienteData =new CriterioAmbienteBeanFunction().crearCriterio(request,response);
		Vector<ResultadoAmbienteBeanData> resultados=new CriterioAmbienteBeanFunction().buscarAmbiente(criterioAmbienteData);
		
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/administracion/ambiente/buscarambiente.jsp"); 	
	}
}