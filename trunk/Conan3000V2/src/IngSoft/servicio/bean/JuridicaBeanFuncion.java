package IngSoft.servicio.bean;

import IngSoft.servicio.juridica.*;
import IngSoft.servicio.bean.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
			JuridicaData.setCodigo(request.getParameter("txtCodigo"));
			JuridicaData.setCorreo(request.getParameter("txtCorreo"));
			JuridicaData.setDireccion(request.getParameter("txtDireccion"));
			JuridicaData.setEstado(request.getParameter("txtCodigo"));
			JuridicaData.setRazonSocial(request.getParameter("txtCodigo"));
			JuridicaData.setRuc(Integer.parseInt(request.getParameter("txtRuc")));
			JuridicaData.setTelefono(Integer.parseInt(request.getParameter("txtCodigo")));
			
			
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
				String Id= (String)sqlsesion.selectOne("Data.servicio.sorteo.getNextCodigo");
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
