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

public class ServicioBeanFunction {	
	
	static private ServicioBeanFunction ServicioFunction=null;
	private Lock l= new ReentrantLock();     
		   
	public static ServicioBeanFunction getInstance(){
		if(ServicioFunction==null) ServicioFunction= new ServicioBeanFunction();
	    return ServicioFunction;
	}
	   
	private ServicioBeanFunction() {}
	
	public ServicioBeanData crearServicio(HttpServletRequest request, HttpServletResponse response){
		ServicioBeanData servicioData= new ServicioBeanData();
		try{
			servicioData.setNombre(request.getParameter("txtNombre"));
			servicioData.setIdAmbiente(request.getParameter("cmbAmbiente"));
			servicioData.setDescripcion(request.getParameter("txtDescripcion"));
		}catch(Exception e){
			e.printStackTrace();	
		}
		return servicioData;		
	} 
	
	public ServicioBeanData crearServicioModificado(HttpServletRequest request, HttpServletResponse response){
		ServicioBeanData servicioData= new ServicioBeanData();
		try{
			servicioData.setNombre(request.getParameter("txtNombre"));
			servicioData.setIdAmbiente(request.getParameter("cmbAmbiente"));
			servicioData.setDescripcion(request.getParameter("txtDescripcion"));
			servicioData.setEstado(request.getParameter("optionsRadios"));
		}catch(Exception e){
			e.printStackTrace();	
		}
		return servicioData;
	} 
	
	public boolean agregarServicio(ServicioBeanData servicioData) throws CoException {
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.administracion.servicio.getNextCodigo");
			if(codigo!=null){
				int cod= Integer.parseInt(codigo.substring(3))+1;
				String defecto= "000000";
				String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
				servicioData.setCodigo(codigo.substring(0,3).concat(temp));
			}
			else servicioData.setCodigo("SER000001");
			sqlsesion.insert("Data.administracion.servicio.insertServicio",servicioData);
	
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: El Servicio no se pudo registrar", "SMAServicio?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	public boolean eliminarServicio(String codigo) throws CoException {
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sqlsesion.update("Data.administracion.servicio.deleteServicio",codigo);
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar el servicio intente de nuevo", "SMAServicio?accion=Agregar&tipo=1");	
		}		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
		return resultado;
	}

	public boolean modificarServicio(ServicioBeanData servicioData) throws CoException {
		boolean resultado=false;
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sqlsesion.update("Data.administracion.servicio.updateServicio",servicioData);
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar el servicio intente de nuevo", "SMAServicio?accion=Modificar&tipo=1");
		}
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
		return resultado;
	}
	
	public ServicioBeanData consultarServicio(String codigo){
		ServicioBeanData servicioData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			servicioData = sqlsesion.selectOne("Data.administracion.servicio.getServicio",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return servicioData;
	}

	public Vector<SedeMiniBeanData> getSedes(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<SedeMiniBeanData> resultados=sqlsesion.selectList("Data.administracion.servicio.searchSedeMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
		
	public SedeMiniBeanData consultarCodigoSede (String codigo){
		SedeMiniBeanData sede=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		sede=sqlsesion.selectOne("Data.administracion.servicio.searchIdSede",codigo);
		sqlsesion.close();
		return sede;		
	}

	public Vector<AmbienteMiniBeanData> getAmbientes(String codigoSede){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<AmbienteMiniBeanData> resultados=sqlsesion.selectList("Data.administracion.servicio.searchAmbienteMini",codigoSede);
		sqlsesion.close();
		return new Vector<>(resultados);
	}
}