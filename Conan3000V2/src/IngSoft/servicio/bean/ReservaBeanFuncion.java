package IngSoft.servicio.bean;

import java.util.List;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.MyBatisSesion;

public class ReservaBeanFuncion {
	static private ReservaBeanFuncion ReservaFuncion=null;
	
	 public static ReservaBeanFuncion getInstance(){
	       if(ReservaFuncion==null) ReservaFuncion= new ReservaBeanFuncion();
	       
	       return ReservaFuncion;
	   }
	   
	   private ReservaBeanFuncion() {}
	   
	   public Vector<SedeMiniBeanData> getSedes(){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<SedeMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchSedeMini");
			sqlsesion.close();
			return new Vector<>(resultados);
		}  
	   
	   public Vector<BungalowMiniBeanData> getBungalowsXSede(String codSede){
		   SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<BungalowMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.reserva.searchBungalowxSede",codSede);
			sqlsesion.close();
			return new Vector<>(resultados);		   
	   }
}
