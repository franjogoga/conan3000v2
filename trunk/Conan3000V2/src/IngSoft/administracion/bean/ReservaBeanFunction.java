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

public class ReservaBeanFunction {
	static private ReservaBeanFunction reservaFunction= null;
		
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); 
	
	
	public static ReservaBeanFunction getInstance(){
		
		if (reservaFunction==null)   
				{
			      reservaFunction = new  ReservaBeanFunction();
			     
				}
		
		return reservaFunction;
	}
	
	
	private ReservaBeanFunction(){
		
		
	}
	
	
	
	
	
	
	
	
	
	public ReservaBeanData getReserva(int codigo){
		
		ReservaBeanData i= null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			i= sqlsesion.selectOne("getReserva",codigo);
		
		}
		finally{
			sqlsesion.close();
		}
		return i;
	}	
	
	
	public ReservaBeanData crearReserva(HttpServletRequest request, HttpServletResponse response){
		ReservaBeanData reservaData= new ReservaBeanData();
		try{		
	        
  System.out.print("---> codigo que vamos a modificar" + request.getParameter("codigo"));
	
       
		
  		reservaData.setCodigosocio(			request.getParameter("txtCodigosocio"));		
		reservaData.setCodigoinvitado(   		request.getParameter("txtCodigoinvitado") );

		reservaData.setFechainvitacion(new Date(DF.parse(		request.getParameter("fFecNacimiento")+"/0000").getTime()));
		reservaData.setMonto(Double.parseDouble(request.getParameter("txtMonto")));
		reservaData.setEstado(    								request.getParameter("optionsRadios") );
			
	

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return reservaData;		
	}
	

	public boolean agregarReserva(ReservaBeanData reservaData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			
			sqlsesion.insert("Data.administracion.reserva.insertPlantillaReserva",reservaData);
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nombre de Reserva repetido XD", "SMAReserva=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	
	public boolean modificarReserva(ReservaBeanData reservaData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{

			
			sqlsesion.insert("Data.administracion.reserva.modificarPlantillaReserva",reservaData);

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nose pudo modificar la plantilla ", "SMAReserva?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	
	
	
	
	public ReservaBeanData consultarReserva(String codigo){
		ReservaBeanData reservaData=null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			System.out.print("ReservaBeanFunction ---->  codigo = " + codigo);
			
			reservaData= sqlsesion.selectOne("Data.administracion.reserva.getPLantillaReserva",codigo);
			
		}
		finally{
			sqlsesion.close();
		}

		
		return reservaData;
	}
	

	public boolean eliminarReserva(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			System.out.print(" eliminar codigo  " +  codigo );
			
			
			sqlsesion.update("Data.administracion.reserva.deletePLantillaReserva",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la plantilla Reserva intente de nuevo", "SMAReserva?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
