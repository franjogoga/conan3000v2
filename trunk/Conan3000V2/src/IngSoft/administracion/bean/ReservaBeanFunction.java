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
	
	

	
	public ReservaBeanData crearReserva(HttpServletRequest request, HttpServletResponse response){
		ReservaBeanData reservaData= new ReservaBeanData();
		try{		
	        

			
			System.out.print("txtCodigoInv ---> "+request.getParameter("txtCodigoInv") );
	  		System.out.print("txtCodigoSoc ---> "+request.getParameter("txtCodigoSoc"));		
	  		

	  		System.out.print("fecha ---> "+ new Date(DF.parse(		request.getParameter("fFecInvitado")+"/0000").getTime()));
	  		System.out.print("monto ---> "+Double.parseDouble(            request.getParameter("txtMonto")));
	  				
			
			
			
		
  		reservaData.setCodigosocio(			                request.getParameter("txtCodigoSoc"));		
		reservaData.setCodigoinvitado(   	             	request.getParameter("txtCodigoInv") );

		reservaData.setFechaingreso(new Date(DF.parse(		request.getParameter("fFecInvitado")+"/0000").getTime()));
		reservaData.setMonto(Double.parseDouble(            request.getParameter("txtMonto")));
		reservaData.setEstado(    							"Activo" );
			
	

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
			
			
			
			String codigo = (String)sqlsesion.selectOne("Data.administracion.reserva.getNextInvitadoSocio");

			System.out.print(" reservaData ----> "+ codigo);
			
			
			if(codigo!=null)
			{
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			reservaData.setCodigo(codigo.substring(0,3).concat(temp));
			}
			else reservaData.setCodigo("IXS000001");

			
			
			sqlsesion.insert("Data.administracion.reserva.insertPlantillaReserva",reservaData);
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nombre de Reserva repetido ", "SMAReserva=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	
	
	
	
	public ReservaBeanData crearReservaModificar(HttpServletRequest request, HttpServletResponse response){
		ReservaBeanData reservaData= new ReservaBeanData();
		try{		
	        

			
			System.out.print("codigo ---> "+request.getParameter("codigo"));
	  		System.out.print("txtCodigoSoc ---> "+request.getParameter("txtCodigoSoc"));		
	  		System.out.print("txtCodigoInv ---> "+request.getParameter("txtCodigoInv") );

	  						
			
			
			
	  		reservaData.setCodigo(		                   request.getParameter("codigo"));	
  		reservaData.setCodigosocio(			                request.getParameter("txtCodigoSoc"));		
		reservaData.setCodigoinvitado(   	             	request.getParameter("txtCodigoInv") );

		reservaData.setFechaingreso(new Date(DF.parse(		request.getParameter("fFecInvitado")+"/0000").getTime()));
		reservaData.setMonto(Double.parseDouble(            request.getParameter("txtMonto")));
		reservaData.setEstado(    			request.getParameter("optionsRadios") 				);
			
	

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return reservaData;		
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
	
	public ReservaBeanData consultarReservaInvitado(String codigo){
		ReservaBeanData reservaData=null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			System.out.print("ReservaBeanFunction ---->  codigo = " + codigo);
			
			reservaData= sqlsesion.selectOne("Data.administracion.reserva.getPLantillaReservaInvitado",codigo);
			
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
	
	
	
	
	
	
	public  Vector<PersonaBeanData> getAllpersonas(){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<PersonaBeanData> resultadosV=null;
		try{
			
			
		List<PersonaBeanData> resultados=sqlsesion.selectList("Data.administracion.reserva.getAllpersonas");
	
		resultadosV= new Vector<>(resultados);
		
		
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
	
	
	
	
	
}
