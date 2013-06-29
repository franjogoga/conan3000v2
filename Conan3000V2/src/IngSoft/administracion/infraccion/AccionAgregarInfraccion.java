package IngSoft.administracion.infraccion;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import IngSoft.administracion.bean.CriterioInfraccionBeanData;
import IngSoft.administracion.bean.CriterioInfraccionBeanFunction;
import IngSoft.administracion.bean.InfraccionBeanData;
import IngSoft.administracion.bean.InfraccionBeanFunction;
import IngSoft.administracion.bean.ResultadoInfraccionBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionAgregarInfraccion extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			System.out.print( "-----> entro  agregar registro  txtCodigoSoc  -------->"   + request.getParameter("txtCodigoSoc")    );
			
		
		InfraccionBeanFunction infraccionFuncion= InfraccionBeanFunction.getInstance();
		InfraccionBeanData infraccionData=infraccionFuncion.crearInfraccion(request, response);
		infraccionFuncion.agregarInfraccion(infraccionData);
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/infraccion/buscarinfraccion.jsp");
		
			
		}
		else
		{	

		
			
			InfraccionBeanFunction infraccionFuncion= InfraccionBeanFunction.getInstance(); 
			InfraccionBeanData infraccion=infraccionFuncion.consultarInfraccion("codigo");

			request.setAttribute("infraccion", infraccion);
			
			System.out.print("vamos agregar");
		   this.direccionar(sc, request, response, "/IngSoft/administracion/infraccion/agregarinfraccion.jsp");
		}

	}

}
