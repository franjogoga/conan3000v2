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
import IngSoft.servicio.bean.CriterioEventoBeanData;
import IngSoft.servicio.bean.ResultadoEventoBeanData;

public class CriterioPromocionBeanFunction {

	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	
	public CriterioPromocionBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioPromocionBeanData criterioPromocionData= new CriterioPromocionBeanData();
		
		//criterioPromocionData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));

		try {
			
			criterioPromocionData.setNombre(request.getParameter("txtNombrePromocion")+"%");
			
			criterioPromocionData.setLimInicio(new Date(DF.parse(request.getParameter("fFechInicio")).getTime()));
			criterioPromocionData.setLimFin(new Date(DF.parse(request.getParameter("fFechFin")).getTime()));
			
			//System.out.println(criterioEventoData.getLimFin());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return criterioPromocionData;				
	}
	
	public Vector<ResultadoPromocionBeanData> buscarPlantillaPromocion(CriterioPromocionBeanData criterioPromocionData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoPromocionBeanData> resultadosV=null;
		try{		
		List<ResultadoPromocionBeanData> resultados=sqlsesion.selectList("searchPlantillaPromocion",criterioPromocionData);
	
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
}
