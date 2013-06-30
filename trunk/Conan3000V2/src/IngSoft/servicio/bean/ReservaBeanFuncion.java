package IngSoft.servicio.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
import IngSoft.general.bean.Conan3000Constantes;
import IngSoft.venta.bean.OrdenPagoBeanFunction;

public class ReservaBeanFuncion {
	static private ReservaBeanFuncion ReservaFuncion=null;
	private Lock lAB= new ReentrantLock();
	private Lock lAC= new ReentrantLock();
	private Lock lEB= new ReentrantLock();
	private Lock lEC= new ReentrantLock();
	
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
	   
	   public Vector<ReservaBungalowMiniBeanData> buscarReservasBungalow(String codSede,java.util.Date fecIni,String idsocio){
		   if(codSede==null || fecIni==null) return null;
		   Vector<ReservaBungalowMiniBeanData> resultados=null;
		   SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		   
		   try{
			   HashMap<String, Object> hashMap = new HashMap<String, Object>(); 
			   hashMap.put("codigo",codSede); 
			   hashMap.put("fecIni", fecIni);
			   hashMap.put("idsocio", idsocio);
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
	   public Vector<ReservaCanchaMiniBeanData> buscarReservasCanchas(String codSede, String codTipoCancha,java.util.Date fecIni,String idsocio){
		   if(codSede==null || fecIni==null || codTipoCancha==null) return null;
		   Vector<ReservaCanchaMiniBeanData> resultados=null;
		   SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		   try{
			   HashMap<String, Object> hashMap = new HashMap<String, Object>();
			   hashMap.put("codSede", codSede);
			   hashMap.put("codTipoCancha", codTipoCancha);
			   hashMap.put("fecIni", fecIni); 
			   hashMap.put("idsocio", idsocio);
			   hashMap.put("fecFin", Utils.fechaMas(fecIni, 6));
			   List<ReservaCanchaMiniBeanData> temp=sqlsesion.selectList("Data.servicio.reserva.searchCanchaxTipoxSede",hashMap);
			   resultados= new Vector<ReservaCanchaMiniBeanData>(temp);
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
			   temp=df.parse(source.get(i).substring(9, 19));
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
	   
	   public void agregarReservaBungalow(Vector<String> listareservas, String codSocio){
		   lAB.lock();
		   String nextcodigo;
		   SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		   try{
			   nextcodigo=sqlsesion.selectOne("Data.servicio.reserva.getNextCodigoB");
			   nextcodigo=nextcodigo==null?"RSB000000":nextcodigo;
			   SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy");
			   OrdenPagoBeanFunction orden=OrdenPagoBeanFunction.getInstance();
			   List<String> temp=sqlsesion.selectList("Data.servicio.reserva.verificarReservBungalow",listareservas);
			   listareservas.removeAll(new Vector<String>(temp));
			   int a= listareservas.size();
			   HashMap<String, Object> map=new HashMap<String, Object>();
			   Conan3000Constantes constantes=Conan3000Constantes.getInstance();
			   map.put("idsocio",codSocio);
			   double area=0;
			   for(int i=0;i<a;i++){
				   nextcodigo=this.generaSiguienteCodigo(nextcodigo);				   
				   map.put("idbungalow", listareservas.get(i).substring(0, 9)); 
				   map.put("idreservasbungalow", nextcodigo);
				   area=Double.parseDouble(listareservas.get(i).substring(19));
				   map.put("monto",constantes.getCostoXm2Bungalow()*area);
				   map.put("fecha",df.parseObject(listareservas.get(i).substring(9,19)));
				   sqlsesion.insert("Data.servicio.reserva.insertBungalowReserva",map);
				   sqlsesion.insert("Data.servicio.reserva.insertBungalowReservaFecha",map);
				   orden.agregarOrdenPago("RESERVABUNGALOW", nextcodigo, "", codSocio, constantes.getCostoXm2Bungalow()*area,new java.sql.Date(new java.util.Date().getTime()), new java.sql.Date(new java.util.Date().getTime()));
			   }
			   sqlsesion.commit();
			   
		   }catch(Exception e){
			   sqlsesion.rollback();
			   e.printStackTrace();			   
		   }
		   finally{			   
			   sqlsesion.close();
			   lAB.unlock();
			   
		   }
		   
	   }
	   public void agregarReservaCancha(Vector<String> listareservas, String codSocio){
		   lAC.lock();
		   String nextcodigo;
		   SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		   try{
			   nextcodigo=sqlsesion.selectOne("Data.servicio.reserva.getNextCodigoC");
			   nextcodigo=nextcodigo==null?"RSC000000":nextcodigo;
			   SimpleDateFormat df= new SimpleDateFormat("dd/MM/yyyy");
			   String horaIni=null;
			   OrdenPagoBeanFunction orden=OrdenPagoBeanFunction.getInstance();
			   List<String> temp=sqlsesion.selectList("Data.servicio.reserva.verificarReservCancha",listareservas);
			   listareservas.removeAll(new Vector<String>(temp));
			   int a= listareservas.size();
			   HashMap<String, Object> map=new HashMap<String, Object>();
			   Conan3000Constantes constantes=Conan3000Constantes.getInstance();
			   map.put("idsocio",codSocio);
			   for(int i=0;i<a;i++){
				   nextcodigo=this.generaSiguienteCodigo(nextcodigo);
				   horaIni=listareservas.get(i).substring(19);
				   map.put("idcancha", listareservas.get(i).substring(0, 9)); 
				   map.put("idreservascancha", nextcodigo);
				   map.put("fecha",df.parseObject(listareservas.get(i).substring(9,19)));
				   map.put("horaIni",horaIni);
				   map.put("monto",constantes.getCostoReservaCancha());
				   map.put("horaFin",Utils.addHora(horaIni, Conan3000Constantes.step.intValue()));
				   sqlsesion.insert("Data.servicio.reserva.insertCanchaReserva",map);
				   sqlsesion.insert("Data.servicio.reserva.insertCanchaReservaFecha",map);
				   
				   orden.agregarOrdenPago("RESERVACANCHA", nextcodigo, "", codSocio, constantes.getCostoReservaCancha(),new java.sql.Date(new java.util.Date().getTime()), new java.sql.Date(new java.util.Date().getTime()));
			   }
			   sqlsesion.commit();
			   
		   }catch(Exception e){
			   sqlsesion.rollback();
			   e.printStackTrace();			   
		   }
		   finally{			   
			   sqlsesion.close();
			   lAC.unlock();
			   
		   }
		   
		   
	   }
	   
	   public void eliminarResevaBungalow(Vector<String> listareservas){
		   lEB.lock();
		   SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		   try{			   
			   List<String> temp=sqlsesion.selectList("Data.servicio.reserva.getElimReservBungalowCod",listareservas);			   
			   sqlsesion.update("Data.servicio.reserva.eliminarReservaBungalow",temp);			   
			   sqlsesion.commit();
		   }
		   catch(Exception e){
			   sqlsesion.rollback();
			   e.printStackTrace();			   
		   }
		   finally{			   
			   sqlsesion.close();
			   lEB.unlock();
		   }
		   
	   }
	   public void eliminarResevaCancha(Vector<String> listareservas){
		   lEC.lock();
		   SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		   try{			   			   
			   List<String> temp=sqlsesion.selectList("Data.servicio.reserva.getElimReservCanchaCod",listareservas);			   
			   sqlsesion.update("Data.servicio.reserva.eliminarReservaCancha",temp);			   
			   sqlsesion.commit();
		   }
		   catch(Exception e){
			   sqlsesion.rollback();
			   e.printStackTrace();			   
		   }
		   finally{			   
			   sqlsesion.close();	
			   lEC.unlock();
		   }
		   
	   }
	   
	   public String generaSiguienteCodigo(String actual){
		   String next=null;
		   if(Integer.parseInt(actual.substring(3))>0){
				int cod= Integer.parseInt(actual.substring(3))+1;
				String defecto= "000000";
				String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
				
				next= actual.substring(0,3).concat(temp);
				}
				else next=actual.substring(0, 3).concat("000001");
		   return next;		   
	   }
	   
	   public Vector<ServicioAdicionalBeanData> getServicios(String codigo){		  
		   SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<ServicioAdicionalBeanData> resultados=sqlsesion.selectList("Data.servicio.reserva.getServiciosAdicionales",codigo);
			sqlsesion.close();
			return new Vector<>(resultados);
	   }
}
