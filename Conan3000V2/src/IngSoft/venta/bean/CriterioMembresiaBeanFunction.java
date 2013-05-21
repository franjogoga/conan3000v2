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


public class CriterioMembresiaBeanFunction {

	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioMembresiaBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioMembresiaBeanData criterioMembresiaData= new CriterioMembresiaBeanData();
		
		//criterioMembresiaData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		criterioMembresiaData.setCodigo(request.getParameter("idSocio")+"%");
		try {		
			
			criterioMembresiaData.setLimInicio(new Date(DF.parse(request.getParameter("fFechInicio")).getTime()));
			criterioMembresiaData.setLimFin(new Date(DF.parse(request.getParameter("fFechFin")).getTime()));
			if (request.getParameter("rButton")!=null){
			String est;
			est=request.getParameter("rButton");
			criterioMembresiaData.setEstado(est);}
			
			//if(request.getParameter("rButton").equals("option1")) {
			//	  criterioMembresiaData.setEstado(request.getParameter("option1"));}
			  //          else 
			//            	criterioMembresiaData.setEstado(request.getParameter("option2"));
			
			
				
			
		
		//criterioMembresiaData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		
			
			
			//criterioMembresiaData.setEstado(request.getParameterValues("optionsRadios")+"%");
			
			//System.out.println(criterioMembresiaData.getLimFin());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return criterioMembresiaData;				
	}
	
	public Vector<ResultadoMembresiaBeanData> buscarPlantillaMembresia(CriterioMembresiaBeanData criterioMembresiaData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoMembresiaBeanData> resultadosV=null;
		try{		
		List<ResultadoMembresiaBeanData> resultados=sqlsesion.selectList("searchPlantillaMembresia",criterioMembresiaData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
}
