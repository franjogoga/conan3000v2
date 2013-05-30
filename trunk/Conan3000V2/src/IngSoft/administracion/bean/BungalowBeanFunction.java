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
import IngSoft.administracion.bean.AmbienteMiniBeanData;

public class BungalowBeanFunction {	
	
	static private BungalowBeanFunction BungalowFunction=null;
	private Lock l= new ReentrantLock();     
		   
	public static BungalowBeanFunction getInstance(){
		if(BungalowFunction==null) BungalowFunction= new BungalowBeanFunction();
	    return BungalowFunction;
	}
	   
	private BungalowBeanFunction() {}
	
	public BungalowBeanData crearBungalow(HttpServletRequest request, HttpServletResponse response){
		BungalowBeanData bungalowData= new BungalowBeanData();
		try{
		bungalowData.setNumero(Integer.parseInt(request.getParameter("txtNumero")));
		bungalowData.setNumeroDivisiones(Integer.parseInt(request.getParameter("txtNumeroDivisiones")));
		bungalowData.setAreaBungalow(Double.parseDouble(request.getParameter("txtAreaBungalow")));
		bungalowData.setIdAmbiente(request.getParameter("cmbAmbiente"));
		bungalowData.setDescripcion(request.getParameter("txtDescripcion"));
		}catch(Exception e){
			e.printStackTrace();	
		}
		return bungalowData;		
	} 
	
	public BungalowBeanData crearBungalowModificado(HttpServletRequest request, HttpServletResponse response){
		BungalowBeanData bungalowData= new BungalowBeanData();
		try{
		bungalowData.setNumero(Integer.parseInt(request.getParameter("txtNumero")));
		bungalowData.setNumeroDivisiones(Integer.parseInt(request.getParameter("txtNumeroDivisiones")));
		bungalowData.setAreaBungalow(Double.parseDouble(request.getParameter("txtAreaBungalow")));
		bungalowData.setIdAmbiente(request.getParameter("cmbAmbiente"));
		bungalowData.setDescripcion(request.getParameter("txtDescripcion"));
		bungalowData.setEstado(request.getParameter("optionsRadios"));
		}catch(Exception e){
			e.printStackTrace();	
		}
		return bungalowData;
	} 
	
	
	public boolean agregarBungalow(BungalowBeanData bungalowData) throws CoException {
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.administracion.bungalow.getNextCodigo");
			if(codigo!=null){
				int cod= Integer.parseInt(codigo.substring(3))+1;
				String defecto= "000000";
				String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
				bungalowData.setCodigo(codigo.substring(0,3).concat(temp));
			}
			else bungalowData.setCodigo("BUN000001");
			sqlsesion.insert("Data.administracion.bungalow.insertBungalow",bungalowData);
	
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: Bungalow repetido", "SMABungalow?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	public boolean eliminarBungalow(String codigo) throws CoException {
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sqlsesion.update("Data.administracion.bungalow.deleteBungalow",codigo);
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar el bungalow intente de nuevo", "SMABungalow?accion=Agregar&tipo=1");	
		}		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
		return resultado;
	}

	public boolean modificarBungalow(BungalowBeanData bungalowData) throws CoException {
		boolean resultado=false;
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sqlsesion.update("Data.administracion.bungalow.updateBungalow",bungalowData);
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar el bungalow intente de nuevo", "SMABungalow?accion=Modificar&tipo=1");
		}
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
		return resultado;
	}
	
	public BungalowBeanData consultarBungalow(String codigo){
		BungalowBeanData bungalowData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			bungalowData = sqlsesion.selectOne("Data.administracion.bungalow.getBungalow",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return bungalowData;
	}
		
	public Vector<AmbienteMiniBeanData> getAmbientes(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<AmbienteMiniBeanData> resultados=sqlsesion.selectList("Data.administracion.bungalow.searchAmbienteMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
}