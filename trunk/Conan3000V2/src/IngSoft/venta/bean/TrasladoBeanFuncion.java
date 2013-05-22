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
		try{			
		trasladoData.setIdMembresiaAntiguo(request.getParameter("txtIdMembresiaAntiguo"));
		trasladoData.setIdMembresiaNuevo(request.getParameter("txtIdMembresiaNuevo"));
		trasladoData.setIdnuevosocio(request.getParameter("txtIdNuevoSocio"));
		trasladoData.setFecha(new Date(DF.parse(request.getParameter("fFecha")).getTime()));
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
			String codigo= (String)sqlsesion.selectOne("Data.venta.traslado.getNextCodigoT");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			trasladoData.setIdtraslado((codigo.substring(0,3).concat(temp)));
			}
			else trasladoData.setIdtraslado("TRA000001");
			//insertPromocion esta en traslado mapper
			sqlsesion.insert("insertTraslado",trasladoData);
			//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
			
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

	
	
	
	
	
}			  
