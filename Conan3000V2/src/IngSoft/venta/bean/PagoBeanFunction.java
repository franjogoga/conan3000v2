package IngSoft.venta.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class PagoBeanFunction {
	static private PagoBeanFunction PagoFuncion=null;
	private Lock l= new ReentrantLock(); 
	private Lock l1= new ReentrantLock(); 
	private Lock l2= new ReentrantLock(); 
	private Lock l3= new ReentrantLock(); 
	private Lock l4= new ReentrantLock(); 
	private Lock l5= new ReentrantLock(); 
	private Lock l6= new ReentrantLock(); 
	private Lock l7= new ReentrantLock(); 
	private Lock l8= new ReentrantLock(); 
	
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static PagoBeanFunction getInstance(){
	       if(PagoFuncion==null) PagoFuncion= new PagoBeanFunction();
	       
	       return PagoFuncion;
	   }
	   
	   private PagoBeanFunction() {}
	
	public PagoBeanData crearPago(HttpServletRequest request, HttpServletResponse response){
		PagoBeanData pagoData= new PagoBeanData();
		try{		
	
		pagoData.setIdSocio(request.getParameter("idSocio"));
		//pagoData.setIdConcepto(request.getParameter("cmbConcepto"));
		pagoData.setFechaPago(new Date(DF.parse(request.getParameter("fFechaPago")).getTime()));
		
				
		
         	
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return pagoData;		
	} 
	
	public  PagoBeanData crearPagoMembresia(HttpServletRequest request, HttpServletResponse response){
		PagoBeanData pagoData= new PagoBeanData();
		try{		
	
		//pagoData.setIdSocio(request.getParameter("idSocio"));
		pagoData.setIdCuota(request.getParameter("idCuota"));
		pagoData.setFechaPago(new Date(DF.parse(request.getParameter("fFechaPago")).getTime()));
		//pagoData.setMonto(Double.parseDouble(request.getParameter("txtMonto")));
				
		
         	
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return pagoData;		
	}
	
	public PagoBeanData crearMulta(HttpServletRequest request, HttpServletResponse response){
		PagoBeanData pagoData= new PagoBeanData();
		try{		
	
		pagoData.setMulta(1+(Double.parseDouble(request.getParameter("txtMulta"))/100));
		//pagoData.setIdConcepto(request.getParameter("cmbConcepto"));
		pagoData.setFechaActual(new Date(DF.parse(request.getParameter("fFechaActual")).getTime()));
		
				
		
         	
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return pagoData;		
	} 
	
	
	
	
	public synchronized  boolean agregarPago(PagoBeanData pagoData) throws CoException {
		
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.pago.getNextCodigo2");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			pagoData.setIdIngreso(codigo.substring(0,3).concat(temp));}
			else pagoData.setIdIngreso("ING000001");
			//insertPago esta en pago mapper
			
			sqlsesion.update("Data.venta.pago.registrarPago",pagoData);
			sqlsesion.insert("insertIngreso",pagoData);
			String idMembresia=(String)sqlsesion.selectOne("Data.venta.pago.getIdMembresia",pagoData);
			pagoData.setIdMembresia(idMembresia);
			sqlsesion.update("Data.venta.pago.activarPago",pagoData);
			sqlsesion.update("Data.venta.pago.vencidoMembresiaPago",pagoData);
			//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de pago repetido", "SMVPago?accion=Agregar&tipo=1");
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
							
		}
		return resultado;
	}
	
	
	


	public synchronized  boolean eliminarPago(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			OrdenPagoBeanFunction orden=new OrdenPagoBeanFunction();
			orden.agregarOrdenPagoPrueba();
			
			//sqlsesion.update("Data.venta.pago.deletePago",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la pago, intente de nuevo", "SMVPago?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
			
	public synchronized  PagoBeanData consultarPago(String codigo){
		
		PagoBeanData pagoData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			pagoData= sqlsesion.selectOne("Data.venta.pago.getPagoMembresia",codigo);
		}
		catch(Exception a)		
		{
		a.printStackTrace();
		}
		finally{
			sqlsesion.close();
			
		}
		return pagoData;
	}
	
	public synchronized  PagoBeanData consultarPagoMembresia(String codigo){
		
		PagoBeanData pagoData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			pagoData= sqlsesion.selectOne("Data.venta.pago.getPagoMembresia",codigo);
		}
		catch(Exception a)		
		{
		a.printStackTrace();
		}
		finally{
			sqlsesion.close();
			
		}
		return pagoData;
	}
	
public synchronized  String consultarPagoMax() throws CoException {
		
		//boolean resultado=false;		
		
	String codigo=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			codigo= (String)sqlsesion.selectOne("Data.venta.pago.getNextCodigo2");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			
			codigo=(codigo.substring(0,3).concat(temp));}
			//else pagoData.setCodigo("MEM000001");
			//insertPago esta en pago mapper
			//sqlsesion.insert("insertPago",pagoData);
			//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
			
			//resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de pago repetido", "SMVPago?accion=Agregar&tipo=1");
		}
		
		finally{
			//sqlsesion.commit();
			sqlsesion.close();
								
		}
		return codigo;
	}


	public synchronized  void modificarPago(PagoBeanData pago) throws CoException {
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
		//	System.out.println("Ambs="+mods.size());
			sqlsesion.update("Data.venta.pago.anularPago",pago);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar la pago, intente de nuevo", "SMVPago?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();	
			
		}			
		return ;
	}
	
public synchronized String consultarMulta() throws CoException {
	
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		String cantidad=null;
		try{
			PagoBeanData pago=new PagoBeanData();
			final Calendar c = Calendar.getInstance();
			java.util.Date fechaActual = new java.util.Date(); 
			pago.setFechaActual(fechaActual);
			
			
			cantidad= (String)sqlsesion.selectOne("Data.venta.pago.getCantMultas");
		}
		catch(Exception a)		
		{//sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo obtener los datos", "SMVPago?accion=AplicarMulta&tipo=1");
			
		}
		
		finally{
			//sqlsesion.commit();
			sqlsesion.close();
			
		}			
		return cantidad;
}


public synchronized boolean aplicarMulta(PagoBeanData pagoData) throws CoException {
		
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			
			
			sqlsesion.update("Data.venta.pago.generarMulta",pagoData);
			sqlsesion.update("Data.venta.pago.vencidoMembresiaPago",pagoData);
			//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de pago repetido", "SMVPago?accion=Agregar&tipo=1");
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
								
		}
		return resultado;
	}






public synchronized  String consultarMultaExtra() throws CoException {
	
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	String cantidad=null;
	try{
		PagoBeanData pago=new PagoBeanData();
		final Calendar c = Calendar.getInstance();
		pago.setFechaActual(c.getTime());
		cantidad= (String)sqlsesion.selectOne("Data.venta.pago.getCantMultasExtra");
	}
	catch(Exception a)		
	{//sqlsesion.rollback();
	a.printStackTrace();
		throw CoException.set("Error: No se pudo obtener los datos", "SMVPago?accion=AplicarMultaExtra&tipo=1");
		
	}
	
	finally{
		//sqlsesion.commit();
		sqlsesion.close();
		
	}			
	return cantidad;
}


public synchronized  boolean aplicarMultaExtra(PagoBeanData pagoData) throws CoException {
	
	boolean resultado=false;		
	
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	
	try{
		
		
		sqlsesion.update("Data.venta.pago.generarMultaExtra",pagoData);
		//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
		
		resultado=true;
	}
	catch(Exception a)		
	{sqlsesion.rollback();
	a.printStackTrace();
		//throw CoException.set("Error: Nombre de pago repetido", "SMVPago?accion=Agregar&tipo=1");
	}
	
	finally{
		sqlsesion.commit();
		sqlsesion.close();
							
	}
	return resultado;
}



public synchronized  boolean cuotaVitalicio() throws CoException {
	
	boolean resultado=false;		
	
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	Vector<ResultadoPagoBeanData> resultadosV=null;
	try{
		
		
		
		List<ResultadoPagoBeanData> resultados=sqlsesion.selectList("Data.venta.pago.searchVitalicio");
		resultadosV= new Vector<>(resultados);
			for(int k=0;k<resultados.size();k++){
				ResultadoPagoBeanData res=((ResultadoPagoBeanData)resultados.get(k));
				sqlsesion.update("Data.venta.pago.updateCuotaVitalicio",res);
			}
		
		resultado=true;
	}
	catch(Exception a)		
	{sqlsesion.rollback();
	a.printStackTrace();
		//throw CoException.set("Error: Nombre de pago repetido", "SMVPago?accion=Agregar&tipo=1");
	}
	
	finally{
		sqlsesion.commit();
		sqlsesion.close();
							
	}
	return resultado;
}






}


