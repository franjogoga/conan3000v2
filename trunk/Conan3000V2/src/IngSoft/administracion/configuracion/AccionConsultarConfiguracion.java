package IngSoft.administracion.configuracion;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ConcesionarioBeanData;
import IngSoft.administracion.bean.ConcesionarioBeanFunction;
import IngSoft.administracion.bean.ConcesionarioSedeBeanData;

@SessionScoped
public class AccionConsultarConfiguracion extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response)  throws CoException{		
		this.direccionar(sc, request, response, "/IngSoft/administracion/configuracion/configuracion.jsp");
	}
}