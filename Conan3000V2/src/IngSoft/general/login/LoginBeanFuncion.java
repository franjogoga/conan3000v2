package IngSoft.general.login;

import java.io.IOException;
import java.util.Vector;

import javax.faces.bean.SessionScoped;
import javax.servlet.ServletContext;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;
import IngSoft.general.bean.PerfilBeanData;
import IngSoft.general.bean.UsuarioBeanData;

@SessionScoped
public class LoginBeanFuncion {
	
	public Vector<PerfilBeanData> verificaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		if (sesion!=null){
			sesion.invalidate();
		}
		sesion = request.getSession(true);
		String user= request.getParameter("username");
		String pass= request.getParameter("password");
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		UsuarioBeanData usuarioLogin = new UsuarioBeanData();
		usuarioLogin.setNombUsuario(user);
		usuarioLogin.setPassword(pass);
		UsuarioBeanData usuarioBD = new UsuarioBeanData();
		usuarioBD = sqlsesion.selectOne("getUsuarioBeanData", usuarioLogin);
		
		if (usuarioBD.getNombUsuario()==null || usuarioBD.getPassword() == null ) return null;
		UsuarioBeanData usuario = new UsuarioBeanData();
		usuario.setNombUsuario(usuarioBD.getNombUsuario()); usuario.setPassword(usuarioBD.getPassword());		
		String idSocio = (String)sqlsesion.selectOne("getIdSocio",usuario);
		if (idSocio==null) {idSocio=(String)sqlsesion.selectOne("getIdEmp",usuario);}
		request.getSession().setAttribute("nombre", usuarioBD.getNombUsuario());
		request.getSession().setAttribute("idSocio", idSocio);
		
		if (user.equals(usuarioBD.getNombUsuario()) && pass.equals(usuarioBD.getPassword())){
			sesion.setMaxInactiveInterval(120*60);
			sesion.setAttribute("username",user);
			String perfil = (String)sqlsesion.selectOne("getPerfilUsuario",usuarioBD);
			request.getSession().setAttribute("idPerfil", perfil);
			String nombre= (String)sqlsesion.selectOne("Data.general.login.getNombrePerfil", perfil);
			request.getSession().setAttribute("tipoUsuario", nombre);
			List <PerfilBeanData> casosDeUso = sqlsesion.selectList("Data.general.login.getCasosDeUso",perfil);
			Vector<PerfilBeanData> CU = new Vector<>();
			for (int i=0; i< casosDeUso.size() ; i++){
				CU.add(casosDeUso.get(i));
			}
			CU.trimToSize();
			sqlsesion.close();
			return CU;
			
		}
		return null;
	}
}
