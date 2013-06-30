package IngSoft.administracion.empleado;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.*;
import IngSoft.servicio.bean.*;

import IngSoft.servicio.bean.EventoBeanFuncion;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.TipoEventoMiniBeanData;
@SessionScoped
public class AccionAgregarEmpleado extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		
		if(tipo==2){
		
		//funcionando	
		EmpleadoBeanFuncion empleadoFuncion= EmpleadoBeanFuncion.getInstance();
		EmpleadoBeanData empleadoData = empleadoFuncion.crearEmpleado(request, response);
			
		empleadoFuncion.agregarEmpleado(empleadoData);
		
			this.direccionar(sc, request, response, "/IngSoft/administracion/empleados/buscarempleado.jsp");
		}
		
		if (tipo==1){
	
	    //sedes	
	    EventoBeanFuncion eventoFunction = EventoBeanFuncion.getInstance();
	    Vector<SedeMiniBeanData> sedeMiniData = eventoFunction.getSedes();
		request.setAttribute("sedes",sedeMiniData );
		
		//horarios
		EmpleadoBeanFuncion empleadoFuncion = EmpleadoBeanFuncion.getInstance();
	    Vector<HorarioEmpleados> horarioData = empleadoFuncion.getHorarios();
		request.setAttribute("horarios",horarioData );
		
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/empleados/agregarempleado.jsp");
		
		}
	}

}


