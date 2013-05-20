package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioPerfilBeanDataFunction{

	public CriterioPerfilBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response) {
		CriterioPerfilBeanData criterio = new CriterioPerfilBeanData();
		System.out.println("entra crear criterio");
		criterio.setNombre("%"+request.getParameter("txtNombre")+"%");
		criterio.setDescripcion("%"+request.getParameter("txtDescripcion")+"%");
		return criterio;
	}
	
	public Vector<ResultadoPerfilBeanData> buscarPerfil(CriterioPerfilBeanData criterio) {
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		Vector<ResultadoPerfilBeanData> resultadosV = null;
		try {
			List<ResultadoPerfilBeanData> resultados = sesion.selectList("searchPerfil", criterio);
			resultadosV = new Vector<>(resultados);
		} finally {
			sesion.close();
		}
		return resultadosV;
	}
}
