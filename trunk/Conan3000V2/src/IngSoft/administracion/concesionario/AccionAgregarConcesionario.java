package IngSoft.administracion.concesionario;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ConcesionarioBeanData;
import IngSoft.administracion.bean.ConcesionarioBeanFunction;

@SessionScoped
public class AccionAgregarConcesionario extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {
		int tipo=Integer.parseInt(request.getParameter("tipo"));
		if(tipo==2){
			ConcesionarioBeanFunction concesionarioFunction = ConcesionarioBeanFunction.getInstance();
			ConcesionarioBeanData concesionarioData = concesionarioFunction.crearConcesionario(request, response);
			concesionarioFunction.agregarConcesionario(concesionarioData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/concesionario/buscarconcesionario.jsp");
		}
		this.direccionar(sc, request, response, "/IngSoft/administracion/concesionario/agregarconcesionario.jsp");
	}
}
