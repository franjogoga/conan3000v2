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

public class CriterioProductoBeanFunction {

	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioProductoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioProductoBeanData criterioProductoData= new CriterioProductoBeanData();
		
		//criterioMembresiaData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		criterioProductoData.setNombre(request.getParameter("txtNombre")+"%");
		criterioProductoData.setDescripcion((request.getParameter("txtDescripcion")+"%"));
		if (request.getParameter("rButton")!=null){
		String est;
		est=request.getParameter("rButton");
		criterioProductoData.setEstado(est);}
		return criterioProductoData;				
	}
	
	public Vector<ResultadoProductoBeanData> buscarPlantillaProducto(CriterioProductoBeanData criterioProductoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoProductoBeanData> resultadosV=null;
		try{		
		List<ResultadoProductoBeanData> resultados=sqlsesion.selectList("searchPlantillaProducto",criterioProductoData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
	
}