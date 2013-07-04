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
public class ProveedorBeanFuncion {

	static private ProveedorBeanFuncion ProveedorFuncion=null;
	
	private Lock l= new ReentrantLock();     
	private Lock l1= new ReentrantLock();
	private Lock l2= new ReentrantLock();
	private Lock l3= new ReentrantLock();
	private Lock l4= new ReentrantLock();
	private Lock l5= new ReentrantLock();
	
	//SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static ProveedorBeanFuncion getInstanceS(){
	       if(ProveedorFuncion==null) ProveedorFuncion= new ProveedorBeanFuncion();
	       
	       return ProveedorFuncion;
	   }
	   
	   private ProveedorBeanFuncion() {}
	
	public ProveedorBeanData crearProveedor(HttpServletRequest request, HttpServletResponse response){
		ProveedorBeanData proveedorData= new ProveedorBeanData();
		try{		
			proveedorData.setApMaterno(request.getParameter("txtApMaterno"));
			proveedorData.setCorreo(request.getParameter("txtCorreo"));
			proveedorData.setDireccion(request.getParameter("txtDireccion"));

			proveedorData.setTelefono(Long.parseLong(request.getParameter("txtTelefono")));
			proveedorData.setRazonSocial(request.getParameter("txtRazonSocial"));
			proveedorData.setRuc(Long.parseLong(request.getParameter("txtRuc")));

			proveedorData.setCorreo(request.getParameter("txtCorreo"));
			proveedorData.setDistrito(request.getParameter("cmdDistrito"));
			proveedorData.setProvincia((request.getParameter("cmdProvincia")));
			proveedorData.setDepartamento((request.getParameter("cmdDepartamento")));
			proveedorData.setNomContacto(request.getParameter("txtNombre"));
		    proveedorData.setApPaterno(request.getParameter("txtApPaterno"));
			proveedorData.setNumDoc(Long.parseLong(request.getParameter("txtNumDoc")));

			if (request.getParameter("rButton")!=null){
				String tipo;
				tipo=request.getParameter("rButton");
				proveedorData.setTipoDoc(tipo);}

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return proveedorData;		
	} 
	
	public boolean agregarProveedor(ProveedorBeanData proveedorData) throws CoException {
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.proveedor.getNextCodigo4");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			//String codigoM=;
			
			proveedorData.setIdProveedor(codigo.substring(0,3).concat(temp));}
			else proveedorData.setIdProveedor("PRO000001");

			sqlsesion.insert("Data.venta.proveedor.insertProveedor",proveedorData);
		
			
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
	
	public Vector<DistritoMiniBeanData> getDistritos(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<DistritoMiniBeanData> resultados=sqlsesion.selectList("Data.venta.proveedor.searchDistritoMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
	
	
	public boolean eliminarProveedor(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.venta.proveedor.deleteProveedor",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: No se pudo eliminar la plantilla intente de nuevo", "SMVProveedor?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
			
	public ProveedorBeanData consultarProveedor(String codigo){
		l2.lock();
		ProveedorBeanData proveedorData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			proveedorData= sqlsesion.selectOne("Data.venta.proveedor.getPlantillaProveedor",codigo);
		}
		finally{
			sqlsesion.close();
			l2.unlock();
		}
		//BUSCA PROVEEDORES EN OTRAS TABLAS
		sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ProveedorBeanData> resultadosV=null;
		try{		
			List<ProveedorBeanData> resultados = sqlsesion.selectList("Data.venta.proveedor.searchProveedorOtros",codigo);
			resultadosV= new Vector<>(resultados);
		}
		finally{
			sqlsesion.close();
		}
		//COMPROBAR EL TAMA�ANO PARA SETEAR EL FLAG
		if(resultadosV.size()==0){
			proveedorData.setFlag(0);
		}
		else {
			proveedorData.setFlag(1);
		}
		return proveedorData;
	}


	public void modificarProveedor(ProveedorBeanData proveedor) throws CoException {
		l3.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
		//	System.out.println("Ambs="+mods.size());
			sqlsesion.update("Data.venta.proveedor.updateProveedor",proveedor);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: No se pudo modificar la plantilla intente de nuevo", "SMVProveedor?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l3.unlock();
		}			
		return ;
	}
	
	
}
