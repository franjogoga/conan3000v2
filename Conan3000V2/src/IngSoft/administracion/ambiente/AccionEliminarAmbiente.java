package IngSoft.administracion.ambiente;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.AmbienteBeanFunction;
import IngSoft.administracion.bean.AmbienteBeanData;

public class AccionEliminarAmbiente extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			AmbienteBeanFunction ambienteFunction= AmbienteBeanFunction.getInstance();
			ambienteFunction.eliminarAmbiente(request.getParameter("codigo"));
			this.direccionar(sc, request, response, "/IngSoft/administracion/ambiente/buscarambiente.jsp");
		}
		if(Integer.valueOf(request.getParameter("tipo"))==1){
			AmbienteBeanFunction ambienteFunction= AmbienteBeanFunction.getInstance();
			AmbienteBeanData ambienteData=ambienteFunction.consultarAmbiente(request.getParameter("codigo"));
			request.setAttribute("ambiente",ambienteData);
			this.direccionar(sc, request, response, "/IngSoft/administracion/ambiente/eliminarambiente.jsp");
		}
		this.direccionar(sc, request, response, "/IngSoft/administracion/ambiente/buscarambiente.jsp");	
	}
}