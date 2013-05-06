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

	
	

}
