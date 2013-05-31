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
	criterioProveedorData.setRazon("txtRazon");
	criterioProveedorData.setCorreo("txtCorreo");
	criterioProveedorData.setDireccion("txtDir");
	criterioProveedorData.setContacto("txtContacto");
	
		
				
		if (request.getParameter("rButton")!=null){
		String est;
		est=request.getParameter("rButton");
		criterioProveedorData.setRuc(est);}
		
		
		
	
	return criterioProveedorData;				}

	

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


