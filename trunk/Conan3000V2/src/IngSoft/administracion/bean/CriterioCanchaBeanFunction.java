package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioCanchaBeanFunction {
	
	public CriterioCanchaBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		CriterioCanchaBeanData criterioCanchaData= new CriterioCanchaBeanData();
		criterioCanchaData.setNombre(request.getParameter("txtNombre")==""?null:"%"+request.getParameter("txtNombre")+"%");
		criterioCanchaData.setIdTipoCancha("0".equals(request.getParameter("cmbTipoCancha"))?null:request.getParameter("cmbTipoCancha"));
		criterioCanchaData.setIdAmbiente("0".equals(request.getParameter("cmbAmbiente"))?null:request.getParameter("cmbAmbiente"));
		criterioCanchaData.setIdSede("0".equals(request.getParameter("cmbSede"))?null:request.getParameter("cmbSede"));
		return criterioCanchaData;				
	}
	public Vector<ResultadoCanchaBeanData> buscarCancha(CriterioCanchaBeanData criterioCanchaData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoCanchaBeanData> resultadosV=null;
		try{		
			List<ResultadoCanchaBeanData> resultados = sqlsesion.selectList("searchCancha",criterioCanchaData);
			resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
	}
}