package IngSoft.venta.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
import IngSoft.venta.bean.TrasladoBeanData;

public class TrasladoBeanFuncion {
	static private TrasladoBeanFuncion TrasladoFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static TrasladoBeanFuncion getInstance(){
	       if(TrasladoFuncion==null) TrasladoFuncion= new TrasladoBeanFuncion();
	       return TrasladoFuncion;
	   }
	   
	   private TrasladoBeanFuncion() {}
	
	public TrasladoBeanData crearTraslado(HttpServletRequest request, HttpServletResponse response){
		
		TrasladoBeanData trasladoData= new TrasladoBeanData();
		trasladoData.setIdmembresiantiguo(request.getParameter("txtIdMembresiaAntiguo"));
		trasladoData.setIdmembresianuevo(request.getParameter("txtIdMembresiaNuevo"));
		
		try{			
		
			
			trasladoData.setCodigo(request.getParameter("txtIdNuevoSocio"));
		//trasladoData.setIdMembresiaNuevo("MEM000032");
		trasladoData.setFecha(new Date(DF.parse(request.getParameter("fFechaInicio")).getTime()));
		trasladoData.setFechafin(new Date(DF.parse(request.getParameter("fFechaFin")).getTime()));
		trasladoData.setParentesco(request.getParameter("cmbParentesco"));
		trasladoData.setMonto(Double.parseDouble(request.getParameter("txtMonto")));
	
		         	
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return trasladoData;		
	} 
	
	public boolean agregarTraslado(TrasladoBeanData trasladoData) throws CoException {
		
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{

			MembresiaBeanData membresiaData=new MembresiaBeanData();
			String codigoNuevo= (String)sqlsesion.selectOne("Data.venta.traslado.getNextCodigoT");
			if(codigoNuevo!=null){
			int cod= Integer.parseInt(codigoNuevo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			codigoNuevo=((codigoNuevo.substring(0,3).concat(temp)));
			trasladoData.setIdmembresianuevo(codigoNuevo);
			}
			//else trasladoData.setIdMembresiaNuevo("MEM000020");

			String codigo=trasladoData.getIdmembresiantiguo();
			//trasladoData.setIdmembresianuevo(codigoNuevo);
			
			//membresiaData.setIdMembresia(idMembresia);
			membresiaData.setIdMembresia(codigoNuevo);
			membresiaData.setEstado("Activo");
			membresiaData.setCosto(trasladoData.getMonto());
			//membresiaData.setFechaInicio(trasladoData.getFecha());
			membresiaData.setCodigoSocio(trasladoData.getCodigo());
			membresiaData.setFechaInicio(trasladoData.getFecha());
			membresiaData.setFechafin(trasladoData.getFechafin());
			
			sqlsesion.insert("Data.venta.traslado.insertNuevaMembresia",membresiaData);
			sqlsesion.update("Data.venta.traslado.updateCodigo", codigo);
			sqlsesion.insert("Data.venta.traslado.insertTraslado",trasladoData);

			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de traslado repetido", "SMVPromocion?accion=Agregar&tipo=1");
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	//public TrasladoBeanData consultarTraslado(String codigo){
		//TrasladoBeanData TrasladoData=null;
		//SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		//try{
			//TrasladoData= sqlsesion.selectOne("Data.venta.traslado.getPlantillaMembresia",codigo);
		//}
		//finally{
			//sqlsesion.close();
		//}
		//return TrasladoData;
	//}

	
	
	
	
	
}			  
