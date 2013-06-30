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

public class SocioBeanFuncion {

	static private SocioBeanFuncion SocioFuncion=null;
	
	private Lock l= new ReentrantLock();     
	//SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static SocioBeanFuncion getInstanceS(){
	       if(SocioFuncion==null) SocioFuncion= new SocioBeanFuncion();
	       
	       return SocioFuncion;
	   }
	   
	   private SocioBeanFuncion() {}
	
	public SocioBeanData crearSocio(HttpServletRequest request, HttpServletResponse response){
		SocioBeanData socioData= new SocioBeanData();
		try{		
		
		socioData.setIdSolicitud(request.getParameter("txtSolicitud"));
		socioData.setDireccion(request.getParameter("txtDireccion"));
		socioData.setCorreoElectronico(request.getParameter("txtCorreoElectronico"));
		socioData.setTelefonoFijo(Long.parseLong(request.getParameter("txtTelefonoFijo")));
		
		
		socioData.setTelefonoCelular(Long.parseLong(request.getParameter("txtTelefonoCelular")));
		socioData.setIdDistrito((request.getParameter("cmdDistrito")));
		
		MembresiaBeanFunction membresiaFuncion=MembresiaBeanFunction.getInstance();
		
		socioData.setIdMembresia(membresiaFuncion.consultarMembresiaMax());
		socioData.setCodigo2(request.getParameter("txtIdMembresiaAntiguo"));

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return socioData;		
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
			//aca validar si el get te da null y hacer otro insert !!!!!!
			sqlsesion.insert("Data.venta.socio.insertSocio",socioData);
			
			String codSol=socioData.getIdSolicitud();
			//saco un codigo por aca
			sqlsesion.update("Data.venta.socio.updateSolicitud", codSol);
			
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
	
	
	public SocioBeanData consultarSocio(String codigo){
	SocioBeanData socioData=null;
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	try{
		socioData= sqlsesion.selectOne("Data.venta.socio.getPlantillaSocio",codigo);
	}
	finally{
		sqlsesion.close();
	}
	return socioData;
	}
	
	public boolean eliminarSocio(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.venta.socio.deleteSocio",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la plantilla intente de nuevo", "SMVSocio?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	

	
	
	public Vector<DistritoMiniBeanData> getDistritos(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<DistritoMiniBeanData> resultados=sqlsesion.selectList("Data.venta.socio.searchDistritoMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
	
	public void modificarSocio(SocioBeanData socio) throws CoException {
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
			sqlsesion.update("Data.venta.socio.updateSocio",socio);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar la plantilla intente de nuevo", "SMVSocio?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}			
		return ;
	}
	
}
