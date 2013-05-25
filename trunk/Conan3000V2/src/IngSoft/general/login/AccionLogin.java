package IngSoft.general.login;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

public class AccionLogin extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		HttpSession sesion= request.getSession(true);
		sesion.setMaxInactiveInterval(10*60);
		this.direccionar(sc, request, response, "/IngSoft/general/index.jsp");
		

	}

}
