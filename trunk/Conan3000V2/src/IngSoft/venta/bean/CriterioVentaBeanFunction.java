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

public class CriterioVentaBeanFunction {

	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioVentaBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioVentaBeanData criterioVentaData= new CriterioVentaBeanData();
		
		//criterioMembresiaData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		try{
		criterioVentaData.setIdSede(request.getParameter("cmbSede"));
		
		if(request.getParameter("fFechaIni")!=null && request.getParameter("fFechaFin")!=null){
			criterioVentaData.setFechaIni(new Date(DF.parse(request.getParameter("fFechaIni")).getTime()));
			criterioVentaData.setFechaFin(new Date(DF.parse(request.getParameter("fFechaFin")).getTime()));
			}else{
				criterioVentaData.setFechaIni(null);
				criterioVentaData.setFechaFin(null);
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return criterioVentaData;				
	}
	
	public Vector<ResultadoVentaBeanData> buscarPlantillaVenta(CriterioVentaBeanData criterioVentaData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoVentaBeanData> resultadosV=null;
		try{		
		List<ResultadoVentaBeanData> resultados=sqlsesion.selectList("searchPlantillaVenta",criterioVentaData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
	
}
