package IngSoft.servicio.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
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
			   resultados.trimToSize();
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
	   
	   public Vector<String> filtrarReservaXFechas(Vector<String> source, java.util.Date fecIni, java.util.Date fecFin){
		   Vector<String> resultados= new Vector<String>();
		   try{
		   int a=source.size();
		   SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy");			   
		   Date temp;
		   for(int i=0;i<a;i++){
			   temp=df.parse(source.get(i).substring(9));
			   if(temp.compareTo(fecIni)>=0 && temp.compareTo(fecFin)<=0) resultados.add(source.get(i));
			   
		   }
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   resultados.trimToSize();
		   return resultados;
	   }
	   
	   public String confirmarSocio(String docId){
		   String resultado=null;
		   SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		   try{
			   HashMap<String, String> temp=sqlsesion.selectOne("Data.servicio.reserva.confirmarSocio",docId);
			   resultado=temp.get("respuesta");
		   }
		   catch(Exception e){
			   e.printStackTrace();			   
		   }
		   finally{
			   sqlsesion.close();
		   }
		   return resultado;
	   }
	   
	   public void agregarReserva(){
		   
		   
	   }
}
