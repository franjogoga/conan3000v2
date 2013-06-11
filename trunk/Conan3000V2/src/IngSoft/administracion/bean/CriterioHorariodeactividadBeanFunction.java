package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioHorariodeactividadBeanFunction {
	
	
	public CriterioHorariodeactividadBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		
						
		CriterioHorariodeactividadBeanData criterioHorariodeactividadData= new CriterioHorariodeactividadBeanData();
		
		criterioHorariodeactividadData.setNombre("%"+request.getParameter("txtNombre")+"%");

		return criterioHorariodeactividadData;				
	}
	
	public Vector<ResultadoHorariodeactividadBeanData> buscarPlantillaHorariodeactividad(CriterioHorariodeactividadBeanData criterioHorariodeactividadData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoHorariodeactividadBeanData> resultadosV=null;
		try{
			
		List<ResultadoHorariodeactividadBeanData> resultados=sqlsesion.selectList("searchPlantillaHorariodeactividad",criterioHorariodeactividadData);
	
		resultadosV= new Vector<>(resultados);
		
		
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}

}
