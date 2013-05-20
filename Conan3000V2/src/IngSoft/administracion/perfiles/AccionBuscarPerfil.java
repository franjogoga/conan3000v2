package IngSoft.administracion.perfiles;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.CriterioPerfilBeanData;
import IngSoft.administracion.bean.CriterioPerfilBeanDataFunction;
import IngSoft.administracion.bean.ResultadoPerfilBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionBuscarPerfil extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {
		CriterioPerfilBeanData criterio = new CriterioPerfilBeanDataFunction().crearCriterio(request, response);
		Vector<ResultadoPerfilBeanData> resultados = new CriterioPerfilBeanDataFunction().buscarPerfil(criterio);
		request.setAttribute("resultados", resultados);
		System.out.println("hola");
		this.direccionar(sc, request, response, "/IngSoft/administracion/perfiles/buscarperfil.jsp");
	}
}
