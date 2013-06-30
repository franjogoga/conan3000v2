package IngSoft.venta.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class EgresoBeanFunction {
	static private EgresoBeanFunction EgresoFuncion=null;
	private Lock l= new ReentrantLock();    
	private Lock l1= new ReentrantLock();
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static EgresoBeanFunction getInstance(){
	       if(EgresoFuncion==null) EgresoFuncion= new EgresoBeanFunction();
	       
	       return EgresoFuncion;
	   }
	   
	   private EgresoBeanFunction() {}
	
	public EgresoBeanData crearEgreso(HttpServletRequest request, HttpServletResponse response){
		EgresoBeanData egresoData= new EgresoBeanData();
		try{		
		
		egresoData.setDescripcion(request.getParameter("txtDescripcion"));
		egresoData.setMontoTotal(Double.parseDouble(request.getParameter("txtMonto")));
		//egresoData.setCantidad(Integer.parseInt(request.getParameter("txtCantidad")));
		egresoData.setFechaPago(new Date(DF.parse(request.getParameter("fFechaPago")).getTime()));
		egresoData.setIdConcepto("EGRESO");//probablemente no se use
		
		
         	
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return egresoData;		
	} 
	
	public boolean agregarEgreso(EgresoBeanData egresoData) throws CoException {
		
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.pago.getNextEgresos");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			egresoData.setIdEgreso(codigo.substring(0,3).concat(temp));}
			else egresoData.setIdEgreso("EGR000001");
			//insertEgreso esta en egreso mapper
			sqlsesion.insert("Data.venta.pago.insertEgresos",egresoData);
			
						
			
					resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Ha ocurrido un error al guardar los datos", "SMVEgreso?accion=Agregar&tipo=1");
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	
	
	
			
	public EgresoBeanData consultarEgreso(String codigo){
		l1.lock();
		EgresoBeanData egresoData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			egresoData= sqlsesion.selectOne("Data.venta.pago.getEgreso",codigo);
		}
		catch(Exception a)		
		{
		a.printStackTrace();
		}
		finally{
			sqlsesion.close();
			l1.unlock();
		}
		return egresoData;
	}
	



}
