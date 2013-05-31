package IngSoft.administracion.invitado;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.InvitadoBeanData;
import IngSoft.administracion.bean.InvitadoBeanFunction;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionConsultarInvitado extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		
		InvitadoBeanFunction invitadoFunction= InvitadoBeanFunction.getInstance(); 
		InvitadoBeanData invitadoData=invitadoFunction.consultarInvitado(request.getParameter("codigo"));
		request.setAttribute("invitado",invitadoData );
		this.direccionar(sc, request, response, "/IngSoft/administracion/invitado/consultarinvitado.jsp");
		

	}

}
