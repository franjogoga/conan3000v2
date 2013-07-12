package IngSoft.venta.bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;
@ApplicationScoped
public class CriterioSolicitudProductoBeanFunction {

	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioSolicitudProductoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
	
		
	CriterioSolicitudProductoBeanData criterioSolicitudProductoData= new CriterioSolicitudProductoBeanData();
	
	try {		
		
		criterioSolicitudProductoData.setLimInicio(new Date(DF.parse(request.getParameter("fFechInicio")).getTime()));
	
			
				
	} catch (ParseException e) {
		e.printStackTrace();
	}
		
	return criterioSolicitudProductoData;
	}

	

	public Vector<ResultadoSolicitudProductoBeanData> buscarPlantillaSolicitudProducto(CriterioSolicitudProductoBeanData criterioSolicitudProductoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSolicitudProductoBeanData> resultadosV=null;
		try{		
		List<ResultadoSolicitudProductoBeanData> resultados=sqlsesion.selectList("searchPlantillaSolicitudProducto",criterioSolicitudProductoData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}

	
}
