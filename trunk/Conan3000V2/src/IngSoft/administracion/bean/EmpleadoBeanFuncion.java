package IngSoft.administracion.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import IngSoft.general.CoException;
import IngSoft.general.MyBatisSesion;
import IngSoft.servicio.bean.PersonaJuridicaBeanData;
import IngSoft.servicio.bean.SedeMiniBeanData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmpleadoBeanFuncion {	
	
	static private EmpleadoBeanFuncion EmpleadoFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	   
	   public static EmpleadoBeanFuncion getInstance(){
	       if(EmpleadoFuncion==null) EmpleadoFuncion= new EmpleadoBeanFuncion();
	       
	       return EmpleadoFuncion;
	   }
	   
	   
	   public Vector<HorarioEmpleados> getHorarios(){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<HorarioEmpleados> resultados=sqlsesion.selectList("Data.administracion.empleado.searchHorarios");
			sqlsesion.close();
			return new Vector<>(resultados);
		}
	   
	   public Vector<HashMap<String, Object>> getPerfiles(){
		   	SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		   	List<HashMap<String, Object>>resultados=sqlsesion.selectList("Data.administracion.empleado.getPerfiles");
			sqlsesion.close();
			return new Vector<>(resultados);		   
	   }
  
	   
	   private EmpleadoBeanFuncion() {}
	
	public EmpleadoBeanData crearEmpleado(HttpServletRequest request, HttpServletResponse response){
		EmpleadoBeanData empleadoData= new EmpleadoBeanData();
		
		HorariosEmpleado horariosData = new HorariosEmpleado();
		SedesEmpleado sedesData = new SedesEmpleado();
		
		//AregloEmpleados
		
		
		
		try{		
	
			
			
		empleadoData.setNombre(request.getParameter("txtNombreEmpleado"));
		empleadoData.setApellidoPaterno(request.getParameter("txtApellidoPaterno"));
		empleadoData.setApellidoMaterno(request.getParameter("txtApellidoMaterno"));
		empleadoData.setFechaNacimiento(new Date(DF.parse(request.getParameter("txtFechaNacimiento")).getTime()));
		empleadoData.setFechaContrato(new Date(DF.parse(request.getParameter("txtFechaContrato")).getTime()));
		empleadoData.setArea(request.getParameter("cmbArea"));	
		empleadoData.setPuesto(request.getParameter("cmbPuesto"));
		empleadoData.setEstado("activo");
		empleadoData.setTipoDocumento(request.getParameter("cmbTipoDocumento"));
		//String numDoc=request.getParameter("txtNumeroDocumento");
		empleadoData.setNumeroDocumento(Integer.parseInt(request.getParameter("txtNumeroDocumento")));
		empleadoData.setPerfil(request.getParameter("cmbPerfil"));
		
		//System.out.println(empleadoData.getNumeroDocumento());
	
		
		 horariosData.setIdHorarios((request.getParameter("cmbHorarios").split("/"))  );
		 sedesData.setIdSedes(request.getParameter("cmbSedes").split("/"));
		
 		 
		 for(int i=0; i< (horariosData.getIdHorarios()).length; i++){
			 
			 empleadoData.setIdHorario(horariosData.getIdHorarios()[i]);
			 
			 
		 }
		
		 for(int i=0; i< sedesData.getIdSedes().length; i++){
			 
		 
			 empleadoData.setIdSede(sedesData.getIdSedes()[i]);
		 }
		
		 
		 
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return empleadoData;		
	}
	
	
	
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public EmpleadoBeanData crearEmpleado2(HttpServletRequest request, HttpServletResponse response){
		
		EmpleadoBeanData empleadoData= new EmpleadoBeanData();
		
		//HorariosEmpleado horariosData = new HorariosEmpleado();
		//SedesEmpleado sedesData = new SedesEmpleado();
		
		//AregloEmpleados
		
		
		
		try{		
	
			
			
		empleadoData.setNombre(request.getParameter("txtNombreEmpleado"));
		empleadoData.setApellidoPaterno(request.getParameter("txtApellidoPaterno"));
		empleadoData.setNumeroDocumento(Integer.parseInt(request.getParameter("txtNumeroDocumento")));
		empleadoData.setArea(request.getParameter("cmbArea"));
		//empleadoData.setApellidoMaterno(request.getParameter("txtApellidoMaterno"));
		//empleadoData.setFechaNacimiento(new Date(DF.parse(request.getParameter("txtFechaFacimiento")).getTime()));
		//empleadoData.setFechaContrato(new Date(DF.parse(request.getParameter("txtFechaContrato")).getTime()));
			
		//empleadoData.setPuesto(request.getParameter("cmbPuesto"));
		//empleadoData.setEstado("activo");
		//empleadoData.setTipoDocumento(request.getParameter("cmbTipoDocumento"));
		//String numDoc=request.getParameter("txtNumeroDocumento");
		
		
	
		
//		 horariosData.setIdHorarios((request.getParameter("cmbHorarios").split("/"))  );
//		 sedesData.setIdSedes(request.getParameter("cmbSedes").split("/"));
//		
// 		 
//		 for(int i=0; i< (horariosData.getIdHorarios()).length; i++){
//			 
//			 empleadoData.setIdHorario(horariosData.getIdHorarios()[i]);
//			 
//			 
//		 }
//		
//		 for(int i=0; i< sedesData.getIdSedes().length; i++){
//			 
//		 
//		 	 empleadoData.setIdSede(sedesData.getIdSedes()[i]);
//		 }
//		
		 
		 
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return empleadoData;		
	}
	
	
	
	
	
	
	
	
	
	   public void modificarEmpleado(EmpleadoBeanData empleado) throws CoException {
			
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
				
				sqlsesion.update("Data.administracion.empleado.updatePlantillaEmpleado",empleado);
				sqlsesion.update("Data.administracion.empleado.updatePlantillaPersona",empleado);
				
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
				throw CoException.set("Error: No se pudo modificar el empleado intente de nuevo", "SMSEmpleado?accion=Modificar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();					
			}
				
			return ;
		}
	
	
	
	public boolean eliminarEmpleado(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("Data.administracion.empleado.deletePlantillaEmpleado",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la plantilla intente de nuevo", "SMSEmpleado?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
	
	
	
	
	public EmpleadoBeanData consultarEmpleado(String codigo){
		EmpleadoBeanData EmpleadoData=null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			EmpleadoData= sqlsesion.selectOne("Data.administracion.empleado.getPlantillaEmpleado",codigo);
		}
		finally{
			sqlsesion.close();
		}
		//BUSCA EMPLEADO EN OTRAS TABLAS
		sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<EmpleadoBeanData> resultadosV=null;
		try{		
			List<EmpleadoBeanData> resultados = sqlsesion.selectList("searchEmpleadoOtros",codigo);
			resultadosV= new Vector<>(resultados);
		}
		finally{
			sqlsesion.close();
		}
		//COMPROBAR EL TAMA�ANO PARA SETEAR EL FLAG
		if(resultadosV.size()==0){
			EmpleadoData.setFlag(0);
		}
		else {
			EmpleadoData.setFlag(1);
		}
		return EmpleadoData;
	}
	
	
	
	
	public boolean agregarEmpleado(EmpleadoBeanData empleadoData) throws CoException {
		boolean resultado=false;		
		l.lock();
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		int doc = empleadoData.getNumeroDocumento();
		System.out.println(Long.toString(doc));
		
		try{
			String codigo= (String)sqlsesion.selectOne("Data.administracion.empleado.getNextCodigo");
			
			if(codigo!=null){
			int cod= Integer.parseInt(codigo.substring(3))+1;
			String defecto= "000000";
			String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
			
			empleadoData.setCodigo(codigo.substring(0,3).concat(temp));}
			else {empleadoData.setCodigo("EMP000001"); empleadoData.setIdEmpleado("EMP000001"); }
			
			
			
			// Agrego un insert en Persona 
			
			sqlsesion.insert("Data.administracion.empleado.insertPlantillaEmpleado",empleadoData);
			
			sqlsesion.insert("Data.administracion.empleado.insertPlantillaPersona",empleadoData);
			
			HashMap<String, Object> map=new HashMap<>();
			map.put("perfil", empleadoData.getPerfil());
			String temp=String.valueOf(empleadoData.getNumeroDocumento());
			temp= temp.length()==8?"E000"+temp:"E"+temp;
			map.put("nombreusuario",temp);
			map.put("empleado", empleadoData.getCodigo());
			Vector<HashMap<String, Object>> perfiles=this. getPerfiles();
			for(int i=0;i<perfiles.size();i++){
				if(perfiles.get(i).get("idPerfil").equals(empleadoData.getPerfil())) {temp=(String)perfiles.get(i).get("Nombre");break;}
			}
			map.put("descripcion", temp);
			map.put("estado", "Activo");
			//Obtener codigo de usuario
			String codUsuario= (String)sqlsesion.selectOne("Data.venta.socio.getNextCodigoU");
			if(codUsuario!=null){
				int codU= Integer.parseInt(codUsuario.substring(3))+1;
				String defecto= "000000";
				String tempU= defecto.substring(0, defecto.length()-String.valueOf(codU).length()).concat(String.valueOf(codU));
			
			codUsuario=codUsuario.substring(0,3).concat(tempU);}
			else codUsuario="USU000001";
			map.put("usuario", codUsuario);
			String contrasenha=Integer.toString((int)(Math.random()*(999999-100000+1)+999999));
			map.put("password", contrasenha);
			
			
			
			sqlsesion.insert("Data.administracion.empleado.insertUsuarioEmpleado",map);
			
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: Nombre de Empleado repetido", "SMSEmpleado?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();					
		}
			
		return resultado;
	}
	
	
	
	public Vector<SedeMiniBeanData> getSedes(){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		List<SedeMiniBeanData> resultados=sqlsesion.selectList("Data.servicio.evento.searchSedeMini");
		sqlsesion.close();
		return new Vector<>(resultados);
	}
	
}
