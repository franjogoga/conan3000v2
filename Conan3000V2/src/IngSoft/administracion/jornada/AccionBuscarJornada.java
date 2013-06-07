package IngSoft.administracion.jornada;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.CriterioJornadaBeanData;
import IngSoft.administracion.bean.CriterioJornadaBeanFuncion;
import IngSoft.administracion.bean.HorarioEmpleados;
import IngSoft.administracion.bean.JornadaBeanFuncion;
import IngSoft.administracion.bean.ResultadoJornadaBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionBuscarJornada extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		CriterioJornadaBeanData criterioJornadaData =new CriterioJornadaBeanFuncion().crearCriterio(request,response);
		Vector<ResultadoJornadaBeanData> resultados=new CriterioJornadaBeanFuncion().buscarPlantillaJornada(criterioJornadaData);
		
		JornadaBeanFuncion jornadaFunction= JornadaBeanFuncion.getInstance();
	    Vector<HorarioEmpleados> horarioData = jornadaFunction.getHorarios();
		request.setAttribute("horarios",horarioData );
		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/administracion/jornada/buscarjornada.jsp");
		
	}

}
