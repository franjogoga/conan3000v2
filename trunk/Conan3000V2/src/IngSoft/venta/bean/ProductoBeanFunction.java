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

public class ProductoBeanFunction {
	
	static private ProductoBeanFunction ProductoFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static ProductoBeanFunction getInstance(){
	       if(ProductoFuncion==null) ProductoFuncion= new ProductoBeanFunction();
	       
	       return ProductoFuncion;
	   }
	   
	   private ProductoBeanFunction() {}
	
	public ProductoBeanData crearProducto(HttpServletRequest request, HttpServletResponse response){
		ProductoBeanData productoData= new ProductoBeanData();
		try{		
	
			productoData.setIdProveedor(request.getParameter("txtProveedor"));
			productoData.setDescripcion(request.getParameter("txtDescripcion"));
			productoData.setNombre(request.getParameter("txtNombre"));
			productoData.setPrecioU(Double.parseDouble(request.getParameter("txtPrecioU")));
			productoData.setPresentacion(request.getParameter("txtPresentacion"));
			
			if (request.getParameter("rButton")!=null){
				String estado;
				estado=request.getParameter("rButton");
				productoData.setEstado(estado);}
			
		//membresiaData.setCodigoSocio(request.getParameter("idSocio"));
		//embresiaData.setFechaInicio(new Date(DF.parse(request.getParameter("fFechaInicio")).getTime()));
		//membresiaData.setFechafin(new Date(DF.parse(request.getParameter("fFechaFin")).getTime()));
		//membresiaData.setCosto(Double.parseDouble(request.getParameter("txtCosto")));
		//membresiaData.setPeriodo(request.getParameter("cmbPeriodo"));
		//membresiaData.setEstado(request.getParameter("rButton"));
		
		//if (request.getParameter("rButton")!=null){
		//String est;
		//est=request.getParameter("rButton");
		//membresiaData.setEstado(est);}
		
		//if(request.getParameter("rButton").equals("option1")) {
		//membresiaData.setEstado(request.getParameter("option1"));}
          // else if (request.getParameter("rButton").equals("option2"))
            //	membresiaData.setEstado(request.getParameter("option2"));
         	
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return productoData;		
	} 
	
	public boolean agregarProducto(ProductoBeanData productoData) throws CoException {
		
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			String codigo= (String)sqlsesion.selectOne("Data.venta.producto.getNextCodigo6");
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			productoData.setIdProdProveedor(codigo.substring(0,3).concat(temp));}
			else productoData.setIdProdProveedor("PRO00001");
			//insertMembresia esta en membresia mapper
			sqlsesion.insert("insertProducto",productoData);
			//sqlsesion.insert("insertPlantillaEventoSedes",eventoData);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			//throw CoException.set("Error: Nombre de membresia repetido", "SMVMembresia?accion=Agregar&tipo=1");
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
		
			sqlsesion.update("Data.venta.prodcuto.deleteProducto",codigo);
			
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
	
	
			
	public ProductoBeanData consultarProducto(String codigo){
		ProductoBeanData productoData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			productoData= sqlsesion.selectOne("Data.venta.producto.getPlantillaProducto",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return productoData;
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
