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
	
	
	public HorariodeactividadBeanData crearHorariodeactividad(HttpServletRequest request, HttpServletResponse response){
		HorariodeactividadBeanData horariodeactividadData= new HorariodeactividadBeanData();
		try{		
			

			

        


		horariodeactividadData.setNombre(    		request.getParameter("txtNombre") );

		

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return horariodeactividadData;		
	}
	
	public HorariodeactividadBeanData crearHorariodeactividadModificada(HttpServletRequest request, HttpServletResponse response){
		HorariodeactividadBeanData horariodeactividadData= new HorariodeactividadBeanData();
		try{		
			
			

	        

	
        horariodeactividadData.setCodigo(            request.getParameter("codigo"));	
	
		horariodeactividadData.setNombre(    		request.getParameter("txtNombre") );

		
	


		}catch(Exception e){
			e.printStackTrace();
			
		}
		return horariodeactividadData;		
	}
	
	
	
	
	
	
	public boolean agregarHorariodeactividad(HorariodeactividadBeanData horariodeactividadData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			
			// conesta sentencia podemos tener el codigo
			String codigo = (String)sqlsesion.selectOne("Data.administracion.horariodeactividad.getNextCodigo");

			System.out.print(" horariodeactividadData ----> "+ codigo);
			
			
			if(codigo!=null)
			{
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			horariodeactividadData.setCodigo(codigo.substring(0,3).concat(temp));
			}
			else horariodeactividadData.setCodigo("HOR000001");
			
			
			System.out.print(" horariodeactividadData " + horariodeactividadData.getNombre());
			

			
			sqlsesion.insert("Data.administracion.horariodeactividad.insertPlantillahorariodeactividad",horariodeactividadData);

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error en ingreso de datos: No se puede agregar la horariodeactividad ", "SMAHorariodeactividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	

	
	public boolean modificarHorariodeactividad(HorariodeactividadBeanData horariodeactividadData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{

			
			sqlsesion.insert("Data.administracion.horariodeactividad.modificarPlantillaHorariodeactividad",horariodeactividadData);

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar la horariodeactividad ", "SMAHorariodeactividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}

	/*
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
	
	*/
	
	public Vector<HorariodeactividadBeanData> consultarHorariodeactividad(String codigo){	
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<HorariodeactividadBeanData> resultadosV=null;
		try{		
		List<HorariodeactividadBeanData> resultados=sqlsesion.selectList("Data.administracion.horariodeactividad.getPLantillaHorariodeactividad",codigo);
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
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
			throw CoException.set("Error: No se pudo eliminar la Horariodeactividad intente de nuevo", "SMAHorariodeactividad?accion=Agregar&tipo=1");
			
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

}
