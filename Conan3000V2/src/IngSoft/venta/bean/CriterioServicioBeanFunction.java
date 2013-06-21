package IngSoft.venta.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioServicioBeanFunction {

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
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoServicioBeanData> resultadosV=null;
		try{		
		List<ResultadoServicioBeanData> resultados=sqlsesion.selectList("Data.venta.servicio.searchPlantillaServicio",criterioServicioData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
}
