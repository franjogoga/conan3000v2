package IngSoft.administracion.servicio;

import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ServicioBeanData;
import IngSoft.administracion.bean.ServicioBeanFunction;
import IngSoft.administracion.bean.AmbienteMiniBeanData;

public class AccionAgregarServicio extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			ServicioBeanFunction servicioFunction = ServicioBeanFunction.getInstance();
			ServicioBeanData servicioData = servicioFunction.crearServicio(request, response);
			servicioFunction.agregarServicio(servicioData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/servicio/buscarservicio.jsp");
		}
		ServicioBeanFunction servicioFunction= ServicioBeanFunction.getInstance();
		Vector<AmbienteMiniBeanData> ambienteMiniData=servicioFunction.getAmbientes();
		request.setAttribute("ambientes",ambienteMiniData);
		this.direccionar(sc, request, response, "/IngSoft/administracion/servicio/agregarservicio.jsp");
	}
}
