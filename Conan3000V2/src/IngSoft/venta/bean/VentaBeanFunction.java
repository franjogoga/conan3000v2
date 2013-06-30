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

public class VentaBeanFunction {
	
	static private VentaBeanFunction VentaFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static VentaBeanFunction getInstance(){
	       if(VentaFuncion==null) VentaFuncion= new VentaBeanFunction();
	       
	       return VentaFuncion;
	   }
	   
	private VentaBeanFunction() {}
	
	public VentaBeanData crearVenta(HttpServletRequest request, HttpServletResponse response){
		
		VentaBeanData ventaData= new VentaBeanData();
		try{		
	
		
			//System.out.println(request.getParameter("txtCliente"));
			
			ventaData.setIdSocio(request.getParameter("txtCliente"));
			
			System.out.println(request.getParameter("txtCliente"));
			
			ventaData.setIdEmpleado(request.getParameter("txtVendedor"));
			//ventaData.setFechaVenta(request.getParameter("txtFechaVenta"));
			ventaData.setFechaVenta(new Date(DF.parse(request.getParameter("txtFechaVenta")).getTime()));
			
		
		
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return ventaData;		
	} 
	
	public boolean registrarVenta(VentaBeanData ventaData) throws CoException {
		
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.ventaproducto.getNextCodigo");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			ventaData.setIdVenta(codigo.substring(0,3).concat(temp));}
			else ventaData.setIdVenta("VEN00001");

			sqlsesion.insert("insertVenta",ventaData);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de Venta repetido", "SMVVentaProductos?accion=Agregar&tipo=1");
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
		return resultado;
	}
	
	public boolean eliminarProducto(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.venta.producto.deleteProducto",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar el producto, intente de nuevo", "SMVProducto?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
			
	public VentaBeanData consultarVenta(String codigo){
		VentaBeanData ventaData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			ventaData= sqlsesion.selectOne("Data.venta.ventaproducto.getPlantillaVenta",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return ventaData;
	}
	
public String consultarProductoMax() throws CoException {
		
		//boolean resultado=false;		
		//l.lock();
	String codigo=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			codigo= (String)sqlsesion.selectOne("Data.venta.producto.getNextCodigo6");
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


	public void modificarProducto(ProductoBeanData producto) throws CoException {
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
					
		//	System.out.println("Ambs="+mods.size());
			sqlsesion.update("Data.venta.producto.updateProducto",producto);
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar el producto, intente de nuevo", "SMVProducto?accion=Modificar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}			
		return ;
	}

}