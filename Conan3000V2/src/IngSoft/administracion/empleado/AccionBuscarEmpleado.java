package IngSoft.administracion.empleado;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.servicio.bean.*;


public class AccionBuscarEmpleado extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		//HttpSession sesion= request.getSession(true);
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/empleado/resultados.jsp");
		}
		if(tipo==1){
		
			this.direccionar(sc, request, response, "/IngSoft/administracion/empleado/buscarempleado.jsp");
			} 
		
		
	}

}
