package IngSoft.servicio.bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioSorteoBeanFuncion {
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); //
	
	public CriterioSorteoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		CriterioSorteoBeanData criterioSorteoData= new CriterioSorteoBeanData();
		criterioSorteoData.setNombre(("%"+request.getParameter("txtNombre")+"%").toUpperCase());
		try {
			criterioSorteoData.setFechaIni(new Date(DF.parse(request.getParameter("date01")).getTime()));
			criterioSorteoData.setFechaFin(new Date(DF.parse(request.getParameter("date02")).getTime()));
			criterioSorteoData.setFechaSorteo(new Date(DF.parse(request.getParameter("date03")).getTime()));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return criterioSorteoData;				
	}
	
	public Vector<ResultadoSorteoBeanData> buscarPlantillaSorteo(CriterioSorteoBeanData criterioSorteoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoSorteoBeanData> resultadosV=null;
		try{		
		List<ResultadoSorteoBeanData> resultados=sqlsesion.selectList("searchPlantillaSorteo",criterioSorteoData);
	
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
}
