package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioInfraccionBeanFunction {
	
	public CriterioInfraccionBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response) {
		CriterioInfraccionBeanData criterioInfraccionData = new CriterioInfraccionBeanData();		
		
		
		criterioInfraccionData.setNombre("%"+request.getParameter("txtNombre")+"%");

		return criterioInfraccionData;
	}
	
	public  Vector<ResultadoInfraccionBeanData> buscarPlantillaInfraccion(CriterioInfraccionBeanData criterioInfraccionData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoInfraccionBeanData> resultadosV=null;
		try{
			
		List<ResultadoInfraccionBeanData> resultados=sqlsesion.selectList("searchPlantillaInfraccion",criterioInfraccionData);
	
		resultadosV= new Vector<>(resultados);
		
		
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
}
