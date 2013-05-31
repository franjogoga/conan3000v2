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

public class ActividadBeanFuncion {
	
	
	
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); 

	static private ActividadBeanFuncion actividadFuncion=null;

	   public static ActividadBeanFuncion getInstance(){
	       if(actividadFuncion==null) actividadFuncion= new ActividadBeanFuncion();
	       
	       return actividadFuncion;
	   }
	   
	

	
	private ActividadBeanFuncion(){
		
		
	}
	
	
	public ActividadBeanData crearActividad(HttpServletRequest request, HttpServletResponse response){
		ActividadBeanData actividadData= new ActividadBeanData();
		try{		
			

			

        

		
		actividadData.setNombreSede(		request.getParameter("cmbSede"));		
		actividadData.setNombre(    		request.getParameter("txtNombre") );

		actividadData.setNombreTipoactividad(	request.getParameter("cmbTipoactividad"));
		
		actividadData.setNombreEncargado(		request.getParameter("cmbEncargadoCodigo"));
		//actividadData.setNombreEncargado(		request.getParameter("cmbEncargado"));
		actividadData.setPuesto(				request.getParameter("txtPuesto"));
		actividadData.setNombreAmbientes(		request.getParameter("cmbAmbiente"));
		
		actividadData.setFechaInicio(new Date(DF.parse(		request.getParameter("fFecIncio")+"/0000").getTime()));
		actividadData.setFechaFin(new Date(DF.parse(		request.getParameter("fFecFin")+"/0000").getTime()));
		actividadData.setDia(   						 	request.getParameter("txtDia") );
		actividadData.setDescripcion(    					request.getParameter("txtDescripcion") );
		actividadData.setEstado(    						request.getParameter("txtEstado") );
		
		

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return actividadData;		
	}
	
	public ActividadBeanData crearActividadModificada(HttpServletRequest request, HttpServletResponse response){
		ActividadBeanData actividadData= new ActividadBeanData();
		try{		
			
			

	        
  System.out.print("---> nombre que vamos a modificar" + request.getParameter("txtNombre"));
	
        actividadData.setCodigo(            request.getParameter("codigo"));	
		actividadData.setNombreSede(		request.getParameter("cmbSede"));		
		actividadData.setNombre(    		request.getParameter("txtNombre") );

		actividadData.setNombreTipoactividad(	request.getParameter("cmbTipoactividad"));
		
		actividadData.setNombreEncargado(		request.getParameter("cmbEncargadoCodigo"));
		//actividadData.setNombreEncargado(		request.getParameter("cmbEncargado"));
		actividadData.setPuesto(				request.getParameter("txtPuesto"));
		actividadData.setNombreAmbientes(		request.getParameter("cmbAmbiente"));
		
		actividadData.setFechaInicio(new Date(DF.parse(		request.getParameter("fFecIncio")+"/0000").getTime()));
		actividadData.setFechaFin(new Date(DF.parse(		request.getParameter("fFecFin")+"/0000").getTime()));
		actividadData.setDia(   						 	request.getParameter("txtDia") );
		actividadData.setDescripcion(    					request.getParameter("txtDescripcion") );
		actividadData.setEstado(    						request.getParameter("txtEstado") );
		
			


		}catch(Exception e){
			e.printStackTrace();
			
		}
		return actividadData;		
	}
	
	
	
	
	
	
	public boolean agregarActividad(ActividadBeanData actividadData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			
			// conesta sentencia podemos tener el codigo
			String codigo = (String)sqlsesion.selectOne("Data.administracion.actividad.getNextCodigo");

			System.out.print(" actividadData ----> "+ codigo);
			
			
			if(codigo!=null)
			{
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			actividadData.setCodigo(codigo.substring(0,3).concat(temp));
			}
			else actividadData.setCodigo("ATC000001");
			
			
			System.out.print(" actividadData " + actividadData.getNombre());
			

			
			sqlsesion.insert("Data.administracion.actividad.insertPlantillaActividad",actividadData);

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error en ingreso de datos: No se puede agregar la actividad ", "SMAActividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	

	
	public boolean modificarActividad(ActividadBeanData actividadData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{

			
			sqlsesion.insert("Data.administracion.actividad.modificarPlantillaActividad",actividadData);

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nose pudo modificar la plantilla ", "SMAActividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	
	
	
	
	
	
	
	public ActividadBeanData consultarActividad(String codigo){
		ActividadBeanData actividadData=null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			actividadData= sqlsesion.selectOne("Data.administracion.actividad.getPLantillaActividad",codigo);
			
		}
		finally{
			sqlsesion.close();
		}
		
	//	System.out.print(" SedeBeanFuncion <-- "+actividadData.getProvincia());
		
		return actividadData;
	}
	
	
	
	public boolean eliminarActividad(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.administracion.actividad.deletePLantillaActividad",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la plantilla Actividad intente de nuevo", "SMAActividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	/*   --------------------------------- funciones de apoyo a los combobox -------------------------------   */

	
	public Vector<TipoActividadMiniBeanData> getTipoactividades() throws CoException {
		Vector<TipoActividadMiniBeanData> acts= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		
		try{
			List<TipoActividadMiniBeanData> temp=sqlsesion.selectList("Data.administracion.actividad.getTipoactividad");			
			acts= new Vector<TipoActividadMiniBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de departamentos", "SMAActividad?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return acts;
	}
	
	public Vector<SedeBeanData> getSedes() throws CoException {
		Vector<SedeBeanData> sedes= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		
		try{
			List<SedeBeanData> temp=sqlsesion.selectList("Data.administracion.actividad.getSede");			
			sedes= new Vector<SedeBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de departamentos", "SMAActividad?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return sedes;
	}
	
	public Vector<AmbienteBeanData> getAmbientes() throws CoException {
		Vector<AmbienteBeanData> ambientes= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		
		try{
			List<AmbienteBeanData> temp=sqlsesion.selectList("Data.administracion.actividad.getAmbiente");			
			ambientes= new Vector<AmbienteBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de departamentos", "SMAActividad?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return ambientes;
	}
	

}
