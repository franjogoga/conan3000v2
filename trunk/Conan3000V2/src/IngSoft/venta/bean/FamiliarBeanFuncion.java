package IngSoft.venta.bean;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
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
	private Lock l1= new ReentrantLock();
	private Lock l2= new ReentrantLock();
	private Lock l3= new ReentrantLock();
	private Lock l4= new ReentrantLock();
	private Lock l5= new ReentrantLock();
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
	    //throw CoException.set("Error:  Ha ocurrido un error al guardar los datos", "SMVFamiliar?accion=Agregar&tipo=1");
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
		l1.lock();
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
	    //throw CoException.set("Error: Nombre de evento repetido", "SMSFamiliar?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l1.unlock();					
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
		l3.lock();
		FamiliarBeanData familiarData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			familiarData= sqlsesion.selectOne("Data.venta.familiar.getPlantillaFamiliar",codigo);
		}
		finally{
			sqlsesion.close();
			l3.unlock();
		}
		//BUSCA AMBIENTES EN OTRAS TABLAS
		sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<FamiliarBeanData> resultadosV=null;
		try{		
			List<FamiliarBeanData> resultados = sqlsesion.selectList("Data.venta.familiar.searchFamiliarOtros",codigo);
			resultadosV= new Vector<>(resultados);
		}
		finally{
			sqlsesion.close();
		}
		//COMPROBAR EL TAMAÑANO PARA SETEAR EL FLAG
		if(resultadosV.size()==0){
			familiarData.setFlag(0);
		}
		else {
			familiarData.setFlag(1);
		}
		return familiarData;
	}

	public void modificarFamiliar(FamiliarBeanData familiar) throws CoException {
		l4.lock();
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
			l4.unlock();
		}			
		return ;
	}
	
}
