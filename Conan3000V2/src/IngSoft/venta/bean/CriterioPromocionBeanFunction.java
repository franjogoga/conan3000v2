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


public class CriterioPromocionBeanFunction {

	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioPromocionBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioPromocionBeanData criterioPromocionData= new CriterioPromocionBeanData();
		
		//criterioPromocionData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		criterioPromocionData.setNombre(request.getParameter("txtNombrePromocion"));
		try {		
			
			criterioPromocionData.setLimInicio(new Date(DF.parse(request.getParameter("fFechInicio")).getTime()));
			criterioPromocionData.setLimFin(new Date(DF.parse(request.getParameter("fFechFin")).getTime()));
			if (request.getParameter("rButton")!=null){
			String est;
			est=request.getParameter("rButton");
			criterioPromocionData.setEstado(est);}
			
			//if(request.getParameter("rButton").equals("option1")) {
			//	  criterioPromocionData.setEstado(request.getParameter("option1"));}
			  //          else 
			//            	criterioPromocionData.setEstado(request.getParameter("option2"));
			
			
				
			
		
		//criterioPromocionData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		
			
			
			criterioPromocionData.setEstado(request.getParameterValues("optionsRadios")+"%");
			
			//System.out.println(criterioPromocionData.getLimFin());
			
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
