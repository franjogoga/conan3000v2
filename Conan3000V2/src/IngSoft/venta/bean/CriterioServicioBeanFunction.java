package IngSoft.venta.bean;

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
public class CriterioServicioBeanFunction {
	private Lock l= new ReentrantLock(); 
public CriterioServicioBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioServicioBeanData criterioServicioData= new CriterioServicioBeanData();
		
		//criterioPromocionData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		criterioServicioData.setNombreServicio(request.getParameter("txtNombre")+"%");
		criterioServicioData.setNombreProveedor(request.getParameter("txtProveedor")+"%");
		//try {		
			
		//} 
		//catch (ParseException e) {
			//e.printStackTrace();
		//}
		return criterioServicioData;				
	}
	
	public Vector<ResultadoServicioBeanData> buscarPlantillaServicio(CriterioServicioBeanData criterioServicioData){		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoServicioBeanData> resultadosV=null;
		try{		
		List<ResultadoServicioBeanData> resultados=sqlsesion.selectList("Data.venta.servicio.searchPlantillaServicio",criterioServicioData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();
		l.unlock();}
		return resultadosV;
		
	}
	
}
