package IngSoft.venta.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class PersonaMiniBeanFuncion {

	static private PersonaMiniBeanFuncion PersonaFuncion=null;
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	private Lock l= new ReentrantLock(); 
	public static PersonaMiniBeanFuncion getInstanceP(){
	       if(PersonaFuncion==null) PersonaFuncion= new PersonaMiniBeanFuncion();
	       
	       return PersonaFuncion;
	}
	
	public PersonaMiniBeanData crearPersona(HttpServletRequest request, HttpServletResponse response){
		PersonaMiniBeanData personaData= new PersonaMiniBeanData();
		try{		
		//socioData.setNombres(request.getParameter("txtNombres"));
		personaData.setNombres(request.getParameter("txtNombres"));
		personaData.setApellidoMaterno(request.getParameter("txtApellidoMaterno"));
		personaData.setApellidoPaterno(request.getParameter("txtApellidoPaterno"));
		personaData.setNumeroDocumento(Long.parseLong(request.getParameter("txtNumeroDocumento")));
		
		if (request.getParameter("rButton")!=null){
			String tipoDocumento;
			tipoDocumento=request.getParameter("rButton");
		
		personaData.setTipoDocumento(tipoDocumento);}

		personaData.setFechaNacimiento(new Date(DF.parse(request.getParameter("fFechaNacimiento")).getTime()));
		
		//socioData.setLimiteInicio(new Date(DF.parse(request.getParameter("fFecIncio")+"/0000").getTime()));
		//socioData.setLimiteFin(new Date(DF.parse(request.getParameter("fFecFin")+"/0000").getTime()));
		
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
			
			personaData.setCodigo(codigo);}
			else personaData.setCodigo("SOC000001");
			
			sqlsesion.insert("Data.venta.socio.insertPersona",personaData);
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
	
	
	public PersonaMiniBeanData consultarPersona(String codigo){
		PersonaMiniBeanData personaData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			personaData= sqlsesion.selectOne("Data.venta.socio.getPlantillaPersona",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return personaData;
	}
		
}
