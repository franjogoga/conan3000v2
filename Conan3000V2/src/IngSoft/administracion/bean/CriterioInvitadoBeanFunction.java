package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioInvitadoBeanFunction {
	
	public CriterioInvitadoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response) {
		CriterioInvitadoBeanData criterio = new CriterioInvitadoBeanData();		
		
		
		return criterio;
	}
	
	public Vector<ResultadoInvitadoBeanData> buscarInvitado(CriterioPerfilBeanData criterio) {
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		Vector<ResultadoInvitadoBeanData> resultadosV = null;
		try {
			List<ResultadoInvitadoBeanData> resultados = sesion.selectList("searchInvitado", criterio);
			resultadosV = new Vector<>(resultados);
		} finally {
			sesion.close();
		}
		return resultadosV;
	}
}
