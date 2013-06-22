package IngSoft.general.login;

import java.io.IOException;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;

@SessionScoped
public class AccionLogin extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		LoginBeanFuncion login = new LoginBeanFuncion();
		int perfil = 0;
		try {
			perfil = login.verificaUsuario(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (perfil){
		case 1: this.direccionar(sc, request, response, "/IngSoft/general/perfil1.jsp"); break;
		case 2: this.direccionar(sc, request, response, "/Club/general/index.html"); break;
		case 3: this.direccionar(sc, request, response, "/IngSoft/general/perfil3.jsp"); break;
		default: this.direccionar(sc, request, response, "/IngSoft/general/perfil4.jsp"); break;
		}

	}

}
