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

public class MembresiaBeanFunction {
	static private MembresiaBeanFunction MembresiaFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static MembresiaBeanFunction getInstance(){
	       if(MembresiaFuncion==null) MembresiaFuncion= new MembresiaBeanFunction();
	       
	       return MembresiaFuncion;
	   }
	   
	   private MembresiaBeanFunction() {}
	
	public MembresiaBeanData crearMembresia(HttpServletRequest request, HttpServletResponse response){
		MembresiaBeanData membresiaData= new MembresiaBeanData();
		try{		
	
		membresiaData.setCodigoSocio(request.getParameter("idSocio"));
		membresiaData.setFechaInicio(new Date(DF.parse(request.getParameter("fFechaInicio")).getTime()));
		membresiaData.setFechafin(new Date(DF.parse(request.getParameter("fFechaFin")).getTime()));
		membresiaData.setCosto(Double.parseDouble(request.getParameter("txtCosto")));
		membresiaData.setPeriodo(request.getParameter("cmbPeriodo"));
		membresiaData.setEstado(request.getParameter("rButton"));
		
		if (request.getParameter("rButton")!=null){
		String est;
		est=request.getParameter("rButton");
		membresiaData.setEstado(est);}
		
		//if(request.getParameter("rButton").equals("option1")) {
		//membresiaData.setEstado(request.getParameter("option1"));}
          // else if (request.getParameter("rButton").equals("option2"))
            //	membresiaData.setEstado(request.getParameter("option2"));
         	
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return membresiaData;		
	} 
	
	public boolean agregarMembresia(MembresiaBeanData membresiaData) throws CoException {
		
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.membresia.getNextCodigo2");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			membresiaData.setCodigo(codigo.substring(0,3).concat(temp));}
			else membresiaData.setCodigo("MO000001");
			//insertMembresia esta en membresia mapper
			sqlsesion.insert("insertMembresia",membresiaData);
			//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de membresia repetido", "SMVMembresia?accion=Agregar&tipo=1");
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	public boolean eliminarMembresia(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.venta.membresia.deleteMembresia",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la membresia, intente de nuevo", "SMVMembresia?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
			
	public MembresiaBeanData consultarMembresia(String codigo){
		MembresiaBeanData membresiaData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			membresiaData= sqlsesion.selectOne("Data.venta.membresia.getPlantillaMembresia",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return membresiaData;
	}
	
public String consultarMembresiaMax() throws CoException {
		
		//boolean resultado=false;		
		//l.lock();
	String codigo=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			codigo= (String)sqlsesion.selectOne("Data.venta.membresia.getNextCodigo2");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			
			codigo=(codigo.substring(0,3).concat(temp));}
			//else membresiaData.setCodigo("MEM000001");
			//insertMembresia esta en membresia mapper
			//sqlsesion.insert("insertMembresia",membresiaData);
			//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
			
			//resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de membresia repetido", "SMVMembresia?accion=Agregar&tipo=1");
		}
		
		finally{
			//sqlsesion.commit();
			sqlsesion.close();
			//l.unlock();					
		}
		return codigo;
	}


	public void modificarMembresia(MembresiaBeanData membresia) throws CoException {
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
		//	System.out.println("Ambs="+mods.size());
			sqlsesion.update("Data.venta.membresia.updateMembresia",membresia);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar la membresia, intente de nuevo", "SMVMembresia?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}			
		return ;
	}

}
