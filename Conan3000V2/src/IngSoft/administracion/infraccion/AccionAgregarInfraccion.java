package IngSoft.administracion.infraccion;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.InfraccionBeanData;
import IngSoft.administracion.bean.InfraccionBeanFunction;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionAgregarInfraccion extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,	HttpServletResponse response)  throws CoException{		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			System.out.print("  --------- antes ----------- ");
			System.out.print("  txtCodigoSoc "+request.getParameter("txtCodigoSoc"));
			System.out.print(" txtMonto "+request.getParameter("txtMonto"));
			System.out.print(" txtDescripcion "+request.getParameter("txtDescripcion"));
			System.out.print("  fFecInicio "+request.getParameter("fFecInicio"));
			System.out.print("  fFecFin "+request.getParameter("fFecFin"));
			
			
			InfraccionBeanFunction infraccionFuncion= InfraccionBeanFunction.getInstance();
			InfraccionBeanData infraccionData=infraccionFuncion.crearInfraccion(request, response);
			infraccionFuncion.agregarInfraccion(infraccionData);	
			this.direccionar(sc, request, response, "/IngSoft/administracion/infraccion/buscarinfraccion.jsp");					
		}
		if (Integer.valueOf(request.getParameter("tipo"))==1){						 
			String codigoSocio = request.getParameter("codigo");
			request.setAttribute("codigoSocio", codigoSocio);
			this.direccionar(sc, request, response, "/IngSoft/administracion/infraccion/agregarinfraccion.jsp");
		}
	}
}
