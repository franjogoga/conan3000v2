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
import IngSoft.venta.bean.OrdenPagoBeanFunction;

public class ActividadBeanFuncion {
	
	
	
	private Lock l= new ReentrantLock();
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
    
	static private ActividadBeanFuncion actividadFuncion=null;
    
    public static ActividadBeanFuncion getInstance(){
        if(actividadFuncion==null) actividadFuncion= new ActividadBeanFuncion();
        
        return actividadFuncion;
    }
    
	
    
	
	private ActividadBeanFuncion(){
		
		
	}
	
	
	public ActividadBeanData crearActividad(HttpServletRequest request, HttpServletResponse response){
		ActividadBeanData actividadData= new ActividadBeanData();
		try{
			
            
			
            
            
            
            
            actividadData.setNombreSede(		request.getParameter("cmbSede"));
            actividadData.setNombre(    		request.getParameter("txtNombre") );
            
            actividadData.setNombreTipoactividad(	request.getParameter("cmbTipoactividad"));
            
            actividadData.setVacantes( Integer.parseInt( request.getParameter("txtVacantes"))  );
            actividadData.setInscritos(  0  );
            actividadData.setCosto( Double.parseDouble( request.getParameter("txtCosto")) );
            
            
            actividadData.setNombreEncargado(		request.getParameter("cmbEncargadoCodigo"));
            //actividadData.setNombreEncargado(		request.getParameter("cmbEncargado"));
            actividadData.setPuesto(				request.getParameter("txtPuesto"));
            actividadData.setNombreAmbientes(		request.getParameter("cmbAmbiente"));
            
            actividadData.setFechaInicio(new Date(DF.parse(		request.getParameter("fFecIncio")+"/0000").getTime()));
            actividadData.setFechaFin(new Date(DF.parse(		request.getParameter("fFecFin")+"/0000").getTime()));
            actividadData.setDia(   						 	request.getParameter("txtDia") );
            actividadData.setDescripcion(    					request.getParameter("txtDescripcion") );
            actividadData.setEstado(    						request.getParameter("optionsRadios") );
            
            
            
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return actividadData;
	}
	
	
	public MatriculaBeanData crearMatriculaActividad(String codigoActividad,String codigosocio,String codigofamiliar, String horario , String monto ,String vacantes){
		MatriculaBeanData matriculaData= new MatriculaBeanData();
		
		
		try{
			

            
            
            
			matriculaData.setCodigoActividad(	codigoActividad	);
			

			matriculaData.setCodigosocio(    codigosocio		);

			
			//matriculaData.setCodigofamiliar(	''	);
			matriculaData.setHorario(    	horario	 );
			matriculaData.setMonto(    Double.parseDouble(   	monto)	 );
			
			matriculaData.setVacantes(vacantes);
			
			
            
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return matriculaData;
	}
	
	
	
	
	
	
	
	public ActividadBeanData crearActividadModificada(HttpServletRequest request, HttpServletResponse response){
		ActividadBeanData actividadData= new ActividadBeanData();
		try{
			
			
            
	        
            System.out.print("---> nombre que vamos a modificar" + request.getParameter("txtNombre"));
            
            actividadData.setCodigo(            request.getParameter("codigo"));
            actividadData.setNombreSede(		request.getParameter("cmbSede"));
            actividadData.setNombre(    		request.getParameter("txtNombre") );
            
            actividadData.setNombreTipoactividad(	request.getParameter("cmbTipoactividad"));
            
            actividadData.setVacantes( Integer.parseInt( request.getParameter("txtVacantes"))  );
            //actividadData.setInscritos(  0  );
            actividadData.setCosto( Double.parseDouble( request.getParameter("txtCosto")) );
            
            
            actividadData.setNombreEncargado(		request.getParameter("cmbEncargadoCodigo"));
            //actividadData.setNombreEncargado(		request.getParameter("cmbEncargado"));
            actividadData.setPuesto(				request.getParameter("txtPuesto"));
            actividadData.setNombreAmbientes(		request.getParameter("cmbAmbiente"));
            
            actividadData.setFechaInicio(new Date(DF.parse(		request.getParameter("fFecIncio")+"/0000").getTime()));
            actividadData.setFechaFin(new Date(DF.parse(		request.getParameter("fFecFin")+"/0000").getTime()));
            actividadData.setDia(   						 	request.getParameter("txtDia") );
            actividadData.setDescripcion(    					request.getParameter("txtDescripcion") );
            actividadData.setEstado(    						request.getParameter("optionsRadios") );
            
			
            
            
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return actividadData;
	}
	
	
	
	
	
	
	public boolean agregarActividad(ActividadBeanData actividadData) throws CoException {
		boolean resultado=false;
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			
			// conesta sentencia podemos tener el codigo
			String codigo = (String)sqlsesion.selectOne("Data.administracion.actividad.getNextCodigo");
            
			System.out.print(" actividadData ----> "+ codigo);
			
			
			if(codigo!=null)
			{
                int cod= Integer.parseInt(codigo.substring(3))+1;
                String defecto= "000000";
                String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
                
                actividadData.setCodigo(codigo.substring(0,3).concat(temp));
			}
			else actividadData.setCodigo("ATC000001");
			
			
			System.out.print(" actividadData " + actividadData.getNombre());
			
            
			
			sqlsesion.insert("Data.administracion.actividad.insertPlantillaActividad",actividadData);
            
			
			resultado=true;
		}
		catch(Exception a)
		{sqlsesion.rollback();
            a.printStackTrace();
			throw CoException.set("Error en ingreso de datos: No se puede agregar la actividad ", "SMAActividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();
		}
        
		return resultado;
	}
	
	public boolean agregarMatriculaActividad(MatriculaBeanData matriculaBeanData) throws CoException {
		boolean resultado=false;
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			

            System.out.print("-----> agregar matriculaBeanData "+ matriculaBeanData.getHorario());
            
            
            
          String  numero= sqlsesion.selectOne("Data.administracion.actividad.getNumeroInscritosHorariodeactividadone",matriculaBeanData);
            
          System.out.print("-----> agregar matriculaBeanData "+ numero);
          
          if( Integer.parseInt(numero) >= Integer.parseInt(matriculaBeanData.getVacantes()) )
        	  throw CoException.set("Error en ingreso de datos: No se puede agregar la Matricula por falta de vacantes", "SMAActividad?accion=Agregar&tipo=1");
          else
          {	sqlsesion.insert("Data.administracion.actividad.insertPlantillaMatriculaActividad", matriculaBeanData);
          
             OrdenPagoBeanFunction orden=OrdenPagoBeanFunction.getInstance();
             
             orden.agregarOrdenPago(
            		 "ACTIVIDADSOCIO",
            		 matriculaBeanData.getCodigoActividad(),
            		 "",
            		 matriculaBeanData.getCodigosocio(), 
            		 matriculaBeanData.getMonto(),
            		 new java.sql.Date(new java.util.Date().getTime()),
            		 new java.sql.Date(new java.util.Date().getTime()));
          
          }
            
			
			resultado=true;
		}
		catch(Exception a)
		{sqlsesion.rollback();
            a.printStackTrace();
			throw CoException.set(" No se pudo agregar la Matricula por los siguientes motivos: No hay vacantes , se encuentra inscrito en alguno de los horarios de la misma actividad  ", "SMAActividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();
		}
        
		return resultado;
	}
	 
	
	public boolean modificarActividad(ActividadBeanData actividadData) throws CoException {
		boolean resultado=false;
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
            
			
			sqlsesion.insert("Data.administracion.actividad.modificarPlantillaActividad",actividadData);
            
			
			resultado=true;
		}
		catch(Exception a)
		{sqlsesion.rollback();
            a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar la actividad ", "SMAActividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();
		}
        
		return resultado;
	}
	
	
	
	
	
	
	
	public ActividadBeanData consultarActividad(String codigo){
		ActividadBeanData actividadData=null;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			actividadData= sqlsesion.selectOne("Data.administracion.actividad.getPLantillaActividad",codigo);
		}
		finally{
			sqlsesion.close();
		}
		return actividadData;
	}
	
	public Vector<ResultadoHorariodeactividadBeanData> buscarPlantillaHorariosActividad(String codigo){
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		Vector<ResultadoHorariodeactividadBeanData> resultadosV=null;
		try{
			List<ResultadoHorariodeactividadBeanData> resultados=sqlsesion.selectList("Data.administracion.actividad.getHorariosActividad",codigo);
			resultadosV= new Vector<>(resultados);
		}
		finally{
            sqlsesion.close();}
		return resultadosV;
		
	}
	
    
	
	public boolean eliminarActividad(String codigo) throws CoException {
		boolean resultado=false;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
            
			sqlsesion.update("Data.administracion.actividad.deletePLantillaActividad",codigo);
			
			resultado=true;
		}
		catch(Exception a)
		{sqlsesion.rollback();
            a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la Actividad intente de nuevo", "SMAActividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
		}
        
		return resultado;
	}
	
	/*   --------------------------------- funciones de apoyo a los combobox -------------------------------   */
    
	
	public Vector<TipoActividadMiniBeanData> getTipoactividades() throws CoException {
		Vector<TipoActividadMiniBeanData> acts= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		
		try{
			List<TipoActividadMiniBeanData> temp=sqlsesion.selectList("Data.administracion.actividad.getTipoactividad");
			acts= new Vector<TipoActividadMiniBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de departamentos", "SMAActividad?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return acts;
	}
	
	public Vector<SedeBeanData> getSedes() throws CoException {
		Vector<SedeBeanData> sedes= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		
		try{
			List<SedeBeanData> temp=sqlsesion.selectList("Data.administracion.actividad.getSede");
			sedes= new Vector<SedeBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de departamentos", "SMAActividad?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return sedes;
	}
	
	public Vector<AmbienteBeanData> getAmbientes() throws CoException {
		Vector<AmbienteBeanData> ambientes= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		
		try{
			List<AmbienteBeanData> temp=sqlsesion.selectList("Data.administracion.actividad.getAmbiente");
			ambientes= new Vector<AmbienteBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de departamentos", "SMAActividad?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return ambientes;
	}
	
	
	public Vector<ResultadoEmpleadoBeanData> getEmpleados() throws CoException {
		Vector<ResultadoEmpleadoBeanData> empleados= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		
		try{
			List<ResultadoEmpleadoBeanData> temp=sqlsesion.selectList("Data.administracion.actividad.getEmpleado");			
			empleados= new Vector<ResultadoEmpleadoBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de departamentos", "SMAActividad?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return empleados;
	}
	
	
	
	
	
	
	public Vector<MatriculaBeanData> getMatriculadosActividad( String codigoActividad ,String horario) throws CoException {
		Vector<MatriculaBeanData> matriculados= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		MatriculaBeanData matricula = new MatriculaBeanData();
		
		matricula.setCodigoActividad(codigoActividad);
		matricula.setHorario(horario);
		
		
		
		try{
			List<MatriculaBeanData> temp=sqlsesion.selectList("Data.administracion.actividad.getMatriculadosactividad",matricula);			
			matriculados= new Vector<MatriculaBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de departamentos", "SMAActividad?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return matriculados;
	}
	
	
	
	public boolean eliminarMatriculaActividad(String codigoAct,String codigoSoc, String codigoFam ,String horario) throws CoException {
		boolean resultado=false;
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
			
			
			 System.out.print("codigoAct --> "+codigoAct   );
			 System.out.print("codigoSoc --> "+codigoSoc   );
			 System.out.print("codigoFam --> "+codigoFam   );
			 System.out.print("horario 	 --> "+horario   );
			
			
			MatriculaBeanData matricula = new MatriculaBeanData();
			
			matricula.setCodigoActividad(codigoAct);
			matricula.setCodigosocio(codigoSoc);
			matricula.setCodigofamiliar(codigoFam);
			matricula.setHorario(horario);
			
        
			sqlsesion.delete("Data.administracion.actividad.deletePLantillaMatriculaActividadSocio",matricula);

			
			resultado=true;
		}
		catch(Exception a)
		{sqlsesion.rollback();
            a.printStackTrace();
			throw CoException.set("Error: No se pudo eliminar la Actividad intente de nuevo", "SMAActividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
		}
        
		return resultado;
	}
	
	
	
	public Vector<ResultadoActividadBeanData> getNumeroInscritos() throws CoException {
		Vector<ResultadoActividadBeanData> acts= null;
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		
		try{
			List<ResultadoActividadBeanData> temp=sqlsesion.selectList("Data.administracion.actividad.getNumeroInscritosHorariodeactividad");
			acts= new Vector<ResultadoActividadBeanData>(temp);
		}
		catch(Exception e){
			e.printStackTrace();
			throw CoException.set("Error: No se pudo obtener la lista de inscritos", "SMAActividad?accion=Agregar&tipo=1");
		}
		finally{
			sqlsesion.close();
			
		}
		return acts;
	}
	
	
    
}
