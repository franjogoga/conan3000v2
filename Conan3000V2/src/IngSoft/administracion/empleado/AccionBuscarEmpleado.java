package IngSoft.administracion.empleado;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IngSoft.administracion.bean.CriterioEmpleadoBeanData;
import IngSoft.administracion.bean.CriterioEmpleadoBeanFunction;
import IngSoft.administracion.bean.ResultadoEmpleadoBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

@SessionScoped
public class AccionBuscarEmpleado extends CoAccion{

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		
		
		//int tipo=Integer.parseInt(request.getParameter("tipo"));
		
	
			CriterioEmpleadoBeanData criterioEmpleadoData =new CriterioEmpleadoBeanFunction().crearCriterio(request,response);
			Vector<ResultadoEmpleadoBeanData> resultados=new CriterioEmpleadoBeanFunction().buscarPlantillaEmpleado(criterioEmpleadoData);
			
			request.setAttribute("resultados", resultados);
			this.direccionar(sc, request, response, "/IngSoft/administracion/empleados/buscarempleado.jsp");
			} 
		
		
	}

