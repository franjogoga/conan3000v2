package IngSoft.administracion.invitado;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.InvitadoBeanFunction;
import IngSoft.administracion.bean.InvitadoBeanData;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionModificarInvitado extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response)  throws CoException{
		
		if(Integer.valueOf(request.getParameter("tipo"))==2){
			
			System.out.print( "-----> entro  modificar  -------->" );
			
		
		InvitadoBeanFunction invitadoFuncion= InvitadoBeanFunction.getInstance();
		InvitadoBeanData invitadoData=invitadoFuncion.crearInvitadoModificada(request, response);
		invitadoFuncion.modificarInvitado(invitadoData);
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/invitado/buscarinvitado.jsp");
		
			
		}
		else
		{	
		InvitadoBeanFunction invitadoFuncion= InvitadoBeanFunction.getInstance(); 
		InvitadoBeanData invitadoData=invitadoFuncion.consultarInvitado(request.getParameter("codigo"));
		
      
		
		request.setAttribute("invitado",invitadoData );
		this.direccionar(sc, request, response, "/IngSoft/administracion/invitado/modificarinvitado.jsp");
		}

	}

}
