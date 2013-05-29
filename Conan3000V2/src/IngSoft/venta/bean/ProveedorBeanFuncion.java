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
			proveedorData.setProvincia((request.getParameter("cmdProvincia")));
			proveedorData.setDepartamento((request.getParameter("cmdDepartamento")));
			proveedorData.setNomContacto(request.getParameter("txtNombre"));
			proveedorData.setApMaterno(request.getParameter("txtApMaterno"));
			proveedorData.setApPaterno(request.getParameter("txtApPaterno"));
			proveedorData.setTipoDoc(request.getParameter("cmbTipoDoc"));
			proveedorData.setNumDoc(request.getParameter("txtNumDoc"));
			
		
		ProveedorBeanFuncion proveedorFuncion=ProveedorBeanFuncion.getInstanceS();

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
			//sqlsesion.insert("Data.servicio.evento.insertPlantillaEventoSedes",eventoData);
			//sqlsesion.insert("Data.servicio.evento.insertPlantillaEventoAmbiente",eventoData);
			
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
	
	/*
	public Vector<AmbienteMiniBeanData> getAmbientes(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<AmbienteMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchAmbienteMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
	
	public Vector<TipoEventoMiniBeanData> getTipoEvento(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<TipoEventoMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchTipoEventoMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}*/
}
