package IngSoft.servicio.bean;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import IngSoft.general.MyBatisSesion;

public class EventoBeanFuncion {

	public void getTemp(){
		try{
		SqlSessionFactory sqlSesionB;
		String resource = "Data/config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		sqlSesionB = builder.build(inputStream);
		SqlSession sqlsesion=sqlSesionB.openSession();//MyBatisSesion.metodo().openSession();
		Prueba prueba=(Prueba)sqlsesion.selectOne("selectTest",1);		
		System.out.println(""+prueba.getId()+"/"+prueba.getNombre());
		}
		catch(Exception e){
		e.printStackTrace();	
		}
	} 
}
