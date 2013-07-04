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

public class PromocionBeanFuncion {
	static private PromocionBeanFuncion PromocionFuncion=null;
	private Lock l= new ReentrantLock();     
	private Lock l1= new ReentrantLock();
	private Lock l2= new ReentrantLock();
	private Lock l3= new ReentrantLock();
	private Lock l4= new ReentrantLock();
	private Lock l5= new ReentrantLock();   
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static PromocionBeanFuncion getInstance(){
	       if(PromocionFuncion==null) PromocionFuncion= new PromocionBeanFuncion();
	       
	       return PromocionFuncion;
	   }
	   
	   private PromocionBeanFuncion() {}
	
	public PromocionBeanData crearPromocion(HttpServletRequest request, HttpServletResponse response){
		PromocionBeanData promocionData= new PromocionBeanData();
		try{		
	
		promocionData.setNombre(request.getParameter("txtNombrePromocion"));
		promocionData.setFechaInicio(new Date(DF.parse(request.getParameter("fFechInicio")).getTime()));
		promocionData.setFechafin(new Date(DF.parse(request.getParameter("fFechFin")).getTime()));
		promocionData.setDescripcion(request.getParameter("txtDescripcion"));
		if (request.getParameter("rButton")!=null){
		String est;
		est=request.getParameter("rButton");
		promocionData.setEstado(est);}
		
		//if(request.getParameter("rButton").equals("option1")) {
		//promocionData.setEstado(request.getParameter("option1"));}
          // else if (request.getParameter("rButton").equals("option2"))
            //	promocionData.setEstado(request.getParameter("option2"));
         	
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return promocionData;		
	} 
	
	public boolean agregarPromocion(PromocionBeanData promocionData) throws CoException {
		
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.promocion.getNextCodigo2");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			promocionData.setIdPromocion(codigo.substring(0,3).concat(temp));}
			else promocionData.setIdPromocion("PRO000001");
			//insertPromocion esta en promocion mapper
			sqlsesion.insert("insertPromocion",promocionData);
			//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
	    throw CoException.set("Error: Ha ocurrido un error al guardar los datos", "SMVPromocion?accion=Agregar&tipo=1");
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	public boolean eliminarPromocion(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.venta.promocion.deletePromocion",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la plantilla intente de nuevo", "SMVPromocion?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
			
	public PromocionBeanData consultarPromocion(String codigo){
		l2.lock();
		PromocionBeanData promocionData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			promocionData= sqlsesion.selectOne("Data.venta.promocion.getPlantillaPromocion",codigo);
		}
		finally{
			sqlsesion.close();
			l2.unlock();
		}
		return promocionData;
	}


	public void modificarPromocion(PromocionBeanData promocion) throws CoException {
		l3.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
		//	System.out.println("Ambs="+mods.size());
			sqlsesion.update("Data.venta.promocion.updatePromocion",promocion);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar la plantilla intente de nuevo", "SMVPromocion?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();	
			l3.unlock();
		}			
		return ;
	}
	
}
