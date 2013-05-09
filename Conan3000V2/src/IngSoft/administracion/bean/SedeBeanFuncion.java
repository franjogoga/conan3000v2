package IngSoft.administracion.bean;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;
import IngSoft.administracion.bean.SedeBeanData;
import IngSoft.administracion.bean.SedeBeanFuncion;

public class SedeBeanFuncion {
	
	
	
	//static private SedeBeanFuncion sede= null;

	static private SedeBeanFuncion sedeFuncion=null;

	   public static SedeBeanFuncion getInstance(){
	       if(sedeFuncion==null) sedeFuncion= new SedeBeanFuncion();
	       
	       return sedeFuncion;
	   }
	   
	

	
	private SedeBeanFuncion(){
		
		
	}
	
	/*
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
	*/

	public SedeBeanData consultarEvento(String codigo){
		SedeBeanData sedeData=null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sedeData= sqlsesion.selectOne("Data.administracion.sede.getPLantillaSede",codigo);
		
			System.out.print(" SedeBeanFuncion <-- "+sedeData.getNombre());
			
			
			
		}
		finally{
			sqlsesion.close();
		}
		
		System.out.print(" SedeBeanFuncion <-- "+sedeData.getProvincia());
		
		return sedeData;
	}
	
	
	
	

}
