package IngSoft.venta.bean;

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
public class CriterioSocioBeanFuncion {
	private Lock l= new ReentrantLock();
	private Lock l1= new ReentrantLock(); 
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioSocioBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioSocioBeanData criterioSocioData= new CriterioSocioBeanData();
		
		//criterioPromocionData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		criterioSocioData.setNombres(request.getParameter("txtNombres")+"%");
		criterioSocioData.setApellidoMaterno(request.getParameter("txtApellidoMaterno")+"%");
		criterioSocioData.setApellidoPaterno(request.getParameter("txtApellidoPaterno")+"%");
		if (request.getParameter("cmdTipoDocumento")!=null){
			String est;
			est=request.getParameter("cmdTipoDocumento");
			criterioSocioData.setTipoDocumento(est);}
	
	
		return criterioSocioData;				
	}
	
	public Vector<ResultadoSocioBeanData> buscarPlantillaSocio(CriterioSocioBeanData criterioSocioData){
		l1.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSocioBeanData> resultadosV=null;
		try{		
		List<ResultadoSocioBeanData> resultados=sqlsesion.selectList("searchPlantillaSocio",criterioSocioData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();
		l1.unlock();}
		return resultadosV;
		
	}
}
