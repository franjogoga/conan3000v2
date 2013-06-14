package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioInvitadoBeanFunction {
	
	public CriterioInvitadoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response) {
		CriterioInvitadoBeanData criterioInvitadoData = new CriterioInvitadoBeanData();		
		
		
		criterioInvitadoData.setNombre("%"+request.getParameter("txtNombre")+"%");

		return criterioInvitadoData;
	}
	
	public  Vector<ResultadoInvitadoBeanData> buscarPlantillaInvitado(CriterioInvitadoBeanData criterioInvitadoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoInvitadoBeanData> resultadosV=null;
		try{
			
		List<ResultadoInvitadoBeanData> resultados=sqlsesion.selectList("searchPlantillaInvitado",criterioInvitadoData);
	
		resultadosV= new Vector<>(resultados);
		
		
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	public Vector<ResultadoInvitadoBeanData> buscarInvitado(CriterioPerfilBeanData criterio) {
		SqlSession sesion = MyBatisSesion.metodo().openSession();
		Vector<ResultadoInvitadoBeanData> resultadosV = null;
		try {
			List<ResultadoInvitadoBeanData> resultados = sesion.selectList("searchPlantillaInvitado", criterio);
			resultadosV = new Vector<>(resultados);
		} finally {
			sesion.close();
		}
		return resultadosV;
	}
}
