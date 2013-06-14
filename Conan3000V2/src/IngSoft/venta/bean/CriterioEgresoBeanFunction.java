package IngSoft.venta.bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioEgresoBeanFunction {
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioEgresoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioEgresoBeanData criterioEgresoData= new CriterioEgresoBeanData();
		
		//criterioEgresoData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		if(request.getParameter("txtDescripcion")!=null){
			if(request.getParameter("txtDescripcion")==""){
				criterioEgresoData.setDescripcion(null);
			}else{
				criterioEgresoData.setDescripcion("%"+request.getParameter("txtDescripcion")+"%");
			}
		}else{
			criterioEgresoData.setDescripcion(null);
		}
		try {		
			
			if(request.getParameter("fFechaPagoIni")!=null)
			criterioEgresoData.setFechaPagoIni(new Date(DF.parse(request.getParameter("fFechaPagoIni")).getTime()));
			else
				criterioEgresoData.setFechaPagoIni(null);
			if(request.getParameter("fFechaPagoFin")!=null)
			criterioEgresoData.setFechaPagoFin(new Date(DF.parse(request.getParameter("fFechaPagoFin")).getTime()));
			else
				criterioEgresoData.setFechaPagoFin(null);
		
			
			
			
			
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return criterioEgresoData;				
	}
	
	public Vector<ResultadoEgresoBeanData> buscarEgreso(CriterioEgresoBeanData criterioEgresoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoEgresoBeanData> resultadosV=null;
		try{		
		List<ResultadoEgresoBeanData> resultados=sqlsesion.selectList("searchEgreso",criterioEgresoData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
}
