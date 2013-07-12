package IngSoft.general.bean;

import java.io.Serializable;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class Conan3000ConstantesBeanFunction implements Serializable {

	private static Conan3000ConstantesBeanFunction constantes=null;
	private Conan3000ConstantesBeanFunction(){}
	
	public static Conan3000ConstantesBeanFunction getInstance(){
	       if(constantes==null) constantes= new Conan3000ConstantesBeanFunction();     
	       return constantes;
	   }
	
	public synchronized void actualizarConstantes(HashMap <String,Object> map){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sqlsesion.update("Data.general.constantes.updateConstantes", map);
			sqlsesion.commit();
			
		}
		catch(Exception e){			
		}
		finally{
			sqlsesion.close();
		}
		
	}
}
