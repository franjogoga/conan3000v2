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

public class AmbienteBeanFunction {	
	
	static private AmbienteBeanFunction AmbienteFunction=null;
	private Lock l= new ReentrantLock();     
		   
	public static AmbienteBeanFunction getInstance(){
		if(AmbienteFunction==null) AmbienteFunction= new AmbienteBeanFunction();
	    return AmbienteFunction;
	}
	   
	private AmbienteBeanFunction() {}
	
	public AmbienteBeanData crearAmbiente(HttpServletRequest request, HttpServletResponse response){
		AmbienteBeanData ambienteData= new AmbienteBeanData();
		try{
		ambienteData.setNombre(request.getParameter("txtNombreAmbiente"));
		ambienteData.setIdSede(request.getParameter("cmbSede"));
		ambienteData.setDescripcion(request.getParameter("txtDescripcion"));
		ambienteData.setCaracteristicas(request.getParameter("txtCaracteristica"));
		ambienteData.setIdTipoAmbiente(request.getParameter("cmbTipo"));
		}catch(Exception e){
			e.printStackTrace();	
		}
		return ambienteData;		
	} 
	
	public AmbienteBeanData crearAmbienteModificado(HttpServletRequest request, HttpServletResponse response){
		AmbienteBeanData ambienteData= new AmbienteBeanData();
		try{
		ambienteData.setNombre(request.getParameter("txtNombreAmbiente"));
		ambienteData.setIdSede(request.getParameter("cmbSede"));
		ambienteData.setDescripcion(request.getParameter("txtDescripcion"));
		ambienteData.setCaracteristicas(request.getParameter("txtCaracteristica"));
		ambienteData.setIdTipoAmbiente(request.getParameter("cmbTipo"));
		ambienteData.setEstado(request.getParameter("optionsRadios"));
		}catch(Exception e){
			e.printStackTrace();	
		}
		return ambienteData;		
	} 
	
	public boolean agregarAmbiente(AmbienteBeanData ambienteData) throws CoException {
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.administracion.ambiente.getNextCodigo");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			ambienteData.setCodigo(codigo.substring(0,3).concat(temp));}
			else ambienteData.setCodigo("AMB000001");
			sqlsesion.insert("Data.administracion.ambiente.insertAmbiente",ambienteData);
	
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: El Ambiente no se pudo registrar", "SMAAmbiente?accion=Agregar&tipo=1");
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	public boolean eliminarAmbiente(String codigo) throws CoException {
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sqlsesion.update("Data.administracion.ambiente.deleteAmbiente",codigo);
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar el ambiente intente de nuevo", "SMAAmbiente?accion=Agregar&tipo=1");	
		}		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
		return resultado;
	}

	public boolean modificarAmbiente(AmbienteBeanData ambienteData) throws CoException {
		boolean resultado=false;
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sqlsesion.update("Data.administracion.ambiente.updateAmbiente",ambienteData);
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar el ambiente intente de nuevo", "SMAAmbiente?accion=Modificar&tipo=1");
		}
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
		return resultado;
	}
	
	public AmbienteBeanData consultarAmbiente(String codigo){
		AmbienteBeanData ambienteData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			ambienteData = sqlsesion.selectOne("Data.administracion.ambiente.getAmbiente",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return ambienteData;
	}
	
	public Vector<SedeMiniBeanData> getSedes(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<SedeMiniBeanData> resultados=sqlsesion.selectList("Data.administracion.ambiente.searchSedeMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
		
	public Vector<TipoAmbienteMiniBeanData> getTipoAmbiente(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<TipoAmbienteMiniBeanData> resultados=sqlsesion.selectList("Data.administracion.ambiente.searchTipoAmbienteMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
}