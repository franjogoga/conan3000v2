package IngSoft.administracion.ambiente;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.AmbienteBeanData;
import IngSoft.administracion.bean.AmbienteBeanFunction;
import IngSoft.administracion.bean.PerfilBeanData;

public class AccionModificarAmbiente extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException{
		// TODO Auto-generated method stub
		AmbienteBeanFunction ambienteFunction= AmbienteBeanFunction.getInstance();
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			AmbienteBeanData ambienteData = ambienteFunction.crearAmbiente(request, response);
			ambienteData.setCodigo(request.getParameter("codigo"));
			ambienteFunction.modificarAmbiente(ambienteData);
			this.direccionar(sc, request, response,"/IngSoft/administracion/ambiente/buscarambiente.jsp");
		}	
		AmbienteBeanData ambienteData = ambienteFunction.consultarAmbiente(request.getParameter("codigo"));
		request.setAttribute("ambiente", ambienteData);
		this.direccionar(sc, request, response,"/IngSoft/administrar/ambiente/modificarambiente.jsp");
	}
}