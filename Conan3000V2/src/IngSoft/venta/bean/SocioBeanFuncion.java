package IngSoft.venta.bean;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.administracion.bean.PersonaBeanData;
import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class SocioBeanFuncion {

	static private SocioBeanFuncion SocioFuncion=null;
	
	private Lock l= new ReentrantLock();     
	private Lock l1= new ReentrantLock();     
	private Lock l2= new ReentrantLock();     
    
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
	
	public synchronized boolean agregarSocio(SocioBeanData socioData,PersonaMiniBeanData personaData) throws CoException {
		boolean resultado=false;		
		
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
			
			String codigoP= (String)sqlsesion.selectOne("Data.venta.socio.getNextCodigo3");
			if(codigoP!=null){
			//int cod= Integer.parseInt(codigo.substring(3))+1;
			//String defecto= "000000";
			
			//String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			//String codigoM=;
					
			personaData.setCodigo(codigoP);
			}
			else personaData.setCodigo("SOC000001");
			
			sqlsesion.insert("Data.venta.socio.insertPersona",personaData);
			//aca validar si el get te da null y hacer otro insert !!!!!!
			sqlsesion.insert("Data.venta.socio.insertSocio",socioData);
			
			//aca creo el usuario y password
			//PersonaMiniBeanData personaData2=sqlsesion.selectOne("Data.venta.socio.getPlantillaPersona", codigo);
			
			long dni=personaData.getNumeroDocumento();
			String strLong = Long.toString(dni);
			String ceros="";
			int cantDni=strLong.length();
			
			for(int i=0;i<11-cantDni;i++){
				ceros='0'+ceros;
			}
			String nombUsuario=codigo.substring(0,1).concat(ceros).concat(strLong);
			//genero la password
			String contraseña=Integer.toString((int)(Math.random()*(999999-100000+1)+999999));//contraseña numero aleatorio rango 100000 a 999999, lo raro es que sale una contraseña de 7 digitos
			UsuarioBeanData usuarioData=new UsuarioBeanData();
			usuarioData.setCodSocio(codigo);
			usuarioData.setNombUsuario(nombUsuario);
			usuarioData.setContraseña(contraseña);
			
			//busco codigo de usuario y genero el siguiente
			String codUsuario= (String)sqlsesion.selectOne("Data.venta.socio.getNextCodigoU");
			if(codUsuario!=null){
				int codU= Integer.parseInt(codUsuario.substring(3))+1;
				String defectoP= "000000";
				String tempU= defectoP.substring(0, defectoP.length()-String.valueOf(codU).length()).concat(String.valueOf(codU));
			
			usuarioData.setCodUsuario(codUsuario.substring(0,3).concat(tempU));}
			else usuarioData.setCodUsuario("USU000001");
			
			//inserto el nombreusuario y contraseña
			sqlsesion.insert("Data.venta.socio.insertUsuario", usuarioData);

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
								
		}
			
		return resultado;
	}
	
	public synchronized boolean agregarSocioTraslado(SocioBeanData socioData) throws CoException {
		boolean resultado=false;		
		
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
			
			//busco la membresia
			//String codMembresia=socioData.getIdMembresia();
			//String codAntiguo=sqlsesion.selectOne("Data.venta.socio.getCodigoAntiguo",codMembresia);
			//String codSolic=sqlsesion.selectOne("Data.venta.socio.getCodSolic", codAntiguo);
			
			//socioData.setIdSolicitud(codSolic);
			//aca validar si el get te da null y hacer otro insert !!!!!!
			sqlsesion.insert("Data.venta.socio.insertSocio2",socioData);
			
			//String codSol=socioData.getIdSolicitud();
			//saco un codigo por aca
			//sqlsesion.update("Data.venta.socio.updateSolicitud", codSol);
			
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
							
		}
			
		return resultado;
	}
	
	
	public synchronized SocioBeanData consultarSocio(String codigo){
	
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
	
	public synchronized void modificarSocio(SocioBeanData socio) throws CoException {
	
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
