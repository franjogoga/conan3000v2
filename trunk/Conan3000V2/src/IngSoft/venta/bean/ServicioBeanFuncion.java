package IngSoft.venta.bean;

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
private Lock l1= new ReentrantLock();
private Lock l2= new ReentrantLock();
private Lock l3= new ReentrantLock();
private Lock l4= new ReentrantLock();
private Lock l5= new ReentrantLock();
private Lock l6= new ReentrantLock();
private Lock l7= new ReentrantLock();
private Lock l8= new ReentrantLock();
	
	//SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static ServicioBeanFuncion getInstanceS(){
	       if(ServicioFuncion==null) ServicioFuncion= new ServicioBeanFuncion();
	       
	       return ServicioFuncion;
	   }
	   
	   private ServicioBeanFuncion() {}
	
	public ServicioBeanData crearServicio(HttpServletRequest request, HttpServletResponse response){
		ServicioBeanData servicioData= new ServicioBeanData();

		servicioData.setDescripcion(request.getParameter("txtDescripcion"));
		servicioData.setNombreProveedor(request.getParameter("txtNombreProv"));
		servicioData.setNombreServicio(request.getParameter("txtNombreServ"));
		try{		

		servicioData.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return servicioData;		
	} 
	
	public boolean agregarServicio(ServicioBeanData servicioData) throws CoException {
		boolean resultado=false;		
		l1.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.servicio.getNextCodigo");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			servicioData.setCodServicio(codigo.substring(0,3).concat(temp));}
			else servicioData.setCodServicio("SEP000001");

			sqlsesion.insert("Data.venta.servicio.insertServicio",servicioData);

			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de servicio repetido", "SMVServicio?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l1.unlock();					
		}
			
		return resultado;
	}
	
	public boolean agregarLinea(LineaServicioBeanData lineaData) throws CoException {
		boolean resultado=false;		
		l2.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			
			sqlsesion.insert("Data.venta.solicitudservicio.insertLinea",lineaData);

			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de linea servicio repetido", "SMVServicio?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l2.unlock();					
		}
			
		return resultado;
	}
	
	public String consultarSolicitudServicio() throws CoException {	
        l4.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		String codS=null;
		try{
			codS= (String)sqlsesion.selectOne("Data.venta.servicio.getUltimoCodigo");
			//saco el ultimo codigo
		}
		
		finally{
			sqlsesion.close();
			l4.lock();
		}
			
		return codS;
	}
	
	
	public ServicioBeanData consultarServicio(String codigo){
	l5.lock();
		ServicioBeanData servicioData=null;
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	try{
		servicioData= sqlsesion.selectOne("Data.venta.servicio.getPlantillaServicio",codigo);
	}
	finally{
		sqlsesion.close();
		l5.unlock();
	}
	return servicioData;
	}
	
	public ProveedorBeanData consultarProveedor(String codigo){
	l3.lock();
	ProveedorBeanData proveedorData=null;
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	try{
		proveedorData= sqlsesion.selectOne("Data.venta.servicio.getPlantillaProveedor",codigo);
	}
	finally{
		sqlsesion.close();
		l3.unlock();
	}
	return proveedorData;
	}
	

	public ProveedorBeanData BuscarProveedor(String nombre){
		l6.lock();
	ProveedorBeanData proveedorData=null;
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	try{
		proveedorData= sqlsesion.selectOne("Data.venta.servicio.getPlantillaMiniProveedor",nombre);
	}
	finally{
		sqlsesion.close();
		l6.unlock();
	}
	return proveedorData;
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
			throw CoException.set("Error: No se pudo eliminar el servicio, intente de nuevo", "SMVServicio?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	public String consultarLineaServicio(){
		l7.lock();
		String lineaData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			lineaData= sqlsesion.selectOne("Data.venta.servicio.getCodigoLinea");
		}
		finally{
			sqlsesion.close();
			l7.unlock();
		}
		return lineaData;
	}
	
	public void modificarServicio(ServicioBeanData servicio) throws CoException {
		l8.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
			sqlsesion.update("Data.venta.servicio.updateServicio",servicio);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: No se pudo modificar la plantilla intente de nuevo", "SMVServicio?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l8.unlock();
		}			
		return ;
	}
	
}
