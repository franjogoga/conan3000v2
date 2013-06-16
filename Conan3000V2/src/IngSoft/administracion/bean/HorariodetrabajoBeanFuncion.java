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

public class HorariodetrabajoBeanFuncion {
	
	
	
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); 

	static private HorariodetrabajoBeanFuncion horariodetrabajoFuncion=null;

	   public static HorariodetrabajoBeanFuncion getInstance(){
	       if(horariodetrabajoFuncion==null) horariodetrabajoFuncion= new HorariodetrabajoBeanFuncion();
	       
	       return horariodetrabajoFuncion;
	   }
	   
	

	
	private HorariodetrabajoBeanFuncion(){
		
		
	}
	
	
	public HorariodetrabajoBeanData crearHorariodetrabajo(HttpServletRequest request, HttpServletResponse response){
		HorariodetrabajoBeanData horariodetrabajoData= new HorariodetrabajoBeanData();
		try{		

		horariodetrabajoData.setNombre(    		request.getParameter("txtNombre") );
		horariodetrabajoData.setEstado(         "Activo"                          );
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return horariodetrabajoData;		
	}
	
	public HorariodetrabajoBeanData crearHorariodetrabajoModificada(HttpServletRequest request, HttpServletResponse response){
		HorariodetrabajoBeanData horariodetrabajoData= new HorariodetrabajoBeanData();
		try{		
			
			

	        

	
        horariodetrabajoData.setCodigo(            request.getParameter("codigo") );	
	
		horariodetrabajoData.setNombre(    		request.getParameter("txtNombre") );

		horariodetrabajoData.setEstado(   		request.getParameter("optionsRadios") );
		
	


		}catch(Exception e){
			e.printStackTrace();
			
		}
		return horariodetrabajoData;		
	}
	
	
	
	
	
	
	public String agregarHorariodetrabajo(HorariodetrabajoBeanData horariodetrabajoData) throws CoException {
		String resultado="";		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			
			// conesta sentencia podemos tener el codigo
			String codigo = (String)sqlsesion.selectOne("Data.administracion.horariodetrabajo.getNextCodigo");

			System.out.print(" horariodetrabajoData ----> "+ codigo);
			
			
			if(codigo!=null)
			{
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			horariodetrabajoData.setCodigo(codigo.substring(0,3).concat(temp));
			}
			else horariodetrabajoData.setCodigo("HOR000001");
			
			resultado = horariodetrabajoData.getCodigo() ;
			
			sqlsesion.insert("Data.administracion.horariodetrabajo.insertPlantillaHorariodetrabajo",horariodetrabajoData);

			
			
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error en ingreso de datos: No se puede agregar la horariodetrabajo ", "SMAHorariodetrabajo?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	

	
	public boolean modificarHorariodetrabajo(HorariodetrabajoBeanData horariodetrabajoData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{

			
			sqlsesion.insert("Data.administracion.horariodetrabajo.modificarPlantillaHorariodetrabajo",horariodetrabajoData);

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar la horariodetrabajo ", "SMAHorariodetrabajo?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}

	
	public HorariodetrabajoBeanData consultarHorariodetrabajo(String codigo){
		HorariodetrabajoBeanData horariodetrabajoData=null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			
			System.out.print(" entra a la consulta ---> "+ codigo  );
			horariodetrabajoData= sqlsesion.selectOne("Data.administracion.horariodetrabajo.getPLantillaHorariodetrabajo",codigo);
		}
		finally{
			
			System.out.print(" fallo ---> "+ codigo  );
			
			sqlsesion.close();
		}

		return horariodetrabajoData;
	}
	
	 
	/*
	public Vector<HorariodetrabajoBeanData> consultarHorariodetrabajo(String codigo){	
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<HorariodetrabajoBeanData> resultadosV=null;
		try{		
		List<HorariodetrabajoBeanData> resultados=sqlsesion.selectList("Data.administracion.horariodetrabajo.getPLantillaHorariodetrabajo",codigo);
		resultadosV= new Vector<>(resultados);
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
	}
	*/ 
	
	
	
	
	public boolean eliminarHorariodetrabajo(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.administracion.horariodetrabajo.deletePLantillaHorariodetrabajo",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la Horariodetrabajo intente de nuevo", "SMAHorariodetrabajo?accion=Agregar&tipo=1");
			
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
			List<DiasBeanData> temp=sqlsesion.selectList("Data.administracion.horariodetrabajo.getDias" );			
			diassemana= new Vector<DiasBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de Dias", "SMAHorariodetrabajo?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return diassemana;
	}

}
