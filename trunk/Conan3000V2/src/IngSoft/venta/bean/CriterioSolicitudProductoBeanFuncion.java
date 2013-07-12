package IngSoft.venta.bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;
@ApplicationScoped
public class CriterioSolicitudProductoBeanFuncion {
	private Lock l= new ReentrantLock();
	private Lock l1= new ReentrantLock(); 
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioSolicitudProductoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioSolicitudProductoBeanData criterioSolicitudProductoData= new CriterioSolicitudProductoBeanData();
		
		
		try {
			criterioSolicitudProductoData.setLimInicio(new Date(DF.parse(request.getParameter("fFecha")).getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
			
	
		return criterioSolicitudProductoData;				
	}
	
	public Vector<ResultadoSolicitudProductoBeanData> buscarPlantillaSolicitudProducto(CriterioSolicitudProductoBeanData criterioSolicitudProductoData){		
		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSolicitudProductoBeanData> resultadosV=null;
		try{		
		List<ResultadoSolicitudProductoBeanData> resultados=sqlsesion.selectList("Data.venta.solicitudproducto.searchPlantillaSolicitudProducto",criterioSolicitudProductoData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();
		l.unlock();
		}
		return resultadosV;
		
	}
	
	public Vector<ResultadoSolicitudProductoBeanData> buscarPlantillaSolicitudAceptada(CriterioSolicitudProductoBeanData criterioSolicitudProductoData){		
		l1.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSolicitudProductoBeanData> resultadosV=null;
		try{		
		List<ResultadoSolicitudProductoBeanData> resultados=sqlsesion.selectList("Data.venta.solicitudproducto.searchPlantillaSolicitudAceptada",criterioSolicitudProductoData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();
		l1.unlock();
		}
		return resultadosV;
		
	}
}
