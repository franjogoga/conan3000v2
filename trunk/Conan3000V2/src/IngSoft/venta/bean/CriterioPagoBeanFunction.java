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


public class CriterioPagoBeanFunction {

	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioPagoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioPagoBeanData criterioPagoData= new CriterioPagoBeanData();
		
		//criterioPagoData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		criterioPagoData.setSocio(request.getParameter("txtSocio")+"%");
		criterioPagoData.setIdSocio(request.getParameter("txtCodigoSocio")+"%");
		try {		
			
			if(request.getParameter("fFechaVencimientoIni")!=null && request.getParameter("fFechaVencimientoFin")!=null){
			criterioPagoData.setFechaVencimientoIni(new Date(DF.parse(request.getParameter("fFechaVencimientoIni")).getTime()));
			criterioPagoData.setFechaVencimientoFin(new Date(DF.parse(request.getParameter("fFechaVencimientoFin")).getTime()));
			}else{
				criterioPagoData.setFechaVencimientoIni(null);
				criterioPagoData.setFechaVencimientoFin(null);
			}
			
			if(request.getParameter("fFechaEmisionIni")!=null && request.getParameter("fFechaEmisionFin")!=null){
				criterioPagoData.setFechaEmisionIni(new Date(DF.parse(request.getParameter("fFechaEmisionIni")).getTime()));
				criterioPagoData.setFechaEmisionFin(new Date(DF.parse(request.getParameter("fFechaEmisionFin")).getTime()));
				}else{
					criterioPagoData.setFechaEmisionIni(null);
					criterioPagoData.setFechaEmisionFin(null);
				}
			
			if (request.getParameter("rButton")!=null){
			String est;
			est=request.getParameter("rButton");
			criterioPagoData.setEstado(est);}
			
		
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return criterioPagoData;				
	}
	
	public Vector<ResultadoPagoBeanData> buscarPago(CriterioPagoBeanData criterioPagoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoPagoBeanData> resultadosV=null;
		try{		
		List<ResultadoPagoBeanData> resultados=sqlsesion.selectList("searchPago",criterioPagoData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
}
