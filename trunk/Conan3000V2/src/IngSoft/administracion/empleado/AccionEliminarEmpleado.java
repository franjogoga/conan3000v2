package IngSoft.administracion.empleado;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.EmpleadoBeanData;
import IngSoft.administracion.bean.EmpleadoBeanFuncion;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
@SessionScoped
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
