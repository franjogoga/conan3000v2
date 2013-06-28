package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioSoBeanFunction {
	
	public CriterioSoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response) {
		CriterioSoBeanData criterioSoData = new CriterioSoBeanData();		
		
		
		criterioSoData.setNombre("%"+request.getParameter("txtNombres")+"%");

		return criterioSoData;
	}
	
	public  Vector<ResultadoSoBeanData> buscarPlantillaSo(CriterioSoBeanData criterioSoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSoBeanData> resultadosV=null;
		try{
			
		List<ResultadoSoBeanData> resultados=sqlsesion.selectList("searchPlantillaSo",criterioSoData);
	
		resultadosV= new Vector<>(resultados);
		
		
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
}
