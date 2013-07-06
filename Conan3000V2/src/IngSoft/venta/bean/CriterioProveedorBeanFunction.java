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


public class CriterioProveedorBeanFunction {
	private Lock l= new ReentrantLock(); 
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioProveedorBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
	
	CriterioProveedorBeanData criterioProveedorData= new CriterioProveedorBeanData();
	
	//criterioPromocionData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
	criterioProveedorData.setRazonSocial((request.getParameter("txtRazon"))+"%");
	
	criterioProveedorData.setRuc(Long.parseLong(request.getParameter("txtRuc").equals("")?"0":request.getParameter("txtRuc")));
	
	if( (criterioProveedorData.getRazonSocial()!="%") && (criterioProveedorData.getRuc()!=0)  ){
		criterioProveedorData.setRazonSocial("");
		
	}
	
	//juridicaData.setRuc(Integer.parseInt(request.getParameter("txtRuc").equals("")?"0":request.getParameter("txtRuc")));
	return criterioProveedorData;
	}

	

	public Vector<ResultadoProveedorBeanData> buscarPlantillaProveedor(CriterioProveedorBeanData criterioProveedorData){		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoProveedorBeanData> resultadosV=null;
		try{		
		List<ResultadoProveedorBeanData> resultados=sqlsesion.selectList("searchPlantillaProveedor",criterioProveedorData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();
		l.unlock();
		}
		return resultadosV;
		
	}
	
}


