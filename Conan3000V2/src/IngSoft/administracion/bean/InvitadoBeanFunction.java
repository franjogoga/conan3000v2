package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class InvitadoBeanFunction {
	static private InvitadoBeanFunction invitadoFunction= null;
	
	
	public static InvitadoBeanFunction getInstance(){
		
		if (invitadoFunction==null)   
				{
			      invitadoFunction = new  InvitadoBeanFunction();
			     
				}
		
		return invitadoFunction;
	}
	
	
	private InvitadoBeanFunction(){
		
		
	}
	
	public InvitadoBeanData getInvitado(int codigo){
		
		InvitadoBeanData i= null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			i= sqlsesion.selectOne("getInvitado",codigo);
		
		}
		finally{
			sqlsesion.close();
		}
		return i;
	}

	
}
