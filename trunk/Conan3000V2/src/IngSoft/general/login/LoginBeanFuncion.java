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
		String u = (String)sqlsesion.selectOne("getUsuarioLogin",user);
		String p = (String)sqlsesion.selectOne("getPassLogin",pass);
		if (u==null || p == null ) return null;
		UsuarioBeanData usuario = new UsuarioBeanData();
		usuario.setNombUsuario(u); usuario.setPassword(p);		
		String idSocio = (String)sqlsesion.selectOne("getIdSocio",usuario);
		request.getSession().setAttribute("nombre", u);
		request.getSession().setAttribute("idSocio", idSocio);
		
		if (user.equals(u) && pass.equals(p)){
			sesion.setMaxInactiveInterval(10*60);
			sesion.setAttribute("username",user);
			String perfil = (String)sqlsesion.selectOne("getPerfilUsuario",pass);
			request.getSession().setAttribute("idPerfil", perfil);
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
