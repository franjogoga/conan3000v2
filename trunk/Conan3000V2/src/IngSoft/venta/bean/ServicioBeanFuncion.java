package IngSoft.venta.bean;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class ServicioBeanFuncion {

static private ServicioBeanFuncion ServicioFuncion=null;
	
	private Lock l= new ReentrantLock();     
	//SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static ServicioBeanFuncion getInstanceS(){
	       if(ServicioFuncion==null) ServicioFuncion= new ServicioBeanFuncion();
	       
	       return ServicioFuncion;
	   }
	   
	   private ServicioBeanFuncion() {}
	
	public ServicioBeanData crearServicio(HttpServletRequest request, HttpServletResponse response){
		ServicioBeanData servicioData= new ServicioBeanData();
		try{		

		servicioData.setDescripcion(request.getParameter("txtDescripcion"));
		servicioData.setNombreProveedor(request.getParameter("txtNombreProv"));
		servicioData.setNombreServicio(request.getParameter("txtNombreServ"));
		servicioData.setPrecio(Long.parseLong(request.getParameter("txtPrecio")));

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return servicioData;		
	} 
	
	public boolean agregarSocio(SocioBeanData socioData) throws CoException {
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.socio.getNextCodigo3");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			//String codigoM=;
			
			socioData.setCodigo(codigo.substring(0,3).concat(temp));}
			else socioData.setCodigo("SOC000001");

			sqlsesion.insert("Data.venta.socio.insertSocio",socioData);

			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de evento repetido", "SMSEvento?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
			
		return resultado;
	}
	
	
	public ServicioBeanData consultarServicio(String codigo){
	ServicioBeanData servicioData=null;
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	try{
		servicioData= sqlsesion.selectOne("Data.venta.servicio.getPlantillaServicio",codigo);
	}
	finally{
		sqlsesion.close();
	}
	return servicioData;
	}
	
	public boolean eliminarServicio(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.venta.servicio.deleteServicio",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la plantilla intente de nuevo", "SMVServicio?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	public ProveedorBeanData consultarProveedor(String codigo){
		ProveedorBeanData proveedorData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			proveedorData= sqlsesion.selectOne("Data.venta.servicio.getPlantillaProveedor",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return proveedorData;
	}
	
	public void modificarServicio(ServicioBeanData servicio) throws CoException {
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
			sqlsesion.update("Data.venta.servicio.updateServicio",servicio);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar la plantilla intente de nuevo", "SMVServico?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}			
		return ;
	}
	
}
