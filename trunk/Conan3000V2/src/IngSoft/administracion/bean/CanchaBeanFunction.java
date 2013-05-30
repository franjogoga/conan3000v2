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

public class CanchaBeanFunction {	
	
	static private CanchaBeanFunction CanchaFunction=null;
	private Lock l= new ReentrantLock();     
		   
	public static CanchaBeanFunction getInstance(){
		if(CanchaFunction==null) CanchaFunction= new CanchaBeanFunction();
	    return CanchaFunction;
	}
	   
	private CanchaBeanFunction() {}
	
	public CanchaBeanData crearCancha(HttpServletRequest request, HttpServletResponse response){
		CanchaBeanData canchaData= new CanchaBeanData();
		try{
			canchaData.setNombre(request.getParameter("txtNombre"));
			canchaData.setIdTipoCancha(request.getParameter("cmbTipoCancha"));
			canchaData.setIdAmbiente(request.getParameter("cmbAmbiente"));
			canchaData.setDescripcion(request.getParameter("txtDescripcion"));
		}catch(Exception e){
			e.printStackTrace();	
		}
		return canchaData;		
	} 
	
	public CanchaBeanData crearCanchaModificado(HttpServletRequest request, HttpServletResponse response){
		CanchaBeanData canchaData= new CanchaBeanData();
		try{
			canchaData.setNombre(request.getParameter("txtNombre"));
			canchaData.setIdTipoCancha(request.getParameter("cmbTipoCancha"));
			canchaData.setIdAmbiente(request.getParameter("cmbAmbiente"));
			canchaData.setDescripcion(request.getParameter("txtDescripcion"));
			canchaData.setEstado(request.getParameter("optionsRadios"));
		}catch(Exception e){
			e.printStackTrace();	
		}
		return canchaData;
	} 
	
	
	public boolean agregarCancha(CanchaBeanData canchaData) throws CoException {
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.administracion.cancha.getNextCodigo");
			if(codigo!=null){
				int cod= Integer.parseInt(codigo.substring(3))+1;
				String defecto= "000000";
				String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
				canchaData.setCodigo(codigo.substring(0,3).concat(temp));
			}
			else canchaData.setCodigo("CAN000001");
			sqlsesion.insert("Data.administracion.cancha.insertCancha",canchaData);
	
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: Cancha repetida", "SMACancha?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	public boolean eliminarCancha(String codigo) throws CoException {
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sqlsesion.update("Data.administracion.cancha.deleteCancha",codigo);
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la cancha intente de nuevo", "SMACancha?accion=Agregar&tipo=1");	
		}		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
		return resultado;
	}

	public boolean modificarCancha(CanchaBeanData canchaData) throws CoException {
		boolean resultado=false;
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sqlsesion.update("Data.administracion.cancha.updateCancha",canchaData);
			resultado=true;
		}
		catch(Exception a){
			sqlsesion.rollback();
			a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar la cancha intente de nuevo", "SMACancha?accion=Modificar&tipo=1");
		}
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
		return resultado;
	}
	
	public CanchaBeanData consultarCancha(String codigo){
		CanchaBeanData canchaData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			canchaData = sqlsesion.selectOne("Data.administracion.cancha.getCancha",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return canchaData;
	}
	
	public Vector<AmbienteMiniBeanData> getAmbientes(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<AmbienteMiniBeanData> resultados=sqlsesion.selectList("Data.administracion.cancha.searchAmbienteMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
	
	public Vector<TipoCanchaMiniBeanData> getTipoCancha(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<TipoCanchaMiniBeanData> resultados=sqlsesion.selectList("Data.administracion.cancha.searchTipoCanchaMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
}