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

public class CriterioSocioBeanFuncion {

	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public CriterioSocioBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		CriterioSocioBeanData criterioSocioData= new CriterioSocioBeanData();
		
		//criterioPromocionData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));
		criterioSocioData.setNombres(request.getParameter("txtNombres")+"%");
		criterioSocioData.setApellidoMaterno(request.getParameter("txtApellidoMaterno")+"%");
		criterioSocioData.setApellidoPaterno(request.getParameter("txtApellidoPaterno")+"%");
		if (request.getParameter("cmdTipoDocumento")!=null){
			String est;
			est=request.getParameter("cmdTipoDocumento");
			criterioSocioData.setTipoDocumento(est);}
	
		
		//try {		
			//criterioSocioData.setNumeroDocumento(Long.parseLong(request.getParameter("txtNumeroDocumento")));
			//if (request.getParameter("rButton")!=null){
			//String est;
			//est=request.getParameter("rButton");
			//criterioPromocionData.setEstado(est);}

		//criterioPromocionData.setTipo(Integer.parseInt(request.getParameter("cmbTipoEvento")==null?"0":request.getParameter("cmbTipoEvento")));

		//} catch (ParseException e) {
			//e.printStackTrace();
		//}
		return criterioSocioData;				
	}
	
	public Vector<ResultadoSocioBeanData> buscarPlantillaSocio(CriterioSocioBeanData criterioSocioData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSocioBeanData> resultadosV=null;
		try{		
		List<ResultadoSocioBeanData> resultados=sqlsesion.selectList("searchPlantillaSocio",criterioSocioData);
						
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
}
