package IngSoft.administracion.empleado;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.*;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
@SessionScoped

public class AccionModificarEmpleado extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub

		EmpleadoBeanFuncion empleadoFuncion = EmpleadoBeanFuncion.getInstance();

		if (Integer.valueOf(request.getParameter("tipo")) == 2) {

			EmpleadoBeanData empleadoData = empleadoFuncion.crearEmpleado2(request, response);
					
			empleadoData.setCodigo(request.getParameter("codigo"));
			empleadoFuncion.modificarEmpleado(empleadoData);

			this.direccionar(sc, request, response,"/IngSoft/administracion/empleados/buscarempleado.jsp");
					
		}
		    EmpleadoBeanData empleado =empleadoFuncion.consultarEmpleado(request.getParameter("codigo"));
			request.setAttribute("empleado", empleado);

			this.direccionar(sc, request, response,"/IngSoft/administracion/empleados/modificarempleado.jsp");
					
		}

	}


