package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioActividadBeanFunction {
	
	
	public CriterioActividadBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioActividadBeanData criterioActividadData= new CriterioActividadBeanData();
		
		
		criterioActividadData.setTipoactividad( request.getParameter("cmbTipoactividad")==null?"0":request.getParameter("cmbDepartamento") );
		
		criterioActividadData.setNombre("%"+request.getParameter("txtNombre")+"%");
		

		criterioActividadData.setEncargado("%"+request.getParameter("txtEncargado")+"%");

		
		

		
		return criterioActividadData;				
	}
	
	public Vector<ResultadoActividadBeanData> buscarPlantillaActividad(CriterioActividadBeanData criterioActividadData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoActividadBeanData> resultadosV=null;
		try{		
		List<ResultadoActividadBeanData> resultados=sqlsesion.selectList("searchPlantillaActividad",criterioActividadData);
	
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}

}
