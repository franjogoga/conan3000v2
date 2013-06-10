package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioConcesionarioBeanFunction {
	
	public CriterioConcesionarioBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		CriterioConcesionarioBeanData criterioConcesionarioData= new CriterioConcesionarioBeanData();
		criterioConcesionarioData.setRazonSocial(request.getParameter("txtRazonSocial")==""?null:"%"+request.getParameter("txtRazonSocial")+"%");
		criterioConcesionarioData.setRuc(request.getParameter("txtRuc")==""?0:Long.parseLong(request.getParameter("txtRuc")));
		return criterioConcesionarioData;
	}
	
	public Vector<ResultadoConcesionarioBeanData> buscarConcesionario(CriterioConcesionarioBeanData criterioConcesionarioData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoConcesionarioBeanData> resultadosV=null;
		try{		
			List<ResultadoConcesionarioBeanData> resultados = sqlsesion.selectList("searchConcesionario",criterioConcesionarioData);
			resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
	}
}