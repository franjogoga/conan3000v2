package IngSoft.administracion.concesionario;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ConcesionarioBeanData;
import IngSoft.administracion.bean.ConcesionarioBeanFunction;
import IngSoft.administracion.bean.AmbienteBeanFunction;
import IngSoft.administracion.bean.ConcesionarioSedeBeanData;
import IngSoft.administracion.bean.SedeMiniBeanData;

public class AccionEliminarSede extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response)  throws CoException{
		ConcesionarioBeanFunction concesionarioFunction= ConcesionarioBeanFunction.getInstance();
		AmbienteBeanFunction ambienteFunction= AmbienteBeanFunction.getInstance();
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			concesionarioFunction.eliminarConcesionarioSede(request.getParameter("codigo"),request.getParameter("codigoSede"));
		}
		ConcesionarioBeanData concesionarioData = concesionarioFunction.consultarConcesionario(request.getParameter("codigo"));
		request.setAttribute("concesionario",concesionarioData);
		ConcesionarioSedeBeanData concesionarioSede = concesionarioFunction.consultarConcesionarioSede(request.getParameter("codigo"),request.getParameter("codigoSede"));
		request.setAttribute("concesionarioSede",concesionarioSede);
		Vector<SedeMiniBeanData> sedeMiniData=ambienteFunction.getSedes();
		request.setAttribute("sedes",sedeMiniData);
		this.direccionar(sc, request, response, "/IngSoft/administracion/concesionario/eliminarsede.jsp");
	}
}