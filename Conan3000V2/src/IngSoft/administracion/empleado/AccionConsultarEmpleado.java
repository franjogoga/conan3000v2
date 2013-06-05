package IngSoft.administracion.empleado;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.*;
import IngSoft.administracion.*;

public class AccionConsultarEmpleado extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
	

		this.direccionar(sc, request, response, "/IngSoft/servicio/evento/consultarempleado.jsp");
		

	}

}
