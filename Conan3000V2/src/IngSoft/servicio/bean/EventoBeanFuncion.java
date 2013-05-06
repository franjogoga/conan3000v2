package IngSoft.servicio.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class EventoBeanFuncion {	
	
	static private EventoBeanFuncion EventoFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static EventoBeanFuncion getInstance(){
	       if(EventoFuncion==null) EventoFuncion= new EventoBeanFuncion();
	       
	       return EventoFuncion;
	   }
	   
	   private EventoBeanFuncion() {}
	
	public EventoBeanData crearEvento(HttpServletRequest request, HttpServletResponse response){
		EventoBeanData eventoData= new EventoBeanData();
		try{		
		eventoData.setIdAmbientes(request.getParameterValues("cmbAmbientes"));
		eventoData.setIdSede(request.getParameterValues("cmbSedes"));
		eventoData.setIdTipo(request.getParameter("cmbTipo"));
		eventoData.setNombre(request.getParameter("txtNombreEvento"));
		eventoData.setLimiteInicio(new Date(DF.parse(request.getParameter("fFecIncio")+"/0000").getTime()));
		eventoData.setLimiteFin(new Date(DF.parse(request.getParameter("fFecFin")+"/0000").getTime()));
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return eventoData;		
	} 
	
	public boolean agregarEvento(EventoBeanData eventoData) throws CoException {
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			String codigo= (String)sqlsesion.selectOne("Data.servicio.evento.getNextCodigo");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			eventoData.setCodigo(codigo.substring(0,3).concat(temp));}
			else eventoData.setCodigo("PEV000001");
			sqlsesion.insert("Data.servicio.evento.insertPlantillaEvento",eventoData);
			sqlsesion.insert("Data.servicio.evento.insertPlantillaEventoSedes",eventoData);
			sqlsesion.insert("Data.servicio.evento.insertPlantillaEventoAmbiente",eventoData);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nombre de evento repetido", "SMSEvento?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
			
		return resultado;
	}
	
	public boolean eliminarEvento(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.servicio.evento.deletePLantillaEvento",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la plantilla intente de nuevo", "SMSEvento?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	public void modificarEvento(EventoBeanData evento,String[] antSede,String[] antAmb) throws CoException {
			
		
		
//		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
//		try{
//		
//		
//			
//		
//		}
//		catch(Exception a)		
//		{sqlsesion.rollback();
//		a.printStackTrace();
//			throw CoException.set("Error: No se pudo modificar la plantilla intente de nuevo", "SMSEvento?accion=Modificar&tipo=1");
//			
//		}
//		
//		finally{
//			sqlsesion.commit();
//			sqlsesion.close();					
//		}
			
		return ;
	}
	public EventoBeanData consultarEvento(String codigo){
		EventoBeanData eventoData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			eventoData= sqlsesion.selectOne("Data.servicio.evento.getPLantillaEvento",codigo);
			//eventoData.setCodigo(Integer.parseInt((String)sqlsesion.selectOne("getNextCodigo")));
			//sqlsesion.insert("insertPlantillaEvento",eventoData);
			List<String> temp = null;
			temp=sqlsesion.selectList("Data.servicio.evento.getSedesId",codigo);
			eventoData.setIdSede(temp.toArray(new String[temp.size()]));
			temp=sqlsesion.selectList("Data.servicio.evento.getAmbientesId",codigo);
			eventoData.setIdAmbientes(temp.toArray(new String[temp.size()]));			
		}
		finally{
			sqlsesion.close();
		}
		return eventoData;
	}
	
	public Vector<SedeMiniBeanData> getSedes(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<SedeMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchSedeMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
	
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
	}
}
