package IngSoft.venta.bean;

import java.text.SimpleDateFormat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class FamiliarBeanFuncion {

	static private FamiliarBeanFuncion FamiliarFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static FamiliarBeanFuncion getInstance(){
	       if(FamiliarFuncion==null) FamiliarFuncion= new FamiliarBeanFuncion();
	       
	       return FamiliarFuncion;
	   }
	   
	   private FamiliarBeanFuncion() {}
	
	public FamiliarBeanData crearFamiliar(HttpServletRequest request, HttpServletResponse response){
		FamiliarBeanData familiarData= new FamiliarBeanData();
		
		familiarData.setCodigoSocio(request.getParameter("txtSocio"));
		familiarData.setParentesco(request.getParameter("cmbParentesco"));
		familiarData.setTelefonoFijo(Long.parseLong(request.getParameter("txtTelefonoF")));
		familiarData.setTelefonoCelular(Long.parseLong(request.getParameter("txtTelefonoC")));
		familiarData.setCorreo(request.getParameter("txtCorreo"));

		return familiarData;		
	} 
	
	public boolean agregarFamiliar(FamiliarBeanData familiarData) throws CoException {
		
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.familiar.getNextCodigo");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			familiarData.setCodigoFamiliar(codigo.substring(0,3).concat(temp));}
			else familiarData.setCodigoFamiliar("FAM000001");

			sqlsesion.insert("Data.venta.familiar.insertFamiliar",familiarData);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de familiar repetido", "SMVFamiliar?accion=Agregar&tipo=1");
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	public boolean agregarPersona(PersonaMiniBeanData personaData) throws CoException {
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.familiar.getNextCodigo");
			
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			codigo=(codigo.substring(0,3).concat(temp));
			if(codigo!=null){
			
			personaData.setCodigo(codigo);}
			else personaData.setCodigo("FAM000001");
			
			sqlsesion.insert("Data.venta.socio.insertPersona",personaData);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de evento repetido", "SMSEvento?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
			
		return resultado;
	}
	
	public boolean eliminarFamiliar(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.venta.familiar.deleteFamiliar",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar al familiar, intente de nuevo", "SMVFamiliar?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
			
	public FamiliarBeanData consultarFamiliar(String codigo){
		FamiliarBeanData familiarData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			familiarData= sqlsesion.selectOne("Data.venta.familiar.getPlantillaFamiliar",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return familiarData;
	}

	public void modificarFamiliar(FamiliarBeanData familiar) throws CoException {
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
			sqlsesion.update("Data.venta.familiar.updateFamiliar",familiar);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: No se pudo modificar el familiar, intente de nuevo", "SMVFamiliar?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}			
		return ;
	}
	
}
