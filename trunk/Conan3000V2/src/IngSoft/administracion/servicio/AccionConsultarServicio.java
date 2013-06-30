package IngSoft.administracion.servicio;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.SedeMiniBeanData;
import IngSoft.administracion.bean.ServicioBeanData;
import IngSoft.administracion.bean.ServicioBeanFunction;
import IngSoft.administracion.bean.AmbienteMiniBeanData;

@SessionScoped
public class AccionConsultarServicio extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response)  throws CoException{
		ServicioBeanFunction servicioFunction = ServicioBeanFunction.getInstance();
		ServicioBeanData servicioData = servicioFunction.consultarServicio(request.getParameter("codigo"));
		SedeMiniBeanData sede = servicioFunction.consultarCodigoSede(request.getParameter("codigo"));
		Vector<SedeMiniBeanData> sedes =servicioFunction.getSedes();
		Vector<AmbienteMiniBeanData> ambienteMiniData=servicioFunction.getAmbientes(sede.getCodigo());
		request.setAttribute("sedes",sedes);
		request.setAttribute("ambientes",ambienteMiniData);
		request.setAttribute("servicio",servicioData);
		this.direccionar(sc, request, response, "/IngSoft/administracion/servicio/consultarservicio.jsp");
	}
}