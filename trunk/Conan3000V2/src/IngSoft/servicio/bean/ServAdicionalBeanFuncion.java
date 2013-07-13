package IngSoft.servicio.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
import IngSoft.venta.bean.OrdenPagoBeanFunction;

@ApplicationScoped
public class ServAdicionalBeanFuncion {	
	
	static private ServAdicionalBeanFuncion ServAdicionalFuncion=null;

	
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static ServAdicionalBeanFuncion getInstance(){
	       if(ServAdicionalFuncion==null) ServAdicionalFuncion= new ServAdicionalBeanFuncion();
	       
	       return ServAdicionalFuncion;
	   }
	   
	   private ServAdicionalBeanFuncion() {}
	
	   	  	  
		public ServAdicionalBeanData crearServAdicional(HttpServletRequest request, HttpServletResponse response){
			ServAdicionalBeanData servAdicionalData= new ServAdicionalBeanData();
			String temp=null;
			try{
			servAdicionalData.setCodigo(request.getParameter("txtCodigo"));			
			servAdicionalData.setNombre(request.getParameter("txtNombre"));
			servAdicionalData.setTipo(request.getParameter("cmbTipo"));	
			servAdicionalData.setDescripcion(request.getParameter("txtDesc").trim());												
			temp=request.getParameter("txtPrecio");
			temp=(temp==null||temp.isEmpty())?"0.00":temp;
			temp= temp.contains(".")?temp:temp+".00";
			servAdicionalData.setPrecio(Double.parseDouble(temp));					
			}catch(Exception e){
				e.printStackTrace();				
			}
			return servAdicionalData;		
		} 
		
	   
	
	
	public synchronized boolean  agregarServAdicional(ServAdicionalBeanData servAdicionalData) throws CoException {
		boolean resultado=false;			
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.servicio.servadicional.getNextCodigoSA");
			codigo=codigo==null?"SRA000000":codigo;
			codigo=Utils.generaSiguienteCodigo(codigo);
			servAdicionalData.setCodigo(codigo);
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("codigo", servAdicionalData.getCodigo());
			map.put("nombre", servAdicionalData.getNombre());	
			map.put("precio", servAdicionalData.getPrecio());
			map.put("tipo",  servAdicionalData.getTipo());
			map.put("desc", servAdicionalData.getDescripcion());						
			sqlsesion.insert("Data.servicio.servadicional.insertServAdicional",map);
			sqlsesion.commit();
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de evento repetido", "SMSEvento?accion=Agregar&tipo=1");			
		}		
		finally{			
			sqlsesion.close();				
		}
		return resultado;
	}
	
		
	public Vector<ServAdicionalBeanData> buscarServAdicional(HashMap<String, Object> map){		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ServAdicionalBeanData> resultadosV=null;
		try{
		
		List<ServAdicionalBeanData> resultados=sqlsesion.selectList("Data.servicio.servadicional.searchServAdicional",map);
	
		resultadosV= new Vector<>(resultados);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		sqlsesion.close();}
		return resultadosV;
		
	}
	
	public synchronized boolean eliminarServAdicional(String codigo){
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sqlsesion.update("Data.servicio.servadicional.eliminarServAdicional", codigo);
			HashMap<String,	Object> map= new HashMap<>();					
			resultado=true;
		}catch(Exception e){
			e.printStackTrace();		
		}
		finally{
			sqlsesion.close();			
		}
		return resultado;
	}
		
			
	public synchronized boolean modificarServAdicional(ServAdicionalBeanData servAdicionalData){
		boolean resultado=false;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();	
		try{
			sqlsesion.update("Data.servicio.servadicional.modificarServAdicional", servAdicionalData);			
			resultado=true;
		}catch(Exception e){
			e.printStackTrace();		
		}
		finally{
			sqlsesion.close();
		}
		return resultado;
	}
	
	
}
