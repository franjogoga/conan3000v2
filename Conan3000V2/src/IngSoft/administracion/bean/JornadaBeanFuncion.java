package IngSoft.administracion.bean;

import java.util.Date;
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

public class JornadaBeanFuncion {
	static private JornadaBeanFuncion JornadaFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public static JornadaBeanFuncion getInstance(){
		if(JornadaFuncion==null) JornadaFuncion= new JornadaBeanFuncion();
		return JornadaFuncion;
		}
	
	//-------------------- nuevo --------------------
	
	public boolean actualizarFlagEmpleado(String codigo) throws CoException {
		boolean resultado=false;		
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		try{
		
			sqlsesion.update("updateFlagEmpleadoJornada",codigo);
			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo encontro usaurio en la plantilla intente de nuevo", "SMAJornada?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();					
		}
			
		return resultado;
	}
			
	//-------------------- fin nuevo --------------------
	
	public JornadaBeanData crearJornada(HttpServletRequest request, HttpServletResponse response){
		JornadaBeanData jornadaData= new JornadaBeanData();
		try{
			jornadaData.setIdEmpleado(request.getParameter("txtNombreJornada"));
			jornadaData.setHoraInicio(request.getParameter("cmbHorarios"));
			jornadaData.setFecha(new Date(DF.parse(request.getParameter("fFechaJornada")).getTime()));
			jornadaData.setHoraMarca(request.getParameter("reloj"));
			
			
			
			
			
			
		}catch(Exception e){
				e.printStackTrace();		
			}
			return jornadaData;		
		} 
	
	
	
	 	public Vector<HorarioEmpleados> getHorarios(){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<HorarioEmpleados> resultados=sqlsesion.selectList("Data.administracion.empleado.searchHorarios");
			sqlsesion.close();
			return new Vector<>(resultados);
		}
	 	
	 	
	 	
	 	
		public boolean agregarJornada(JornadaBeanData jornadaData , String codigoEmpleado) throws CoException {
			boolean resultado=false;		
			l.lock();
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			
			
			
			try{
				
				
				String codigo= (String)sqlsesion.selectOne("Data.administracion.jornada.getNextCodigo");
				
				System.out.print("paso I codigo "+codigo +" codigoEmpleado " +codigoEmpleado);
				
				String    flagEmpleado  = (String)sqlsesion.selectOne("Data.administracion.jornada.getFlagEmpleado",codigoEmpleado);
				
				System.out.print("paso II codigo "+codigo +" flagEmpleado " +flagEmpleado);
				
				
				if(codigo!=null){
				int cod= Integer.parseInt(codigo.substring(3))+1;
				String defecto= "000000";
				String temp= defecto.substring(0, defecto.length()-String.valueOf(cod).length()).concat(String.valueOf(cod));
				
				jornadaData.setIdJornada(codigo.substring(0,3).concat(temp));}
				else jornadaData.setIdJornada("JOR000001");
				
				jornadaData.setFlag( Integer.parseInt(flagEmpleado) );
				
				sqlsesion.insert("insertPlantillaJornada",jornadaData);
				resultado=true;
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
			
			
				throw CoException.set("Error: No se encontro usuario", "SMAJornada?accion=Agregar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();
				l.unlock();					
			}
				
			return resultado;
		}
		
		
		
		public boolean eliminarJornada(String codigo) throws CoException {
			boolean resultado=false;		
			
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
			
				sqlsesion.update("update2PLantillaJornada",codigo);
				
				resultado=true;
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
				throw CoException.set("Error: No se pudo eliminar la plantilla intente de nuevo", "SMAJornada?accion=Agregar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();					
			}
				
			return resultado;
		}
		
		
		
		
		public JornadaBeanData consultarSorteo(String codigo){
			JornadaBeanData jornadaData=null;
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
				jornadaData= sqlsesion.selectOne("Data.administracion.jornada.getPLantillaJornada",codigo);
			}
			finally{
				sqlsesion.close();
			}
			return jornadaData;
		}
		
		


		
		public void modificarJornada(JornadaBeanData jornada,String antSede) throws CoException {
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
				/*Vector<ModificacionesSorteoBeanData> mods;
				mods= this.generaListaCambios(antSede, sorteo.getIdSede(),sorteo.getIdSorteo());
				for(int i=0;i<mods.size();i++){
					if("I".equals(mods.get(i).getCambio())) sqlsesion.insert("Data.servicio.sorteo.insertPlantillaSorteoSedesUpdate",(ModificacionesSorteoBeanData)mods.get(i));
					if("U".equals(mods.get(i).getCambio())) sqlsesion.update("Data.servicio.sorteo.updatePlantillaSorteoSedes",(ModificacionesSorteoBeanData)mods.get(i));	
					if("D".equals(mods.get(i).getCambio())) sqlsesion.delete("Data.servicio.sorteo.deletePlantillaSorteoSede",(ModificacionesSorteoBeanData)mods.get(i));	
				}	*/	

				sqlsesion.update("Data.administracion.jornada.updatePlantillaJornada",jornada);
				
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
				throw CoException.set("Error: No se pudo modificar la plantilla intente de nuevo", "SMAJornada?accion=Modificar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();					
			}
				
			return ;
		}
		
		
		
		

}
