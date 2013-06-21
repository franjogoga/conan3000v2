package IngSoft.general.login;

import java.io.IOException;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;
import IngSoft.general.bean.UsuarioBeanData;

@SessionScoped
public class LoginBeanFuncion {
	
	public int verificaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(false);
		if (sesion!=null){
			sesion.invalidate();
		}
		sesion = request.getSession(true);
		String user= request.getParameter("username");
		String pass= request.getParameter("password");
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		String u = (String)sqlsesion.selectOne("getUsuarioLogin",user);
		String p = (String)sqlsesion.selectOne("getPassLogin",pass);
		if (u==null || p == null ) return -1;
		UsuarioBeanData usuario = new UsuarioBeanData();
		usuario.setNombUsuario(u); usuario.setPassword(p);
		
		String idSocio = (String)sqlsesion.selectOne("getIdSocio",usuario);
		request.getSession().setAttribute("nombre", u);
		request.getSession().setAttribute("idSocio", idSocio);
		
		if (user.equals(u) && pass.equals(p)){
			
			String perfil = (String)sqlsesion.selectOne("getPerfilUsuario",pass);
			if (perfil.equals("PER000001")) return 1; //Administrador
			if (perfil.equals("PER000002")) return 2; //Profesor
			if (perfil.equals("PER000003")) return 3; //JP
			sesion.setMaxInactiveInterval(10*60);
			sesion.setAttribute("username",user);
		}
		
		return -1; 
	}
}
