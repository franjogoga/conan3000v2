package IngSoft.administracion.empleado;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.EmpleadoBeanData;
import IngSoft.administracion.bean.EmpleadoBeanFuncion;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.AmbienteMiniBeanData;
import IngSoft.servicio.bean.EventoBeanData;
import IngSoft.servicio.bean.EventoBeanFuncion;
import IngSoft.servicio.bean.JuridicaBeanFuncion;
import IngSoft.servicio.bean.PersonaJuridicaBeanData;
import IngSoft.servicio.bean.SedeMiniBeanData;
import IngSoft.servicio.bean.TipoEventoMiniBeanData;

public class AccionEliminarEmpleado extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			EmpleadoBeanFuncion empleadoFuncion= EmpleadoBeanFuncion.getInstance();
			empleadoFuncion.eliminarEmpleado(request.getParameter("codigo"));
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/empleados/buscarempleado.jsp");
		}
		if(Integer.valueOf(request.getParameter("tipo"))==1){
			
		EmpleadoBeanFuncion empleadoFuncion= EmpleadoBeanFuncion.getInstance();
		EmpleadoBeanData empleadoData = empleadoFuncion.consultarEmpleado(request.getParameter("codigo"));
		request.setAttribute("empleado", empleadoData);
	
			this.direccionar(sc, request, response, "/IngSoft/administracion/empleados/eliminarempleado.jsp");
		}
		this.direccionar(sc, request, response, "/IngSoft/administracion/empleados/buscarempleado.jsp");
		
	}

}
