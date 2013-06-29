package IngSoft.administracion.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class InfraccionBeanFunction {
	static private InfraccionBeanFunction infraccionFunction= null;
		
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); 
	
	
	public static InfraccionBeanFunction getInstance(){
		
		if (infraccionFunction==null)   
				{
			      infraccionFunction = new  InfraccionBeanFunction();
			     
				}
		
		return infraccionFunction;
	}
	
	
	private InfraccionBeanFunction(){
		
		
	}
	
	

	
	public InfraccionBeanData crearInfraccion(HttpServletRequest request, HttpServletResponse response){
		InfraccionBeanData infraccionData= new InfraccionBeanData();
		try{		
	        

			
			
	  		System.out.print("txtCodigoSoc ---> "+request.getParameter("txtCodigoSoc"));		
	  		

	  	
	  		System.out.print("monto ---> "+Double.parseDouble(            request.getParameter("txtMonto")));
	  				
			
			
			
		
  		infraccionData.setCodigo(			                request.getParameter("txtCodigoSoc"));		
		infraccionData.setMontomulta(Double.parseDouble(            request.getParameter("txtMonto")));
		infraccionData.setDescripcion(			                request.getParameter("txtDescripcion"));
		infraccionData.setFechainicio(new Date(DF.parse(		request.getParameter("fFecInicio")+"/0000").getTime()));
		infraccionData.setFechafin(new Date(DF.parse(		request.getParameter("fFecFin")+"/0000").getTime()));
		
		infraccionData.setEstado(    							"Activo" );
			
	

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return infraccionData;		
	}
	

	public boolean agregarInfraccion(InfraccionBeanData infraccionData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			
			
			
			String codigo = (String)sqlsesion.selectOne("Data.administracion.infraccion.getNextInfraccion");

			System.out.print(" infraccionData ----> "+ codigo);
			
			
			if(codigo!=null)
			{
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			infraccionData.setCodigo(codigo.substring(0,3).concat(temp));
			}
			else infraccionData.setCodigo("SXF000001");

			
			
			sqlsesion.insert("Data.administracion.infraccion.insertPlantillaInfraccion",infraccionData);
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nombre de infraccion repetido ", "SMAInfraccion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	
	
	
	
	public InfraccionBeanData crearReservaModificar(HttpServletRequest request, HttpServletResponse response){
		InfraccionBeanData infraccionData= new InfraccionBeanData();
		try{		
	        

			System.out.print("modifciar");
			System.out.print("codigo ---> "+request.getParameter("codigo"));
	  		System.out.print("txtCodigoSoc ---> "+request.getParameter("txtCodigoSoc"));		
	  		System.out.print("txtCodigoInv ---> "+request.getParameter("txtCodigoInv") );

	  		System.out.print("fecha ---> "+ new Date(DF.parse(		request.getParameter("fFecInvitado")+"/0000").getTime()));
	  		//System.out.print("monto ---> "+Double.parseDouble(            request.getParameter("txtMonto")));
	  				
			
			
			
	  		infraccionData.setCodigo(			                request.getParameter("txtCodigoSoc"));		
			infraccionData.setMontomulta(Double.parseDouble(            request.getParameter("txtMonto")));
			infraccionData.setDescripcion(			                request.getParameter("txtDescripcion"));
			infraccionData.setFechainicio(new Date(DF.parse(		request.getParameter("fFecInicio")+"/0000").getTime()));
			infraccionData.setFechafin(new Date(DF.parse(		request.getParameter("fFecFin")+"/0000").getTime()));
		infraccionData.setEstado(    									request.getParameter("optionsRadios")		);
			
	

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return infraccionData;		
	}
	
	
	
	
	
	public boolean modificarInfraccion(InfraccionBeanData infraccionData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{

			
			sqlsesion.insert("Data.administracion.infraccion.modificarPlantillaInfraccion",infraccionData);

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nose pudo modificar la plantilla ", "SMAInfraccion?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	
	
	
	
	public InfraccionBeanData consultarInfraccion(String codigo){
		InfraccionBeanData infraccionData=null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			System.out.print("InfraccionBeanFunction ---->  codigo = " + codigo);
			
			infraccionData= sqlsesion.selectOne("Data.administracion.infraccion.getPLantillaInfraccion",codigo);
			
		}
		finally{
			sqlsesion.close();
		}

		
		return infraccionData;
	}
	
	

	

	public boolean eliminarInfraccion(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			System.out.print(" eliminar codigo  " +  codigo );
			
			
			sqlsesion.update("Data.administracion.infraccion.deletePLantillaInfraccion",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la plantilla infraccion intente de nuevo", "SMAInfraccion?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
	
	
	
	
	public  Vector<PersonaBeanData> getAllpersonas(){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<PersonaBeanData> resultadosV=null;
		try{
			
			
		List<PersonaBeanData> resultados=sqlsesion.selectList("Data.administracion.infraccion.getAllpersonas");
	
		resultadosV= new Vector<>(resultados);
		
		
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
	
	
	
	
	
}