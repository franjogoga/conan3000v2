package IngSoft.venta.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
@ApplicationScoped
public class PersonaMiniBeanFuncion {

	static private PersonaMiniBeanFuncion PersonaFuncion=null;
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	private Lock l= new ReentrantLock(); 
	private Lock l1= new ReentrantLock(); 
	private Lock l2= new ReentrantLock();
	private Lock l3= new ReentrantLock(); 
	
	public static PersonaMiniBeanFuncion getInstanceP(){
	       if(PersonaFuncion==null) PersonaFuncion= new PersonaMiniBeanFuncion();
	       
	       return PersonaFuncion;
	}
	
	public PersonaMiniBeanData crearPersona(HttpServletRequest request, HttpServletResponse response){
		PersonaMiniBeanData personaData= new PersonaMiniBeanData();
		try{		

		personaData.setNombres(request.getParameter("txtNombres"));
		personaData.setApellidoMaterno(request.getParameter("txtApellidoMaterno"));
		personaData.setApellidoPaterno(request.getParameter("txtApellidoPaterno"));
		personaData.setNumeroDocumento(Long.parseLong(request.getParameter("txtNumeroDocumento")));
		personaData.setTipoDocumento(request.getParameter("cmbTipoDocumento"));
		//if (request.getParameter("rButton")!=null){
			//String tipoDocumento;
			//tipoDocumento=request.getParameter("rButton");
		//personaData.setTipoDocumento(tipoDocumento);}
		
		personaData.setFechaNacimiento(new Date(DF.parse(request.getParameter("fFechaNacimiento")).getTime()));
		
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return personaData;		
	} 
	
	public boolean agregarPersona(PersonaMiniBeanData personaData) throws CoException {
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.socio.getNextCodigo3");
			if(codigo!=null){
			//int cod= Integer.parseInt(codigo.substring(3))+1;
			//String defecto= "000000";
			
			//String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			//String codigoM=;
					
			personaData.setCodigo(codigo);
			}
			else personaData.setCodigo("SOC000001");
			
			sqlsesion.insert("Data.venta.socio.insertPersona",personaData);
			
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
				String defecto= "000000";
				String tempU= defecto.substring(0, defecto.length()-String.valueOf(codU).length()).concat(String.valueOf(codU));
			
			usuarioData.setCodUsuario(codUsuario.substring(0,3).concat(tempU));}
			else usuarioData.setCodUsuario("USU000001");
			
			//inserto el nombreusuario y contraseña
			sqlsesion.insert("Data.venta.socio.insertUsuario", usuarioData);
			
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
	
	public boolean agregarPersonaTraslado(PersonaMiniBeanData personaData) throws CoException {
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
					
			personaData.setCodigo(codigo.substring(0,3).concat(temp));}	
			else personaData.setCodigo("SOC000001");
			
			sqlsesion.insert("Data.venta.socio.insertPersona",personaData);
			
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
				String defecto= "000000";
				String tempU= defecto.substring(0, defecto.length()-String.valueOf(codU).length()).concat(String.valueOf(codU));
			
			usuarioData.setCodUsuario(codUsuario.substring(0,3).concat(tempU));}
			else usuarioData.setCodUsuario("USU000001");
			
			//inserto el nombreusuario y contraseña
			sqlsesion.insert("Data.venta.socio.insertUsuario", usuarioData);
			
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
	
	public void modificarPersona(PersonaMiniBeanData persona) throws CoException {
		l1.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
			sqlsesion.update("Data.venta.socio.updatePersona",persona);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: No se pudo modificar la plantilla intente de nuevo", "SMVSocio?accion=Modificar&tipo=1");
					}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l1.unlock();
		}			
		return ;
	}
	
	
	public PersonaMiniBeanData consultarPersona(String codigo){
		l2.lock();
		PersonaMiniBeanData personaData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			personaData= sqlsesion.selectOne("Data.venta.socio.getPlantillaPersona",codigo);
		}
		finally{
			sqlsesion.close();
			l2.unlock();
		}
		return personaData;
	}
	
	public PersonaMiniBeanData consultarPersonaSocio(String codigo){
		l3.lock();
		PersonaMiniBeanData personaData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			personaData= sqlsesion.selectOne("Data.venta.socio.getPlantillaPersonaSocio",codigo);
		}
		finally{
			sqlsesion.close();
			l3.unlock();
		}
		return personaData;
	}
		
}
