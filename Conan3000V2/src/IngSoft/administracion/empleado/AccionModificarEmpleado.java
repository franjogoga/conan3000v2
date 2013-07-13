package IngSoft.administracion.empleado;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.*;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.EventoBeanFuncion;
import IngSoft.servicio.bean.SedeMiniBeanData;
@SessionScoped

public class AccionModificarEmpleado extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException { 
		EmpleadoBeanFuncion empleadoFuncion = EmpleadoBeanFuncion.getInstance();
		if (Integer.valueOf(request.getParameter("tipo")) == 2) {
			EmpleadoBeanData empleadoData = empleadoFuncion.crearEmpleado2(request, response);					
			empleadoData.setCodigo(request.getParameter("codigo"));
			empleadoFuncion.modificarEmpleado(empleadoData);
			this.direccionar(sc, request, response,"/IngSoft/administracion/empleados/buscarempleado.jsp");					
		}
	    EmpleadoBeanData empleado =empleadoFuncion.consultarEmpleado(request.getParameter("codigo"));	
	    EventoBeanFuncion eventoFunction = EventoBeanFuncion.getInstance();
	    Vector<HorarioEmpleados> horarios = empleadoFuncion.getHorarios();
	    Vector<SedeMiniBeanData> sedes = eventoFunction.getSedes();
		request.setAttribute("sedes",sedes);
	    request.setAttribute("empleado", empleado);	
		request.setAttribute("horarios",horarios );
		this.direccionar(sc, request, response,"/IngSoft/administracion/empleados/modificarempleado.jsp");					
	}
}
