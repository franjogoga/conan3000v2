package IngSoft.servicio.bean;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.nio.Buffer;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import IngSoft.general.MyBatisSesion;

public class EventoBeanFuncion {

	public void getTemp(){
		try{

		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Prueba prueba=(Prueba)sqlsesion.selectOne("selectTest",1);		
		System.out.println(""+prueba.getId()+"/"+prueba.getNombre());
		}
		catch(Exception e){
		e.printStackTrace();	
		}
	} 
	
	public void pruebahtml(){
		
		
		
		
	}
}
