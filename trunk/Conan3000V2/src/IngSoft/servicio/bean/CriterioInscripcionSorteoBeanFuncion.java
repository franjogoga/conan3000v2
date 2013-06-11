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

public class CriterioInscripcionSorteoBeanFuncion {
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); //
	
	public CriterioInscripcionSorteoBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		CriterioInscripcionSorteoBeanData criterioInscripcionSorteoData= new CriterioInscripcionSorteoBeanData();
		try {
			/*Date fecha = new Date(DF.parse(request.getParameter("date01")).getTime());
			criterioSorteoData.setFechaIni(fecha);*/
			criterioInscripcionSorteoData.setFechaIni(new Date(DF.parse(request.getParameter("date01")).getTime()));
			criterioInscripcionSorteoData.setFechaFin(new Date(DF.parse(request.getParameter("date02")).getTime()));
			criterioInscripcionSorteoData.setFechaSorteo(new Date(DF.parse(request.getParameter("date03")).getTime()));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return criterioInscripcionSorteoData;				
	}
	
	public Vector<ResultadoInscripcionSorteoBeanData> buscarPlantillaInscripcionSorteo(CriterioInscripcionSorteoBeanData criterioInscripcionSorteoData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoInscripcionSorteoBeanData> resultadosV=null;
		try{		
		List<ResultadoInscripcionSorteoBeanData> resultados=sqlsesion.selectList("searchPlantillaInscripcionSorteo",criterioInscripcionSorteoData);
		
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
}
