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
		criterioPagoData.setSocio("%"+request.getParameter("txtSocio")+"%");
		
		try {
			if(request.getParameter("txtCodigoSocio")!=null)
				if(request.getParameter("txtCodigoSocio")=="")
					criterioPagoData.setIdSocio(null);
				else
				criterioPagoData.setIdSocio(request.getParameter("txtCodigoSocio"));
			else
				criterioPagoData.setIdSocio(null);
			
			if(request.getParameter("fFechaVencimientoIni")!=null && request.getParameter("fFechaVencimientoFin")!=null){
			criterioPagoData.setFechaVencimientoIni(new Date(DF.parse(request.getParameter("fFechaVencimientoIni")).getTime()));
			criterioPagoData.setFechaVencimientoFin(new Date(DF.parse(request.getParameter("fFechaVencimientoFin")).getTime()));
			}else{
				criterioPagoData.setFechaVencimientoIni(null);
				criterioPagoData.setFechaVencimientoFin(null);
			}
			
			if(request.getParameter("fFechaPagoIni")!=null && request.getParameter("fFechaPagoFin")!=null){
				criterioPagoData.setFechaPagoIni(new Date(DF.parse(request.getParameter("fFechaPagoIni")).getTime()));
				criterioPagoData.setFechaPagoFin(new Date(DF.parse(request.getParameter("fFechaPagoFin")).getTime()));
				}else{
					criterioPagoData.setFechaPagoIni(null);
					criterioPagoData.setFechaPagoFin(null);
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
			List<ResultadoPagoBeanData> resultados=null;
			if(criterioPagoData.getEstado().equals("Cancelado")){
				resultados=sqlsesion.selectList("searchPagado",criterioPagoData);
			}else{
				resultados=sqlsesion.selectList("searchPago",criterioPagoData);
			}				
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
}
