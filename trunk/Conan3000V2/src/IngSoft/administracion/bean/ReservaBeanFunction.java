package IngSoft.administracion.bean;

import java.sql.Date;
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

public class InvitadoBeanFunction {
	static private InvitadoBeanFunction invitadoFunction= null;
	
	
	
	
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); 
	
	
	public static InvitadoBeanFunction getInstance(){
		
		if (invitadoFunction==null)   
				{
			      invitadoFunction = new  InvitadoBeanFunction();
			     
				}
		
		return invitadoFunction;
	}
	
	
	private InvitadoBeanFunction(){
		
		
	}
	
	
	
	
	
	
	
	
	
	public InvitadoBeanData getInvitado(int codigo){
		
		InvitadoBeanData i= null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			i= sqlsesion.selectOne("getInvitado",codigo);
		
		}
		finally{
			sqlsesion.close();
		}
		return i;
	}

	public InvitadoBeanData crearInvitado(HttpServletRequest request, HttpServletResponse response){
		InvitadoBeanData invitadoData= new InvitadoBeanData();
		try{		
	        
  System.out.print("---> codigo que vamos a modificar" + request.getParameter("codigo"));
	
       
		invitadoData.setNombres(			request.getParameter("txtNombre"));		
		invitadoData.setAparterno(   		request.getParameter("txtApaterno") );

		invitadoData.setAmaterno( 			request.getParameter("txtAmaterno"));
		
		invitadoData.setTipodocumento( 							request.getParameter("cmbTipodoc"));
		
		invitadoData.setNumerodoc(								request.getParameter("txtNrodoc"));
		
		
		invitadoData.setFechanacimiento(new Date(DF.parse(		request.getParameter("fFecNacimiento")+"/0000").getTime()));
		invitadoData.setFecharegistro(new Date(DF.parse(		request.getParameter("fFecRegistro")+"/0000").getTime()));
		invitadoData.setCorreo(  						 		request.getParameter("txtCorreo") );
		invitadoData.setTelefonofijo( 							request.getParameter("txtTelefonofijo") );
		invitadoData.setTelefonomovil(   						request.getParameter("txtTelefonocelular") );
		invitadoData.setEstado(    								request.getParameter("optionsRadios") );
			
	

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return invitadoData;		
	}
	
	public InvitadoBeanData crearInvitadoModificada(HttpServletRequest request, HttpServletResponse response){
		InvitadoBeanData invitadoData= new InvitadoBeanData();
		try{		
			
			

	        
  System.out.print("---> codigo que vamos a modificar" + request.getParameter("codigo"));
	
        invitadoData.setCodigo(             request.getParameter("codigo"));	
		invitadoData.setNombres(			request.getParameter("txtNombre"));		
		invitadoData.setAparterno(   		request.getParameter("txtApaterno") );

		invitadoData.setAmaterno( 			request.getParameter("txtAmaterno"));
		
		invitadoData.setTipodocumento( 							request.getParameter("cmbTipodoc"));
		
		invitadoData.setNumerodoc(								request.getParameter("txtNrodoc"));
		
		
		invitadoData.setFechanacimiento(new Date(DF.parse(		request.getParameter("fFecNacimiento")+"/0000").getTime()));
		invitadoData.setFecharegistro(new Date(DF.parse(		request.getParameter("fFecRegistro")+"/0000").getTime()));
		invitadoData.setCorreo(  						 		request.getParameter("txtCorreo") );
		invitadoData.setTelefonofijo( 							request.getParameter("txtTelefonofijo") );
		invitadoData.setTelefonomovil(   						request.getParameter("txtTelefonocelular") );
		invitadoData.setEstado(    								request.getParameter("optionsRadios") );
			


		}catch(Exception e){
			e.printStackTrace();
			
		}
		return invitadoData;		
	}

	public boolean agregarInvitado(InvitadoBeanData invitadoData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			
			// conesta sentencia podemos tener el codigo
			String codigo = (String)sqlsesion.selectOne("Data.administracion.invitado.getNextCodigo");

			System.out.print(" invitadoData ----> "+ codigo);
			
			
			if(codigo!=null)
			{
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			invitadoData.setCodigo(codigo.substring(0,3).concat(temp));
			}
			else invitadoData.setCodigo("INV000001");
			
			
			System.out.print(" invitadoData " + invitadoData.getNombres());
			
		
			

			sqlsesion.insert("Data.administracion.invitado.insertPlantillaPersona",invitadoData);
			
			sqlsesion.insert("Data.administracion.invitado.insertPlantillaInvitado",invitadoData);

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nombre de Invitado repetido XD", "SMAInvitado=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	

	public boolean modificarInvitado(InvitadoBeanData invitadoData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{

			
			sqlsesion.insert("Data.administracion.invitado.modificarPlantillaInvitado",invitadoData);

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nose pudo modificar la plantilla ", "SMAInvitado?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	
	
	
	
	public InvitadoBeanData consultarInvitado(String codigo){
		InvitadoBeanData invitadoData=null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			System.out.print("InvitadoBeanFunction ---->  codigo = " + codigo);
			
			invitadoData= sqlsesion.selectOne("Data.administracion.invitado.getPLantillaInvitado",codigo);
			
		}
		finally{
			sqlsesion.close();
		}

		
		return invitadoData;
	}
	

	public boolean eliminarInvitado(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			System.out.print(" eliminar codigo  " +  codigo );
			
			
			sqlsesion.update("Data.administracion.invitado.deletePLantillaInvitado",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la plantilla Invitado intente de nuevo", "SMAInvitado?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
