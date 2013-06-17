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

public class HorariodeactividadBeanFuncion {
	
	
	
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); 

	static private HorariodeactividadBeanFuncion horariodeactividadFuncion=null;

	   public static HorariodeactividadBeanFuncion getInstance(){
	       if(horariodeactividadFuncion==null) horariodeactividadFuncion= new HorariodeactividadBeanFuncion();
	       
	       return horariodeactividadFuncion;
	   }
	   
	

	
	private HorariodeactividadBeanFuncion(){
		
		
	}
	



	
	public HorariodeactividadBeanData consultarHorariodeactividad(String codigo){
		HorariodeactividadBeanData horariodeactividadData=null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			horariodeactividadData= sqlsesion.selectOne("Data.administracion.horariodeactividad.getPLantillaHorariodeactividad",codigo);
		}
		finally{
			sqlsesion.close();
		}

		return horariodeactividadData;
	}
	
	

	public boolean eliminarHorariodeactividad(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.administracion.horariodeactividad.deletePLantillaHorariodeactividad",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la Horariodetrabajo intente de nuevo", "SMAHorariodeactividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}

	
	//  funcion de apoyo para sacar los dias de la semana
	
	public Vector<DiasBeanData> getDias() throws CoException {
		Vector<DiasBeanData> diassemana= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			List<DiasBeanData> temp=sqlsesion.selectList("Data.administracion.horariodeactividad.getDias" );			
			diassemana= new Vector<DiasBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de Dias", "SMAHorariodeactividad?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return diassemana;
	}

	public Vector<ResultadoActividadBeanData> getActividades() throws CoException {
		Vector<ResultadoActividadBeanData> actividades= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			List<ResultadoActividadBeanData> temp=sqlsesion.selectList("Data.administracion.horariodeactividad.getAllActividades" );			
			actividades= new Vector<ResultadoActividadBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de actividades", "SMAHorariodeactividad?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return actividades;
	}
	
	
	
	
	
}
