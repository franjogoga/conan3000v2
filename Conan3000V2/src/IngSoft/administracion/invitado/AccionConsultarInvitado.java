package IngSoft.administracion.invitado;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import IngSoft.administracion.bean.InvitadoBeanData;
import IngSoft.administracion.bean.InvitadoBeanFuncion;
import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionConsultarInvitado extends CoAccion {
	
	
	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		InvitadoBeanFuncion s= InvitadoBeanFuncion.getInstans();
		//int codigo=0;
		InvitadoBeanData d= s.getInvitado(1);
		
		System.out.print(" AccionConsulta ----> " + d.getNombre());
		
		request.setAttribute("Invitado", d);
		
		this.direccionar(sc, request, response, "/IngSoft/administracion/invitados/invitadoeliminar.jsp");
		
		
		
		
	}

}
