package IngSoft.general;

import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSesion {

	static SqlSessionFactory sesion;
	
	static public void metodo(){
		
		try{
			String resource = "Data/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			sesion = builder.build(inputStream);
			}
			catch(Exception e){}
			
	}
	
}
