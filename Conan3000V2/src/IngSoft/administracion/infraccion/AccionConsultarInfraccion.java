package IngSoft.administracion.infraccion;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.InfraccionBeanFunction;
import IngSoft.administracion.bean.InfraccionSocioBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionConsultarInfraccion extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {		
		InfraccionBeanFunction infraccionFuncion= InfraccionBeanFunction.getInstance();
		String codigo = request.getParameter("codigo");
		Vector<InfraccionSocioBeanData> resultados = InfraccionBeanFunction.getInstance().getInfraccionxsocio(codigo);
		String nombre = infraccionFuncion.getNombreSocio(codigo);
		request.setAttribute("resultados", resultados);	
		request.setAttribute("nombre", nombre);		
		this.direccionar(sc, request, response, "/IngSoft/administracion/infraccion/consultarinfraccion.jsp");	
	}
}
