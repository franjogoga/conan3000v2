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


public class CriterioOrdenPagoBeanFunction {

	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioOrdenPagoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioOrdenPagoBeanData criterioOrdenPagoData= new CriterioOrdenPagoBeanData();
		
		//criterioOrdenPagoData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		criterioOrdenPagoData.setSocio("%"+request.getParameter("txtSocio")+"%");
		
		try {
			if(request.getParameter("txtCodigoSocio")!=null)
				if(request.getParameter("txtCodigoSocio")=="")
					criterioOrdenPagoData.setIdSocio(null);
				else
				criterioOrdenPagoData.setIdSocio(request.getParameter("txtCodigoSocio"));
			else
				criterioOrdenPagoData.setIdSocio(null);
			
			if(request.getParameter("fFechaVencimientoIni")!=null && request.getParameter("fFechaVencimientoFin")!=null){
			criterioOrdenPagoData.setFechaVencimientoIni(new Date(DF.parse(request.getParameter("fFechaVencimientoIni")).getTime()));
			criterioOrdenPagoData.setFechaVencimientoFin(new Date(DF.parse(request.getParameter("fFechaVencimientoFin")).getTime()));
			}else{
				criterioOrdenPagoData.setFechaVencimientoIni(null);
				criterioOrdenPagoData.setFechaVencimientoFin(null);
			}
			
			if(request.getParameter("fFechaOrdenPagoIni")!=null && request.getParameter("fFechaOrdenPagoFin")!=null){
				criterioOrdenPagoData.setFechaPagoIni(new Date(DF.parse(request.getParameter("fFechaOrdenPagoIni")).getTime()));
				criterioOrdenPagoData.setFechaPagoFin(new Date(DF.parse(request.getParameter("fFechaOrdenPagoFin")).getTime()));
				}else{
					criterioOrdenPagoData.setFechaPagoIni(null);
					criterioOrdenPagoData.setFechaPagoFin(null);
				}
			
			if (request.getParameter("rButton")!=null){
			String est;
			est=request.getParameter("rButton");
			criterioOrdenPagoData.setEstado(est);}
			
		
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return criterioOrdenPagoData;				
	}
	
	public Vector<ResultadoOrdenPagoBeanData> buscarOrdenPago(CriterioOrdenPagoBeanData criterioOrdenPagoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoOrdenPagoBeanData> resultadosV=null;
		try{		
			List<ResultadoOrdenPagoBeanData> resultados=null;
			if(criterioOrdenPagoData.getEstado().equals("Cancelado")){
				resultados=sqlsesion.selectList("searchPagado",criterioOrdenPagoData);
			}else{
				resultados=sqlsesion.selectList("searchOrdenPago",criterioOrdenPagoData);
			}				
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
}
