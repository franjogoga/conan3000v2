package IngSoft.administracion.bean;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class SedeBeanFuncion {
	
	
	
	private Lock l= new ReentrantLock();  

	static private SedeBeanFuncion sedeFuncion=null;

	   public static SedeBeanFuncion getInstance(){
	       if(sedeFuncion==null) sedeFuncion= new SedeBeanFuncion();
	       
	       return sedeFuncion;
	   }
	   
	

	
	private SedeBeanFuncion(){
		
		
	}
	
	
	public SedeBeanData crearSede(HttpServletRequest request, HttpServletResponse response){
		SedeBeanData sedeData= new SedeBeanData();
		try{		
			
			System.out.print("  SedeBeanFuncion ---> crearSede  -->nombre == "+ request.getParameter("cmbDistrito")  );
			
		sedeData.setNombre(    request.getParameter("txtNombre") );
		//sedeData.setDistrito(   request.getParameter("cmbDistrito") );
		
		sedeData.setCoddistrito(   request.getParameter("cmbDistrito")  );
		
		
		
		sedeData.setDireccion(    request.getParameter("txtDireccion") );
		sedeData.setTelefono(    Long.parseLong(request.getParameter("txtTelefono") )    );
		sedeData.setAreaterreno( Double.parseDouble(request.getParameter("txtAreaterreno")) );
		sedeData.setEstado(   request.getParameter("txtEstado") );
		
		
		sedeData.setDepartamento(    request.getParameter("cmbDepartamento") );
		sedeData.setProvincia(    request.getParameter("cmbProvincia") );
		sedeData.setDireccion(    request.getParameter("cmbDireccion") );
		
		//						            para combobox
		//sedeData.setDireccion( request.getParameterValues("cmbSedes")     );


		}catch(Exception e){
			e.printStackTrace();
			
		}
		return sedeData;		
	}
	
	public SedeBeanData crearSedeModificada(HttpServletRequest request, HttpServletResponse response){
		SedeBeanData sedeData= new SedeBeanData();
		try{		
			

		sedeData.setCodigo(        request.getParameter("codigo") );	
		sedeData.setNombre(        request.getParameter("txtNombre") );
		sedeData.setDireccion(     request.getParameter("txtDireccion") );
		
		sedeData.setCoddistrito(   request.getParameter("cmbDistrito")  );
		
		sedeData.setTelefono(      Long.parseLong(request.getParameter("txtTelefono") )    );
		sedeData.setAreaterreno(   Double.parseDouble(request.getParameter("txtAreaterreno")) );
		sedeData.setEstado(        request.getParameter("optionsRadios"));


		}catch(Exception e){
			e.printStackTrace();
			
		}
		return sedeData;		
	}
	
	
	
	
	
	
	public boolean agregarSede(SedeBeanData sedeData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			
			// conesta sentencia podemos tener el codigo
			String codigo = (String)sqlsesion.selectOne("Data.administracion.sede.getNextCodigo");
			
			System.out.print("  SedeBeanFuncion ---> "+ codigo );
			
			
			if(codigo!=null)
			{
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			sedeData.setCodigo(codigo.substring(0,3).concat(temp));
			}
			else sedeData.setCodigo("SED000001");
			
			
			System.out.print("  SedeBeanFuncion ---> sedeData--> "+ sedeData.getCodigo() );
			
			sqlsesion.insert("Data.administracion.sede.insertPlantillaSede",sedeData);

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nombre de Sede repetido", "SMASede?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	

	
	public boolean modificarSede(SedeBeanData sedeData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{

			
			sqlsesion.insert("Data.administracion.sede.modificarPlantillaSede",sedeData);

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nose pudo modificar la plantilla ", "SMASede?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	
	
	
	
	
	
	
	public SedeBeanData consultarSede(String codigo){
		SedeBeanData sedeData=null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			sedeData= sqlsesion.selectOne("Data.administracion.sede.getPLantillaSede",codigo);
		
			System.out.print(" SedeBeanFuncion <-- "+sedeData.getNombre());
			
			
			
		}
		finally{
			sqlsesion.close();
		}
		
		System.out.print(" SedeBeanFuncion <-- "+sedeData.getProvincia());
		
		return sedeData;
	}
	
	
	
	public boolean eliminarSede(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.administracion.sede.deletePLantillaSede",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la plantilla intente de nuevo", "SMASede?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	public Vector<DepartamentoBeanData> getDepartamentos() throws CoException {
		Vector<DepartamentoBeanData> deps= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			List<DepartamentoBeanData> temp=sqlsesion.selectList("Data.administracion.sede.getDepartamentos" );			
			deps= new Vector<DepartamentoBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de departamentos", "SMASede?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return deps;
	}
	
	public Vector<ProvinciaBeanData> getProvincias(String depCod) throws CoException {
		Vector<ProvinciaBeanData> provs= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			List<ProvinciaBeanData> temp=sqlsesion.selectList("Data.administracion.sede.getProvincias",depCod);			
			provs= new Vector<ProvinciaBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de provincias", "SMASede?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return provs;
	}
	
	public Vector<DistritoBeanData> getDistritos(String provCod) throws CoException {
		Vector<DistritoBeanData> dist= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			List<DistritoBeanData> temp=sqlsesion.selectList("Data.administracion.sede.getDistritos",provCod);			
			dist= new Vector<DistritoBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de provincias", "SMASede?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return dist;
	}

}
