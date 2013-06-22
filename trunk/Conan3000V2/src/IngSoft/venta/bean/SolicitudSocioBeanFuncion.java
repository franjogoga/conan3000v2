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

public class SolicitudSocioBeanFuncion {

static private SolicitudSocioBeanFuncion SolicitudSocioFuncion=null;
	
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static SolicitudSocioBeanFuncion getInstanceS(){
	       if(SolicitudSocioFuncion==null) SolicitudSocioFuncion= new SolicitudSocioBeanFuncion();
	       
	       return SolicitudSocioFuncion;
	   }
	   
	   private SolicitudSocioBeanFuncion() {}
	
	public SolicitudsocioBeanData crearSolicitudSocio(HttpServletRequest request, HttpServletResponse response){
		
		SolicitudsocioBeanData SolicitudSocioData= new SolicitudsocioBeanData();

		try{	
			
			SolicitudSocioData.setNombres(request.getParameter("txtNombres"));
			SolicitudSocioData.setApellidoMaterno(request.getParameter("txtApellidoM"));
			SolicitudSocioData.setApellidoPaterno(request.getParameter("txtApellidoP"));
			SolicitudSocioData.setCodDistrito(request.getParameter("cmdDistrito"));
			SolicitudSocioData.setDireccion(request.getParameter("txtDireccion"));
			SolicitudSocioData.setFechaNacimiento(new Date(DF.parse(request.getParameter("fFechaN")).getTime()));
			SolicitudSocioData.setFechaRegistro(new Date(DF.parse(request.getParameter("fFechaR")).getTime()));
			SolicitudSocioData.setObservaciones(request.getParameter("txtObservaciones"));

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return SolicitudSocioData;		
	} 
	
	public boolean agregarSolicitudSocio(SolicitudsocioBeanData solicitudSocioData) throws CoException {
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.solicitudsocio.getNextCodigo");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			solicitudSocioData.setCodSolicitudIngreso(codigo.substring(0,3).concat(temp));}
			else solicitudSocioData.setCodSolicitudIngreso("SLS000001");

			sqlsesion.insert("Data.venta.solicitudsocio.insertSolicitud",solicitudSocioData);

			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de solicitud repetido", "SMVSolicitudSocio?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
			
		return resultado;
	}
	
	
	public SolicitudsocioBeanData consultarSolicitud(String codigo){
	SolicitudsocioBeanData solicitudData=null;
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	try{
		solicitudData= sqlsesion.selectOne("Data.venta.solicitudsocio.getPlantillaSolicitud",codigo);
	}
	finally{
		sqlsesion.close();
	}
	return solicitudData;
	}
	

	public ProveedorBeanData BuscarProveedor(String nombre){
	ProveedorBeanData proveedorData=null;
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	try{
		proveedorData= sqlsesion.selectOne("Data.venta.servicio.getPlantillaMiniProveedor",nombre);
	}
	finally{
		sqlsesion.close();
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
	
	public void modificarSolicitud(SolicitudsocioBeanData solicitud) throws CoException {
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
			sqlsesion.update("Data.venta.solicitudsocio.updateSolicitud",solicitud);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: No se pudo modificar la plantilla intente de nuevo", "SMVSolicitudSocio?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}			
		return ;
	}
	
	
}
