package IngSoft.venta.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
import IngSoft.servicio.bean.EventoBeanData;
import IngSoft.servicio.bean.ModificacionesEventoBeanData;

public class PromocionBeanFuncion {
	static private PromocionBeanFuncion PromocionFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static PromocionBeanFuncion getInstance(){
	       if(PromocionFuncion==null) PromocionFuncion= new PromocionBeanFuncion();
	       
	       return PromocionFuncion;
	   }
	   
	   private PromocionBeanFuncion() {}
	
	public PromocionBeanData crearPromocion(HttpServletRequest request, HttpServletResponse response){
		PromocionBeanData promocionData= new PromocionBeanData();
		try{		
	
		promocionData.setNombre(request.getParameter("txtNombrePromocion"));
		promocionData.setFechaInicio(new Date(DF.parse(request.getParameter("fFechInicio")).getTime()));
		promocionData.setFechafin(new Date(DF.parse(request.getParameter("fFechFin")).getTime()));
		promocionData.setDescripcion(request.getParameter("txtDescripcion"));
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return promocionData;		
	} 
	
	public boolean agregarPromocion(PromocionBeanData promocionData) throws CoException {
		
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.promocion.getNextCodigo2");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			promocionData.setIdPromocion(codigo.substring(0,3).concat(temp));}
			else promocionData.setIdPromocion("PRO000001");
			//insertPromocion esta en promocion mapper
			sqlsesion.insert("insertPromocion",promocionData);
			//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de promocion repetido", "SMVPromocion?accion=Agregar&tipo=1");
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	public boolean eliminarPromocion(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.venta.promocion.deletePromocion",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la plantilla intente de nuevo", "SMVPromocion?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
			
	public PromocionBeanData consultarPromocion(String codigo){
		PromocionBeanData promocionData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			promocionData= sqlsesion.selectOne("Data.venta.promocion.getPlantillaPromocion",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return promocionData;
	}

	private Vector<ModificacionesEventoBeanData> generaListaCambios(String[] ant , String[] nue ,String cod){
		Vector<ModificacionesEventoBeanData> mods=new Vector<ModificacionesEventoBeanData>();
		Vector<String> antV= new Vector<String>(Arrays.asList(ant));
		Vector<String> nueV= new Vector<String>(Arrays.asList(nue));
		antV.remove("");
		nueV.remove("");
		for(int i=0;i<antV.size();i++){
			if(nueV.remove(antV.get(i))){
			antV.remove(i);
			i--;}
		}
		for(int i=0;i<nueV.size();i++){
			if(antV.remove(nueV.get(i))){
				nueV.remove(i);
				i--;
			}
			
		}
		while(true){
			if(antV.size()==0 && nueV.size()==0) break;
			ModificacionesEventoBeanData cambio= new ModificacionesEventoBeanData();
			if(antV.size()==0 || "".equals((String)antV.get(0)) ) {
				cambio.setCambio("I");
				cambio.setNuevo((String)nueV.get(0));
				nueV.remove(nueV.get(0));
				cambio.setCodigo(cod);
				mods.add(cambio);
				continue;					
				}
			if(nueV.size()==0 || "".equals((String)nueV.get(0)) ) {
				cambio.setCambio("D");
				cambio.setAntiguo((String)antV.get(0));
				antV.remove(antV.get(0));
				cambio.setCodigo(cod);
				mods.add(cambio);
				continue;}					
			else {
			cambio.setCambio("U");
			cambio.setAntiguo((String)antV.get(0));
			cambio.setNuevo((String)nueV.get(0));
			antV.remove(antV.get(0));
			nueV.remove(nueV.get(0));
			cambio.setCodigo(cod);
			mods.add(cambio);
			continue;
			}
						
		}
	
	return mods;
}

	/*public void modificarPromocion(PromocionBeanData promocion,String[] antSede,String[] antAmb) throws CoException {
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			Vector<ModificacionesPromocionBeanData> mods;
			mods= this.generaListaCambios(antSede, promocion.getCodigo(),//promocion.getCodigo());
			
			for(int i=0;i<mods.size();i++){
				if("I".equals(mods.get(i).getCambio())) sqlsesion.insert("Data.servicio.evento.insertPlantillaEventoSedesUpdate",(ModificacionesPromocionBeanData)mods.get(i));
				if("U".equals(mods.get(i).getCambio())) sqlsesion.delete("Data.servicio.evento.updatePlantillaEventoSedes",(ModificacionesPromocionBeanData)mods.get(i));	
				if("D".equals(mods.get(i).getCambio())) sqlsesion.update("Data.servicio.evento.deletePlantillaEventoSede",(ModificacionesPromocionBeanData)mods.get(i));	
			}		
		//	System.out.println("Sedes="+mods.size());
			mods= this.generaListaCambios(antAmb, evento.getIdAmbientes(),evento.getCodigo());
			for(int i=0;i<mods.size();i++){
				if("I".equals(mods.get(i).getCambio())) sqlsesion.insert("Data.servicio.evento.insertPlantillaEventoAmbienteUpdate",(ModificacionesEventoBeanData)mods.get(i));
				if("U".equals(mods.get(i).getCambio())) sqlsesion.delete("Data.servicio.evento.updatePlantillaEventoAmbiente",(ModificacionesEventoBeanData)mods.get(i));	
				if("D".equals(mods.get(i).getCambio())) sqlsesion.update("Data.servicio.evento.deletePlantillaEventoAmbiente",(ModificacionesEventoBeanData)mods.get(i));	
			}
		//	System.out.println("Ambs="+mods.size());
			sqlsesion.update("Data.servicio.evento.updatePLantillaEvento",evento);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar la plantilla intente de nuevo", "SMSEvento?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}			
		return ;
	}*/
	
}
