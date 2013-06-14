package IngSoft.administracion.invitado;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.InvitadoBeanFunction;
import IngSoft.administracion.bean.InvitadoBeanData;
import IngSoft.administracion.bean.InvitadoBeanFunction;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionEliminarInvitado extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			
			InvitadoBeanFunction invitadoFuncion= InvitadoBeanFunction.getInstance();
			invitadoFuncion.eliminarInvitado(request.getParameter("codigo"));
			
			System.out.print(" AccionEliminarInvitado " +  request.getParameter("codigo") );
			
			this.direccionar(sc, request, response, "/IngSoft/administracion/invitado/buscarinvitado.jsp");
			
		}
		else
		{	
		InvitadoBeanFunction invitadoFuncion= InvitadoBeanFunction.getInstance(); 
		InvitadoBeanData invitadoData=invitadoFuncion.consultarInvitado(request.getParameter("codigo"));
		
      
		
		request.setAttribute("invitado",invitadoData );
		this.direccionar(sc, request, response, "/IngSoft/administracion/invitado/eliminarinvitado.jsp");
		}

	}

}
