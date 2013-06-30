package IngSoft.administracion.empleado;

import java.util.List;
import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.*;
import IngSoft.administracion.*;
import IngSoft.administracion.bean.EmpleadoBeanData;
import IngSoft.administracion.bean.EmpleadoBeanFuncion;
@SessionScoped
public class AccionConsultarEmpleado extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
	
		EmpleadoBeanFuncion empleadoFuncion= EmpleadoBeanFuncion.getInstance();
		EmpleadoBeanData empleadoData = empleadoFuncion.consultarEmpleado(request.getParameter("codigo"));
		request.setAttribute("empleado", empleadoData);
		this.direccionar(sc, request, response, "/IngSoft/administracion/empleados/consultarempleado.jsp");
		

	}

}



