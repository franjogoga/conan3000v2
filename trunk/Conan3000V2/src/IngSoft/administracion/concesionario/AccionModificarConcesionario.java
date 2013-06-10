package IngSoft.administracion.concesionario;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.ConcesionarioBeanFunction;
import IngSoft.administracion.bean.ConcesionarioBeanData;

public class AccionModificarConcesionario extends CoAccion {
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,HttpServletResponse response) throws CoException{
		ConcesionarioBeanFunction concesionarioFunction= ConcesionarioBeanFunction.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			ConcesionarioBeanData concesionarioData = concesionarioFunction.crearConcesionarioModificado(request, response);
			concesionarioData.setCodigo(request.getParameter("codigo"));
			concesionarioFunction.modificarConcesionario(concesionarioData);
			this.direccionar(sc, request, response,"/IngSoft/administracion/concesionario/buscarconcesionario.jsp");
		}	
		ConcesionarioBeanData concesionarioData = concesionarioFunction.consultarConcesionario(request.getParameter("codigo"));
		request.setAttribute("concesionario",concesionarioData);
		this.direccionar(sc, request, response,"/IngSoft/administracion/concesionario/modificarconcesionario.jsp");
	}
}