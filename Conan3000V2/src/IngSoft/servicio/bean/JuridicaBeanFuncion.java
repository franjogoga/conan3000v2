package IngSoft.servicio.bean;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;

public class JuridicaBeanFuncion {
	
	static private JuridicaBeanFuncion JuridicaFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	
	public static JuridicaBeanFuncion getInstance(){ //Constructor Singleton Bean Function
		if(JuridicaFuncion==null) JuridicaFuncion= new JuridicaBeanFuncion();
		return JuridicaFuncion;
		}
	
	public PersonaJuridicaBeanData crearJuridica(HttpServletRequest request, HttpServletResponse response){
		PersonaJuridicaBeanData JuridicaData= new PersonaJuridicaBeanData(); 
		
		try{
			//JuridicaData.setCodigo(request.getParameter("txt"));
			JuridicaData.setCorreo(request.getParameter("txtCorreo"));
			JuridicaData.setDireccion(request.getParameter("txtDireccion"));
			//JuridicaData.setEstado(request.getParameter("txtEstado"));
			JuridicaData.setRazonSocial(request.getParameter("txtRazonSocial"));
			JuridicaData.setRuc(Long.parseLong(request.getParameter("txtRuc")));
			JuridicaData.setTelefono(Integer.parseInt(request.getParameter("txtTelefono")));
			
			//int ruc=JuridicaData.getRuc();
			//System.out.println(Integer.toString(ruc));
			
			
			
			//int ruc=JuridicaData.getRuc();
			//System.out.println(Integer.toString(ruc));
			
			//System.out.println(JuridicaData.getRuc());
			
			
			
		}catch(Exception e){
				e.printStackTrace();		
			}
			return JuridicaData;		
		} 
		
		public boolean agregarJuridica(PersonaJuridicaBeanData JuridicaData) throws CoException {
			boolean resultado=false;		
			l.lock();
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
				
				
				String Id= (String)sqlsesion.selectOne("Data.servicio.juridica.getNextCodigo");
				//int ruc=JuridicaData.getRuc();
				//System.out.println(Integer.toString(ruc));
				
				
				if(Id!=null){
				int cod= Integer.parseInt(Id.substring(3))+1;
				String defecto= "000000";
				String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
				
				JuridicaData.setCodigo(Id.substring(0,3).concat(temp));}
				else JuridicaData.setCodigo("PJO000001");
				sqlsesion.insert("insertPlantillaJuridica",JuridicaData);
				resultado=true;
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
				throw CoException.set("Error: Nombre de Juridica", "SMSJuridica?accion=Agregar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();
				l.unlock();					
			}
				
			return resultado;
		}
		
		
		public void modificarJuridica(PersonaJuridicaBeanData juridica) throws CoException {
			
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
				
				sqlsesion.update("Data.servicio.juridica.updatePlantillaJuridica",juridica);
				
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
				throw CoException.set("Error: No se pudo modificar la plantilla intente de nuevo", "SMSJuridica?accion=Modificar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();					
			}
				
			return ;
		}
		
				
		public boolean eliminarJuridica(String codigo) throws CoException {
			boolean resultado=false;		
			
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
			
				sqlsesion.update("Data.servicio.juridica.deletePLantillaJuridica",codigo);
				
				resultado=true;
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
				throw CoException.set("Error: No se pudo eliminar la plantilla intente de nuevo", "SMSJuridica?accion=Agregar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();					
			}
				
			return resultado;
		}
		
		
		
		
		
		public PersonaJuridicaBeanData consultarJuridica(String codigo){
			PersonaJuridicaBeanData JuridicaData=null;
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
				JuridicaData= sqlsesion.selectOne("Data.servicio.juridica.getPLantillaJuridica",codigo);
			}
			finally{
				sqlsesion.close();
			}
			return JuridicaData;
		}
		
		
		public Vector<PersonaJuridicaBeanData> BuscarJuridica(PersonaJuridicaBeanData JuridicaData) throws CoException {
		
		
			Vector<PersonaJuridicaBeanData> Res = null;
			//l.lock();
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			
			try{
				JuridicaData.setRazonSocial(JuridicaData.getRazonSocial()+ "%");
				//sqlsesion.selectList("Data.servicio.juridica.searchJuridica",JuridicaData);
				
				List<PersonaJuridicaBeanData> Temp =  sqlsesion.selectList("Data.servicio.juridica.searchJuridica",JuridicaData);
				Res = new Vector<>(Temp);
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
				throw CoException.set("Error: Nombre de Juridica", "SMSJuridica?accion=Agregar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();
				//l.unlock();					
			}
				
			return Res;
		}
		
		
		

}
