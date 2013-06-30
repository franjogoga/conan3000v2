package IngSoft.venta.bean;

import java.util.List;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioLinSolicServBeanFuncion {
	
	public Vector<ResultadoLinSolicServBeanData> buscarPlantillaLinea(){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoLinSolicServBeanData> resultadosV=null;
		try{		
		List<ResultadoLinSolicServBeanData> resultados=sqlsesion.selectList("searchPlantillaLinea");
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}

}
