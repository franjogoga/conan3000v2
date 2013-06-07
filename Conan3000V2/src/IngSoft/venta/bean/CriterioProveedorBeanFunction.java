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




public class CriterioProveedorBeanFunction {

	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioProveedorBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
	
	CriterioProveedorBeanData criterioProveedorData= new CriterioProveedorBeanData();
	
	//criterioPromocionData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
	criterioProveedorData.setRazonSocial((request.getParameter("txtRazon"))+"%");
	
	criterioProveedorData.setRuc(Long.parseLong(request.getParameter("txtRuc").equals("")?"0":request.getParameter("txtRuc")));
	if( (criterioProveedorData.getRazonSocial()==null) && (criterioProveedorData.getRuc()!=0) ){
		criterioProveedorData.setRazonSocial("jdajfwelkfedada");	
	}
	
	//juridicaData.setRuc(Integer.parseInt(request.getParameter("txtRuc").equals("")?"0":request.getParameter("txtRuc")));
	return criterioProveedorData;
	}

	

	public Vector<ResultadoProveedorBeanData> buscarPlantillaProveedor(CriterioProveedorBeanData criterioProveedorData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoProveedorBeanData> resultadosV=null;
		try{		
		List<ResultadoProveedorBeanData> resultados=sqlsesion.selectList("searchPlantillaProveedor",criterioProveedorData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
}

