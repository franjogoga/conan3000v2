package IngSoft.administracion.invitado;

import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.administracion.bean.CriterioInvitadoBeanData;
import IngSoft.administracion.bean.CriterioInvitadoBeanFunction;
import IngSoft.administracion.bean.ResultadoInvitadoBeanData;
import IngSoft.administracion.bean.InvitadoBeanFunction;

public class AccionBuscarInvitado extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub

		CriterioInvitadoBeanData criterioInvitadoData =new CriterioInvitadoBeanFunction().crearCriterio(request,response);
		Vector<ResultadoInvitadoBeanData> resultados=new CriterioInvitadoBeanFunction().buscarPlantillaInvitado(criterioInvitadoData);

		request.setAttribute("resultados", resultados);
		this.direccionar(sc, request, response, "/IngSoft/administracion/invitado/buscarinvitado.jsp");
		
	}

}
