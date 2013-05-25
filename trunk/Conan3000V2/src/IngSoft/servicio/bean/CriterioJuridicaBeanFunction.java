package IngSoft.servicio.bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class CriterioJuridicaBeanFunction {
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	
	public PersonaJuridicaBeanData crearCriterio(HttpServletRequest request, HttpServletResponse response){
		PersonaJuridicaBeanData juridicaData= new PersonaJuridicaBeanData();
		
		juridicaData.setRazonSocial(request.getParameter("txtRazonSocial").trim()+"%");
		juridicaData.setRuc(Integer.parseInt(request.getParameter("txtRuc")));
		juridicaData.setEstado("Activo");
		
		return juridicaData;				
	}
	
	public Vector<ResultadoJuridicaBeanData> buscarPlantillaJuridica(PersonaJuridicaBeanData juridicaData){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoJuridicaBeanData> resultadosV=null;
		try{		
		List<ResultadoJuridicaBeanData> resultados = sqlsesion.selectList("searchJuridica",juridicaData);
	
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;     
		
		
	}

}
