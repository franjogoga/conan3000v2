package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioAmbienteBeanFunction {
	
	public CriterioAmbienteBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		CriterioAmbienteBeanData criterioAmbienteData= new CriterioAmbienteBeanData();
		criterioAmbienteData.setNombre(request.getParameter("txtNombre")==""?null:"%"+request.getParameter("txtNombre")+"%");
		criterioAmbienteData.setIdTipoAmbiente("0".equals(request.getParameter("cmbTipo"))?null:request.getParameter("cmbTipo"));
		criterioAmbienteData.setIdSede("0".equals(request.getParameter("cmbSede"))?null:request.getParameter("cmbSede"));
		return criterioAmbienteData;				
	}
	
	public Vector<ResultadoAmbienteBeanData> buscarAmbiente(CriterioAmbienteBeanData criterioAmbienteData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoAmbienteBeanData> resultadosV=null;
		try{		
			List<ResultadoAmbienteBeanData> resultados = sqlsesion.selectList("searchAmbiente",criterioAmbienteData);
			resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
	}
}