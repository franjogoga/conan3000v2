package IngSoft.administracion.bean;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class InvitadoBeanFuncion {

static private InvitadoBeanFuncion invitado= null;
	
	
	public static InvitadoBeanFuncion getInstans(){
		
		if (invitado==null)   
				{
			      invitado = new  InvitadoBeanFuncion();
			      
			      System.out.print("--> InvitadoBeanFuncion");
				}
		
		return invitado;
	}
	
	
	private InvitadoBeanFuncion(){
		
		
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
