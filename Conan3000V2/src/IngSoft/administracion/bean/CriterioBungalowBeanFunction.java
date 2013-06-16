package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioBungalowBeanFunction {
	
	public CriterioBungalowBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		CriterioBungalowBeanData criterioBungalowData= new CriterioBungalowBeanData();
		criterioBungalowData.setNumero(request.getParameter("txtNumero")==""?0:Integer.parseInt(request.getParameter("txtNumero")));
		criterioBungalowData.setNumeroDivisiones(request.getParameter("txtNumeroDivisiones")==""?0:Integer.parseInt(request.getParameter("txtNumeroDivisiones")));
		criterioBungalowData.setAreaBungalow(request.getParameter("txtAreaBungalow")==""?0:Double.parseDouble(request.getParameter("txtAreaBungalow")));
		criterioBungalowData.setIdAmbiente("0".equals(request.getParameter("cmbAmbiente"))?null:request.getParameter("cmbAmbiente"));
		criterioBungalowData.setIdSede("0".equals(request.getParameter("cmbSede"))?null:request.getParameter("cmbSede"));
		return criterioBungalowData;				
	}
	public Vector<ResultadoBungalowBeanData> buscarBungalow(CriterioBungalowBeanData criterioBungalowData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoBungalowBeanData> resultadosV=null;
		try{		
			List<ResultadoBungalowBeanData> resultados = sqlsesion.selectList("searchBungalow",criterioBungalowData);
			resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
	}
}