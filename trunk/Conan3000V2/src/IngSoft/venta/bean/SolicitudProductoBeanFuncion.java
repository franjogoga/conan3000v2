package IngSoft.venta.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.administracion.bean.SedeMiniBeanData;
import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
@ApplicationScoped
public class SolicitudProductoBeanFuncion {

	static private SolicitudProductoBeanFuncion SolicitudProductoFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static SolicitudProductoBeanFuncion getInstance(){
	       if(SolicitudProductoFuncion==null) SolicitudProductoFuncion= new SolicitudProductoBeanFuncion();
	       
	       return SolicitudProductoFuncion;
	   }
	   
	   private SolicitudProductoBeanFuncion() {}
	
	   public SolicitudProductoBeanData crearSolProducto(HttpServletRequest request, HttpServletResponse response){
		   SolicitudProductoBeanData solproductoData= new SolicitudProductoBeanData();
			try{		
		
				solproductoData.setIdSede(request.getParameter("cmbSede"));
				solproductoData.setIdEmpleado(request.getParameter("idEmpleado"));
				solproductoData.setIdProducto(request.getParameter("idProducto"));			
				solproductoData.setCantidad(Integer.parseInt(request.getParameter("txtCantidad")));
				solproductoData.setFecha(new Date(DF.parse(request.getParameter("fFecha")).getTime()));
				
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
			return solproductoData;		
		} 
	public boolean agregarSolicitudProducto(SolicitudProductoBeanData productoData) throws CoException {
		
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.solicitudproducto.getNextCodigoS");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			productoData.setIdSolicitudProducto(codigo.substring(0,3).concat(temp));}
			else productoData.setIdSolicitudProducto("SPR00001");

			sqlsesion.insert("insertSolicitudProducto",productoData);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	public boolean eliminarSolicitudProducto(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.venta.solicitudproducto.deleteSolicitudProducto",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la solicitud, intente de nuevo", "SMVSolicitudProducto?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
			
	public SolicitudProductoBeanData consultarSolicitudProducto(String codigo){
		SolicitudProductoBeanData productoData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			productoData= sqlsesion.selectOne("Data.venta.solicitudproducto.getPlantillaSolicitudProducto",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return productoData;
	}
	
public String consultarSolicitudProductoMax() throws CoException {
		
		//boolean resultado=false;		
		//l.lock();
	String codigo=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			codigo= (String)sqlsesion.selectOne("Data.venta.solicitudproducto.getNextCodigoS");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			
			codigo=(codigo.substring(0,3).concat(temp));}
			//else membresiaData.setCodigo("MEM000001");
			//insertMembresia esta en membresia mapper
			//sqlsesion.insert("insertMembresia",membresiaData);
			//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
			
			//resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de membresia repetido", "SMVMembresia?accion=Agregar&tipo=1");
		}
		
		finally{
			//sqlsesion.commit();
			sqlsesion.close();
			//l.unlock();					
		}
		return codigo;
	}

public Vector<SedeMiniBeanData> getSedes(){
	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
	List<SedeMiniBeanData> resultados=sqlsesion.selectList("Data.venta.solicitudproducto.searchSedeMini");
	sqlsesion.close();
	return new Vector<>(resultados);
}


}