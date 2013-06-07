package IngSoft.administracion.jornada;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.EmpleadoBeanFuncion;
import IngSoft.administracion.bean.HorarioEmpleados;
import IngSoft.administracion.bean.JornadaBeanData;
import IngSoft.administracion.bean.JornadaBeanFuncion;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.SorteoBeanData;
import IngSoft.servicio.bean.SorteoBeanFuncion;

public class AccionAgregarJornada extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			JornadaBeanFuncion jornadaFuncion= JornadaBeanFuncion.getInstance();
			JornadaBeanData jornadaData=jornadaFuncion.crearJornada(request, response);
			jornadaFuncion.agregarJornada(jornadaData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/jornada/buscarjornada.jsp");
		}
		JornadaBeanFuncion jornadaFunction= JornadaBeanFuncion.getInstance();
	    Vector<HorarioEmpleados> horarioData = jornadaFunction.getHorarios();
		request.setAttribute("horarios",horarioData );
		this.direccionar(sc, request, response, "/IngSoft/administracion/jornada/agregarjornada.jsp");
	}

}
