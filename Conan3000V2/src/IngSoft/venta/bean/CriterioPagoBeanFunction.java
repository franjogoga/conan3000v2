package IngSoft.venta.bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;


public class CriterioPagoBeanFunction {
	private Lock l1= new ReentrantLock();
	private Lock l2= new ReentrantLock();
	private Lock l3= new ReentrantLock();
	private Lock l4= new ReentrantLock();
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
	
public CriterioPagoBeanData crearCriterioFlujo(HttpServletRequest request, HttpServletResponse response){
		
		CriterioPagoBeanData criterioPagoData= new CriterioPagoBeanData();
		
		//criterioPagoData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		
		
		try {
			
			
			if(request.getParameter("cmbAnho")!=null){
			criterioPagoData.setAnho(request.getParameter("cmbAnho"));
			}else{
			criterioPagoData.setAnho(request.getParameter("2013"));	
			}
			
			
		}finally{ }
		return criterioPagoData;				
	}
	
	public Vector<ResultadoPagoBeanData> buscarPago(CriterioPagoBeanData criterioPagoData){		
		l1.lock();
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
		catch(Exception a)		
		{
		a.printStackTrace();
		}
		finally{
		sqlsesion.close();
		l1.unlock();}
		return resultadosV;
		
	}
	
	
	public Vector<ResultadoSocioBeanData> buscarSocioMembresia(CriterioSocioBeanData criterioSocioData){		
		l2.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSocioBeanData> resultadosV=null;
		try{		
		List<ResultadoSocioBeanData> resultados=sqlsesion.selectList("searchSocioMembresiaPago",criterioSocioData);
						
		resultadosV= new Vector<>(resultados);
		}
		catch(Exception a)		
		{
		a.printStackTrace();
		}
		finally{
		sqlsesion.close();
		l2.unlock();}
		return resultadosV;
		
	}
	
	public Vector<ResultadoSocioBeanData> buscarSocioNoMembresia(CriterioSocioBeanData criterioSocioData){		
		l3.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSocioBeanData> resultadosV=null;
		try{		
		List<ResultadoSocioBeanData> resultados=sqlsesion.selectList("searchSocioNoMembresia",criterioSocioData);
						
		resultadosV= new Vector<>(resultados);
		}
		catch(Exception a)		
		{
		a.printStackTrace();
		}
		finally{
		sqlsesion.close();
		l3.unlock();}
		return resultadosV;
		
	}
	
	
	public Vector<ResultadoFlujoCajaBeanData> buscarFlujo(CriterioPagoBeanData criterioPagoData) throws CoException {
		l4.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoFlujoCajaBeanData> resultadosV=null;
		try{		
			List<ResultadoFlujoCajaBeanData> resultados=sqlsesion.selectList("getFlujoCaja",criterioPagoData.getAnho());
		resultadosV= new Vector<>(resultados);
		}
		catch(Exception a)		
		{
		a.printStackTrace();
		}
		finally{
		sqlsesion.close();
		l4.unlock();
		}
		return resultadosV;
	}

	
	
}
