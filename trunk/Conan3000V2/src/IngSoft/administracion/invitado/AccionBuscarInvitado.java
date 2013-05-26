package IngSoft.administracion.invitado;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.CriterioInvitadoBeanData;
import IngSoft.administracion.bean.CriterioInvitadoBeanFunction;
import IngSoft.administracion.bean.ResultadoInvitadoBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionBuscarInvitado extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) throws CoException {
		CriterioInvitadoBeanData criterio = new CriterioInvitadoBeanFunction().crearCriterio(request, response);
		Vector<ResultadoInvitadoBeanData> resultados = new CriterioInvitadoBeanFunction().buscarInvitado(criterio);
		request.setAttribute("resultados", resultados);
		this.direccionar(sc,request,response,"/IngSoft/administracion/invitados/buscarinvitado.jsp");

	}

}
