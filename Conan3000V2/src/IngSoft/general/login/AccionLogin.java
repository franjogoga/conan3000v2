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
		
		LoginBeanFuncion login = new LoginBeanFuncion();
		int perfil = login.verificaUsuario(request, response);
		switch (perfil){
		case 1: this.direccionar(sc, request, response, "/IngSoft/general/leftmenu.jsp");
		case 2: this.direccionar(sc, request, response, "/IngSoft/general/perfil2.jsp");
		case 3: this.direccionar(sc, request, response, "/IngSoft/general/404.jsp");
		}

	}

}
