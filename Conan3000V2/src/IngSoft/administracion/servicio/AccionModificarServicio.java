package IngSoft.administracion.servicio;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.SedeMiniBeanData;
import IngSoft.administracion.bean.ServicioBeanFunction;
import IngSoft.administracion.bean.ServicioBeanData;
import IngSoft.administracion.bean.AmbienteMiniBeanData;

public class AccionModificarServicio extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		ServicioBeanFunction servicioFunction= ServicioBeanFunction.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			ServicioBeanData servicioData = servicioFunction.crearServicioModificado(request, response);
			servicioData.setCodigo(request.getParameter("codigo"));
			servicioFunction.modificarServicio(servicioData);
			this.direccionar(sc, request, response,"/IngSoft/administracion/servicio/buscarservicio.jsp");
		}	
		ServicioBeanData servicioData = servicioFunction.consultarServicio(request.getParameter("codigo"));
		SedeMiniBeanData sede = servicioFunction.consultarCodigoSede(request.getParameter("codigo"));
		Vector<SedeMiniBeanData> sedes =servicioFunction.getSedes();
		Vector<AmbienteMiniBeanData> ambienteMiniData=servicioFunction.getAmbientes(sede.getCodigo());
		request.setAttribute("sedes",sedes);
		request.setAttribute("ambientes",ambienteMiniData);
		request.setAttribute("servicio",servicioData);
		this.direccionar(sc, request, response,"/IngSoft/administracion/servicio/modificarservicio.jsp");
	}
}