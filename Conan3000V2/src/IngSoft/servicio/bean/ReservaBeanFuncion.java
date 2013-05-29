package IngSoft.servicio.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
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
	   
	   public Vector<ReservaBungalowMiniBeanData> buscarReservasBungalow(String codSede,java.util.Date fecIni){
		   if(codSede==null && fecIni==null) return null;
		   Vector<ReservaBungalowMiniBeanData> resultados=null;
		   SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		   
		   try{
			   HashMap<String, Object> hashMap = new HashMap<String, Object>(); 
			   hashMap.put("codigo",codSede); 
			   hashMap.put("fecIni", fecIni); 
			   hashMap.put("fecFin", Utils.fechaMas(fecIni, 6)); 
			   List<ReservaBungalowMiniBeanData> temp=sqlsesion.selectList("Data.servicio.reserva.searchBungalowxSede",hashMap);
			   resultados= new Vector<ReservaBungalowMiniBeanData>(temp);
		   }
		   catch(Exception e){
			   e.printStackTrace();			   
		   }
		   finally{
			   sqlsesion.close();
		   }
		   
		   return resultados;
	   }
	   public ReservaBugalowBeanData actualizarReservasPendientes(ReservaBugalowBeanData original,ReservaBugalowBeanData nuevo, java.util.Date fecIni){
		   
		   return null;
	   }
}
