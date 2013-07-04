package IngSoft.administracion.concesionario;

import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ConcesionarioBeanFunction;
import IngSoft.administracion.bean.ConcesionarioBeanData;
import IngSoft.administracion.bean.ConcesionarioSedeBeanData;

@SessionScoped
public class AccionEliminarConcesionario extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException{
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			ConcesionarioBeanFunction concesionarioFunction= ConcesionarioBeanFunction.getInstance();
			concesionarioFunction.eliminarConcesionario(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/administracion/concesionario/buscarconcesionario.jsp");
		}
		if(Integer.valueOf(request.getParameter("tipo"))==1){
			ConcesionarioBeanFunction concesionarioFunction= ConcesionarioBeanFunction.getInstance();
			ConcesionarioBeanData concesionarioData=concesionarioFunction.consultarConcesionario(request.getParameter("codigo"));
			request.setAttribute("concesionario",concesionarioData);
			Vector<ConcesionarioSedeBeanData> concesionarioSede=concesionarioFunction.getConcesionarioSede(request.getParameter("codigo"));
			request.setAttribute("concesionarioSede",concesionarioSede);
			this.direccionar(sc, request, response, "/IngSoft/administracion/concesionario/eliminarconcesionario.jsp");
	}
	this.direccionar(sc, request, response, "/IngSoft/administracion/concesionario/buscarconcesionario.jsp");
	}
}