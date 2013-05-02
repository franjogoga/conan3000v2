package IngSoft.servicio.bean;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class EventoBeanFuncion {

	public EventoBeanData crearEvento(HttpServletRequest request, HttpServletResponse response){
		EventoBeanData eventoData= new EventoBeanData();
		eventoData.setCodigo(Integer.parseInt(request.getParameter("")));
		try{
			
		
		}
		catch(Exception e){
		e.printStackTrace();	
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
