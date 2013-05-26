package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioSedeBeanFunction {
	
	
	
	
	public CriterioSedeBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioSedeBeanData criterioSedeData= new CriterioSedeBeanData();
		
		criterioSedeData.setNombre(request.getParameter("txtNombre")+"%");
		criterioSedeData.setDepartamento( request.getParameter("cmbDepartamento")==null?"0":request.getParameter("cmbDepartamento") );

		criterioSedeData.setProvincia( request.getParameter("cmbProvincia")==null?"0":request.getParameter("cmbProvincia") );

		criterioSedeData.setDistrito( request.getParameter("cmbDistrito")==null?"0":request.getParameter("cmbDistrito") );
		
		
		
		return criterioSedeData;				
	}
	
	public  Vector<ResultadoSedeBeanData> buscarPlantillaSede(CriterioSedeBeanData criterioSedeData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSedeBeanData> resultadosV=null;
		try{		
		List<ResultadoSedeBeanData> resultados=sqlsesion.selectList("searchPlantillaSede",criterioSedeData);
	
		
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}

}
