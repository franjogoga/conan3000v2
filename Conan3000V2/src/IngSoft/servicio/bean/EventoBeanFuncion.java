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
		eventoData.setIdTipo(Integer.parseInt(request.getParameter("cmbTipo")));
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
			eventoData.setCodigo(Integer.parseInt((String)sqlsesion.selectOne("getNextCodigo")));
			sqlsesion.insert("insertPlantillaEvento",eventoData);
			sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
			
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
	
	public EventoBeanData consultarEvento(int codigo){
		EventoBeanData eventoData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			eventoData= sqlsesion.selectOne("getPLantillaEvento",codigo);
			//eventoData.setCodigo(Integer.parseInt((String)sqlsesion.selectOne("getNextCodigo")));
			//sqlsesion.insert("insertPlantillaEvento",eventoData);
			List<String> temp = null;
			temp=sqlsesion.selectList("getSedesId",codigo);
			eventoData.setIdSede(temp.toArray(new String[temp.size()]));
			temp=sqlsesion.selectList("getAmbientesId",codigo);
			eventoData.setIdAmbientes(temp.toArray(new String[temp.size()]));			
		}
		finally{
			sqlsesion.close();
		}
		return eventoData;
	}
	
	public Vector<SedeMiniBeanData> getSedes(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<SedeMiniBeanData> resultados=sqlsesion.selectList("searchSedeMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
	
	public Vector<AmbienteMiniBeanData> getAmbientes(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<AmbienteMiniBeanData> resultados=sqlsesion.selectList("searchAmbienteMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
	
	public Vector<TipoEventoMiniBeanData> getTipoEvento(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<TipoEventoMiniBeanData> resultados=sqlsesion.selectList("searchTipoEventoMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
}
