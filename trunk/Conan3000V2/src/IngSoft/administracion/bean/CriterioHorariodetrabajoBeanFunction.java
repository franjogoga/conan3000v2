package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioHorariodetrabajoBeanFunction {
	
	
	public CriterioHorariodetrabajoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		
						
		CriterioHorariodetrabajoBeanData criterioHorariodetrabajoData= new CriterioHorariodetrabajoBeanData();
		
		criterioHorariodetrabajoData.setNombre("%"+request.getParameter("txtNombre")+"%");

		return criterioHorariodetrabajoData;				
	}
	
	public Vector<ResultadoHorariodetrabajoBeanData> buscarPlantillaHorariodetrabajo(CriterioHorariodetrabajoBeanData criterioHorariodetrabajoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoHorariodetrabajoBeanData> resultadosV=null;
		try{
			
		List<ResultadoHorariodetrabajoBeanData> resultados=sqlsesion.selectList("searchPlantillaHorariodetrabajo",criterioHorariodetrabajoData);
	
		resultadosV= new Vector<>(resultados);
		
		
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}

}
