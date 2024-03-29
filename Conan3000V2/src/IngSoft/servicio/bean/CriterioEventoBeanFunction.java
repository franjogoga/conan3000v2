package IngSoft.servicio.bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioEventoBeanFunction {
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	
	public CriterioEventoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		CriterioEventoBeanData criterioEventoData= new CriterioEventoBeanData();
		criterioEventoData.setNombre(request.getParameter("txtNombre").trim()+"%");
		criterioEventoData.setTipo(request.getParameter("cmbTipoEvento")==null?null:request.getParameter("cmbTipoEvento"));

		try {
			criterioEventoData.setLimInicio(new Date(DF.parse(request.getParameter("date01")+"/0000").getTime()));
			criterioEventoData.setLimFin(new Date(DF.parse(request.getParameter("date02")+"/0000").getTime()));
			//System.out.println(criterioEventoData.getLimFin());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return criterioEventoData;				
	}
	
	public Vector<EventoBeanData> buscarPlantillaEvento(HashMap<String, Object> map){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<EventoBeanData> resultadosV=null;
		try{		
		List<EventoBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchPlantillaEvento",map);
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}

}
