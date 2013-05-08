package IngSoft.venta.bean;

import java.util.List;
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
		//promocionData.setIdPromocion(request.getParameterValues(""));Integer.parseInt
		//promocionData.setIdSede(request.getParameterValues("cmbSedes"));
		//promocionData.setNombre((request.getParameter("cmbTipo")));
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
	
	public boolean eliminarPromocion(PromocionBeanData promocionData) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("deletePLantillaPromocion",promocionData.getCodigo());
			
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
	
	
			
	

	
	//public void modificarEvento(PromociconBeanData promocion,String[] antSede,String[] antAmb) throws CoException {
	
		
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
			
//		return ;
	
//	}
	
	
	
	public PromocionBeanData consultarPromocion(String codigo){
		PromocionBeanData PromocionData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			PromocionData= sqlsesion.selectOne("Data.venta.promocion.getPLantillaEvento",codigo);
			//eventoData.setCodigo(Integer.parseInt((String)sqlsesion.selectOne("getNextCodigo")));
			//sqlsesion.insert("insertPlantillaEvento",eventoData);
			//List<String> temp = null;
			//temp=sqlsesion.selectList("Data.servicio.evento.getSedesId",codigo);
			//eventoData.setIdSede(temp.toArray(new String[temp.size()]));
			//temp=sqlsesion.selectList("Data.servicio.evento.getAmbientesId",codigo);
			//eventoData.setIdAmbientes(temp.toArray(new String[temp.size()]));			
		}
		finally{
			sqlsesion.close();
		}
		return PromocionData;
	}
	
	/*public Vector<SedeMiniBeanData> getSedes(){
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
	}*/
}
