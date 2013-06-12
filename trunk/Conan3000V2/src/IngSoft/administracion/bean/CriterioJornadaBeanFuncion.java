package IngSoft.administracion.bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioJornadaBeanFuncion {
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); //
	
	public CriterioJornadaBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		
		
		CriterioJornadaBeanData criterioJornadaData= new CriterioJornadaBeanData();
		criterioJornadaData.setIdEmpleado((request.getParameter("txtNombreJornada")).toUpperCase());
		
		
		
		try {
			/*Date fecha = new Date(DF.parse(request.getParameter("date01")).getTime());
			criterioSorteoData.setFechaIni(fecha);*/
			criterioJornadaData.setHoraInicio(request.getParameter("cmbHorarios"));
			criterioJornadaData.setHoraFin(new Date(DF.parse(request.getParameter("fFechaJornada")).getTime()));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		return criterioJornadaData;				
	}
	
	public Vector<ResultadoJornadaBeanData> buscarPlantillaJornada(CriterioJornadaBeanData criterioJornadaData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoJornadaBeanData> resultadosV=null;
		try{		
		List<ResultadoJornadaBeanData> resultados=sqlsesion.selectList("searchPlantillaJornada",criterioJornadaData);
		
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
}
