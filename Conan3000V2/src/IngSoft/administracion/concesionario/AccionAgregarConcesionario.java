package IngSoft.administracion.concesionario;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ConcesionarioBeanData;
import IngSoft.administracion.bean.ConcesionarioBeanFunction;
import IngSoft.administracion.bean.CriterioConcesionarioBeanData;
import IngSoft.administracion.bean.CriterioConcesionarioBeanFunction;
import IngSoft.administracion.bean.ResultadoConcesionarioBeanData;

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
		if(tipo==1){
			ConcesionarioBeanFunction concesionarioFunction = ConcesionarioBeanFunction.getInstance();
			Vector<ConcesionarioBeanData> resultados = concesionarioFunction.buscarConcesionarioRUC();
			request.setAttribute("resultados", resultados);
			this.direccionar(sc, request, response, "/IngSoft/administracion/concesionario/agregarconcesionario.jsp");
		}
	}
}