package IngSoft.administracion.bean;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;
import IngSoft.servicio.bean.EventoBeanData;

public class SedeBeanFuncion {
	
	
	
	static private SedeBeanFuncion sede= null;
	
	
	public static SedeBeanFuncion getInstans(){
		
		if (sede==null)   
				{
			      sede = new  SedeBeanFuncion();
			      
			      System.out.print("--> SedeBeanFuncion");
				}
		
		return sede;
	}
	
	
	private SedeBeanFuncion(){
		
		
	}
	
	public SedeBeanData getSede(int codigo){
		
		SedeBeanData s= null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			s= sqlsesion.selectOne("getSede",codigo);
		
		}
		finally{
			sqlsesion.close();
		}
		return s;
	}

	
	
	
	/*
	public EventoBeanData consultarEvento(int codigo){
		EventoBeanData eventoData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			eventoData= sqlsesion.selectOne("getPLantillaEvento",codigo);
			//eventoData.setCodigo(Integer.parseInt((String)sqlsesion.selectOne("getNextCodigo")));
			//sqlsesion.insert("insertPlantillaEvento",eventoData);
			List<String> temp = null;
			temp=sqlsesion.selectList("getSedesId",codigo);
			eventoData.setIdSede(temp.toArray(new String[temp.size()]));
			temp=sqlsesion.selectList("getAmbientesId",codigo);
			eventoData.setIdAmbientes(temp.toArray(new String[temp.size()]));			
		}
		finally{
			sqlsesion.close();
		}
		return eventoData;
	}
	 * 
	 * */
}
