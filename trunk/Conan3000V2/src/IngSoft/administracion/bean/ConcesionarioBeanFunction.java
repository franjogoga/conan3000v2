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
import IngSoft.administracion.bean.SedeMiniBeanData;
import IngSoft.administracion.bean.TipoAmbienteMiniBeanData;

public class ConcesionarioBeanFunction {	
	
	static private ConcesionarioBeanFunction ConcesionarioFunction=null;
	private Lock l= new ReentrantLock();     
		   
	public static ConcesionarioBeanFunction getInstance(){
		if(ConcesionarioFunction==null) ConcesionarioFunction= new ConcesionarioBeanFunction();
	    return ConcesionarioFunction;
	}
	   
	private ConcesionarioBeanFunction() {}
	
	public ConcesionarioBeanData crearConcesionario(HttpServletRequest request, HttpServletResponse response){
		ConcesionarioBeanData concesionarioData= new ConcesionarioBeanData();
		try{
		concesionarioData.setRazonSocial(request.getParameter("txtRazonSocial"));
		concesionarioData.setRuc(Long.parseLong(request.getParameter("txtRuc")));
		concesionarioData.setDescripcion(request.getParameter("txtDescripcion"));
		}catch(Exception e){
			e.printStackTrace();	
		}
		return concesionarioData;		
	} 
	
	public ConcesionarioBeanData crearConcesionarioModificado(HttpServletRequest request, HttpServletResponse response){
		ConcesionarioBeanData concesionarioData= new ConcesionarioBeanData();
		try{
		concesionarioData.setRazonSocial(request.getParameter("txtRazonSocial"));
		concesionarioData.setRuc(Long.parseLong(request.getParameter("txtRuc")));
		concesionarioData.setDescripcion(request.getParameter("txtDescripcion"));
        concesionarioData.setEstado(request.getParameter("optionsRadios"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return concesionarioData;	
	} 
	
	public boolean agregarConcesionario(ConcesionarioBeanData concesionarioData) throws CoException {
		boolean resultado=false;	
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.administracion.concesionario.getNextCodigo");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			concesionarioData.setCodigo(codigo.substring(0,3).concat(temp));}
			else concesionarioData.setCodigo("CON000001");
			sqlsesion.insert("Data.administracion.concesionario.insertConcesionario",concesionarioData);
	
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: El Concesionario no se pudo registrar", "SMAConcesionario?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	public boolean eliminarConcesionario(String codigo) throws CoException {
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sqlsesion.update("Data.administracion.concesionario.deleteConcesionario",codigo);
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar el concesionario intente de nuevo", "SMAConcesionario?accion=Agregar&tipo=1");	
		}		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
		return resultado;
	}

	public boolean modificarConcesionario(ConcesionarioBeanData concesionarioData) throws CoException {
		boolean resultado=false;
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sqlsesion.update("Data.administracion.concesionario.updateConcesionario",concesionarioData);
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar el Concesionario intente de nuevo", "SMAConcesionario?accion=Modificar&tipo=1");
		}
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
		return resultado;
	}
	
	public ConcesionarioBeanData consultarConcesionario(String codigo){
		ConcesionarioBeanData concesionarioData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			concesionarioData = sqlsesion.selectOne("Data.administracion.concesionario.getConcesionario",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return concesionarioData;
	}
	

	public Vector<ConcesionarioSedeBeanData> getConcesionarioSede(String codigo){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<ConcesionarioSedeBeanData> resultados=sqlsesion.selectList("Data.administracion.concesionario.searchConcesionarioSede",codigo);
		sqlsesion.close();
		return new Vector<>(resultados);
	}
}