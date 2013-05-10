package IngSoft.administracion.bean;

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
			
			System.out.print("  SedeBeanFuncion ---> crearSede  -->nombre == "+ request.getParameter("txtNombre"));
			
		sedeData.setNombre(    request.getParameter("txtNombre") );
		sedeData.setDireccion(    request.getParameter("txtDireccion") );
		sedeData.setTelefono(    Long.parseLong(request.getParameter("txtTelefono") )    );
		sedeData.setAreaterreno( Double.parseDouble(request.getParameter("txtAreaterreno")) );
		
		
		//sedeData.setDepartamento(    request.getParameter("cmbDepartamento") );
		//sedeData.setProvincia(    request.getParameter("cmbProvincia") );
		//sedeData.setDireccion(    request.getParameter("cmbDireccion") );
		
		//						            para combobox
		//sedeData.setDireccion( request.getParameterValues("cmbSedes")     );


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
	

	public SedeBeanData consultarEvento(String codigo){
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
	
	
	
	

}
