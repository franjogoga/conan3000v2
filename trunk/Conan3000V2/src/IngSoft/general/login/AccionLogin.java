package IngSoft.general.login;

import java.io.IOException;
import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import IngSoft.general.CoAccion;
import IngSoft.general.CoException;
import IngSoft.general.bean.PerfilBeanData;

@SessionScoped
public class AccionLogin extends CoAccion {

	@Override
	public void ejecutar(ServletContext sc, HttpServletRequest request,
			HttpServletResponse response) throws CoException {
		// TODO Auto-generated method stub
		
		LoginBeanFuncion login = new LoginBeanFuncion();
		Vector<PerfilBeanData> perfil = new Vector<>();
		try {
			perfil = login.verificaUsuario(request, response);
			if (perfil == null) {
				this.direccionar(sc, request, response, "/IngSoft/general/perfil4.jsp");
				}
			else{
				request.setAttribute("casosDeUso", perfil);
				this.direccionar(sc, request, response, "/IngSoft/general/index.jsp");
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		

	}

}
