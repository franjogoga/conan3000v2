package IngSoft.venta.bean;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioVentaBeanFunction {

	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioVentaBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioVentaBeanData criterioVentaData= new CriterioVentaBeanData();
		
		//criterioMembresiaData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		criterioVentaData.setIdVenta(request.getParameter("txtVenta")+"%");
		//criterioProductoData.setDescripcion((request.getParameter("txtDescripcion")+"%"));
		//if (request.getParameter("rButton")!=null){
		//String est;
		//est=request.getParameter("rButton");
		//criterioProductoData.setEstado(est);}
		return criterioVentaData;				
	}
	
	public Vector<ResultadoVentaBeanData> buscarPlantillaVenta(CriterioVentaBeanData criterioVentaData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoVentaBeanData> resultadosV=null;
		try{		
		List<ResultadoVentaBeanData> resultados=sqlsesion.selectList("searchPlantillaVenta",criterioVentaData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
	
}
