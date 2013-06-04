package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioServicioBeanFunction {
	
	public CriterioServicioBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		CriterioServicioBeanData criterioServicioData = new CriterioServicioBeanData();
		criterioServicioData.setNombre(request.getParameter("txtNombre")==""?null:"%"+request.getParameter("txtNombre")+"%");
		criterioServicioData.setIdAmbiente("0".equals(request.getParameter("cmbAmbiente"))?null:request.getParameter("cmbAmbiente"));
		return criterioServicioData;				
	}
	public Vector<ResultadoServicioBeanData> buscarServicio(CriterioServicioBeanData criterioServicioData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoServicioBeanData> resultadosV=null;
		try{		
			List<ResultadoServicioBeanData> resultados = sqlsesion.selectList("searchServicio",criterioServicioData);
			resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
	}
}