package IngSoft.administracion.concesionario;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ConcesionarioBeanFunction;
import IngSoft.administracion.bean.CriterioConcesionarioBeanData;
import IngSoft.administracion.bean.CriterioConcesionarioBeanFunction;
import IngSoft.administracion.bean.ResultadoConcesionarioBeanData;

public class AccionBuscarConcesionario extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		int tipo= Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			CriterioConcesionarioBeanData criterioConcesionarioData = new CriterioConcesionarioBeanFunction().crearCriterio(request,response);
			Vector<ResultadoConcesionarioBeanData> resultados = new CriterioConcesionarioBeanFunction().buscarConcesionario(criterioConcesionarioData);
			request.setAttribute("resultados", resultados);
			this.direccionar(sc, request, response, "/IngSoft/administracion/concesionario/buscarconcesionario.jsp");
		}
		if(tipo==1){
			this.direccionar(sc, request, response, "/IngSoft/administracion/concesionario/buscarconcesionario.jsp");
		}
	}
}