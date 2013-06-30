package IngSoft.venta.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioSolicitudSocioBeanFuncion {
	private Lock l= new ReentrantLock();
	private Lock l1= new ReentrantLock(); 
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioSolicitudSocioBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioSolicitudSocioBeanData criterioSolicitudSocioData= new CriterioSolicitudSocioBeanData();
		
		try{
		//criterioPromocionData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		criterioSolicitudSocioData.setNombres(request.getParameter("txtNombres")+"%");
		criterioSolicitudSocioData.setApellidoMaterno(request.getParameter("txtApellidoM")+"%");
		criterioSolicitudSocioData.setApellidoPaterno(request.getParameter("txtApellidoP")+"%");
		criterioSolicitudSocioData.setFechaRegistro(new Date(DF.parse(request.getParameter("fFechaR")).getTime()));
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
	
		return criterioSolicitudSocioData;				
	}
	
	public Vector<ResultadoSolicitudSocioBeanData> buscarPlantillaSolicitudSocio(CriterioSolicitudSocioBeanData criterioSolicitudSocioData){		
		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSolicitudSocioBeanData> resultadosV=null;
		try{		
		List<ResultadoSolicitudSocioBeanData> resultados=sqlsesion.selectList("Data.venta.solicitudsocio.searchPlantillaSolicitudSocio",criterioSolicitudSocioData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();
		l.unlock();
		}
		return resultadosV;
		
	}
	
	public Vector<ResultadoSolicitudSocioBeanData> buscarPlantillaSolicitudAceptada(CriterioSolicitudSocioBeanData criterioSolicitudSocioData){		
		l1.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSolicitudSocioBeanData> resultadosV=null;
		try{		
		List<ResultadoSolicitudSocioBeanData> resultados=sqlsesion.selectList("Data.venta.solicitudsocio.searchPlantillaSolicitudAceptada",criterioSolicitudSocioData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();
		l1.unlock();
		}
		return resultadosV;
		
	}
}
