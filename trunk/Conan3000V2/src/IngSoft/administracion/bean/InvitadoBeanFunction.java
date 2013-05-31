package IngSoft.administracion.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
	
	private Lock l= new ReentrantLock(); 
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	
	static private InvitadoBeanFunction invitadoFunction= null;
	
	
	public static InvitadoBeanFunction getInstance(){
		
		if (invitadoFunction==null)   
		
			      invitadoFunction = new  InvitadoBeanFunction();
			     
	
		
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
	
	
	public boolean modificarInvitado(InvitadoBeanData invitadoData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{

			
			sqlsesion.insert("Data.administracion.invitado.modificarPlantillaInvitado",invitadoData);

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nose pudo modificar la plantilla ", "SMAInvitado?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	
	
	public boolean eliminarInvitado(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.administracion.invitado.deletePLantillaInvitado",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la plantilla Invitado intente de nuevo", "SMAInvitado?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
}
