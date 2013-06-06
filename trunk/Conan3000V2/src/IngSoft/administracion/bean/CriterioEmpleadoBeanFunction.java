package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioEmpleadoBeanFunction {
	
	
	public CriterioEmpleadoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		
						
		CriterioEmpleadoBeanData criterioEmpleadoData= new CriterioEmpleadoBeanData();
		//criterioEmpleadoData. request.getParameter("cmbTipoactividad")==null?"0":request.getParameter("cmbTipoactividad") ); aqui agrego el tipo que quiero buscar
		criterioEmpleadoData.setNombre("%"+request.getParameter("txtNombre")+"%");

		return criterioEmpleadoData;				
	}
	
	public Vector<ResultadoEmpleadoBeanData> buscarPlantillaEmpleado(CriterioEmpleadoBeanData criterioEmpleadoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoEmpleadoBeanData> resultadosV=null;
		try{
			
		List<ResultadoEmpleadoBeanData> resultados=sqlsesion.selectList("searchPlantillaEmpleado",criterioEmpleadoData);
	
		resultadosV= new Vector<>(resultados);
		
		
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}

}
