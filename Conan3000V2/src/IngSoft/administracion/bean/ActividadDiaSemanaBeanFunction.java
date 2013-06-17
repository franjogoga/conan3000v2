package IngSoft.administracion.bean;

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

public class ActividadDiaSemanaBeanFunction {
	

	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); 

	static private ActividadDiaSemanaBeanFunction actividadDiaSemanaBeanFunction=null;

	   public static ActividadDiaSemanaBeanFunction getInstance(){
	       if(actividadDiaSemanaBeanFunction==null) actividadDiaSemanaBeanFunction= new ActividadDiaSemanaBeanFunction();
	       
	       return actividadDiaSemanaBeanFunction;
	   }

	
	private ActividadDiaSemanaBeanFunction(){
		
		
	}
	
	
	public ActividadDiaSemanaBeanData crearHorarioDiaSemana(String codDia,String codAct,String horIn,String horFin  ){
		   ActividadDiaSemanaBeanData actividadDiaSemanaBeanData= new ActividadDiaSemanaBeanData();
		try{		

			
			actividadDiaSemanaBeanData.setCodigoDia(         codDia   );
			actividadDiaSemanaBeanData.setCodigoActividad(   codAct   );
			actividadDiaSemanaBeanData.setHoraInicio(        horIn    );
			actividadDiaSemanaBeanData.setHoraFin(           horFin   );
			//actividadDiaSemanaBeanData.setDuracion(           0.0  );
			actividadDiaSemanaBeanData.setEstado(           "Activo"   );

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return actividadDiaSemanaBeanData;		
	}
	
	
	public boolean agregarHorarioDiaSemana(ActividadDiaSemanaBeanData actividadDiaSemanaBeanData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			System.out.print("Agregar Horario dia Semana ");
			System.out.print("CODIGO DIA       -->"+actividadDiaSemanaBeanData.getCodigoDia());
		    System.out.print("Codigo Actividad --> "+actividadDiaSemanaBeanData.getCodigoActividad());
			System.out.print("Hora Inicio      -->"+actividadDiaSemanaBeanData.getHoraInicio());
			System.out.print("hora fin         --> "+ actividadDiaSemanaBeanData.getHoraInicio());
			System.out.print("duracionn        --> "+ actividadDiaSemanaBeanData.getDuracion());
			System.out.print("Estado           --> "+ actividadDiaSemanaBeanData.getEstado());
			
			
			
			sqlsesion.insert("Data.administracion.horariodeactividad.insertPlantillaActividadDiaSemana",actividadDiaSemanaBeanData);

			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error en ingreso de datos: No se puede agregar el horario de la actividad ", "SMAHorariodeactividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	
	
	public ActividadDiaSemanaBeanData crearHorarioDiaSemanaMoficado(String codDia,String codAct,String horIn,String horFin,String estadoDia  ){
		   ActividadDiaSemanaBeanData actividadDiaSemanaBeanData= new ActividadDiaSemanaBeanData();
		try{		

			
			System.out.print("Entra ------------------------------------------");
			System.out.print("crearHorarioDiaSemanaMoficado"); 
			System.out.print("Codigo Dia      -->"+ codDia);
			System.out.print("Codigo Actividad -->"+ codAct);
			System.out.print("Hora inicio     -->"+ horIn);
			System.out.print(" Hora Fin       -->"+ horFin);	
			System.out.print(" estado         -->"+ estadoDia);	
			
			
			actividadDiaSemanaBeanData.setCodigoDia(       codDia   	);
			actividadDiaSemanaBeanData.setCodigoActividad( codAct   	);
			actividadDiaSemanaBeanData.setHoraInicio(      horIn    	);
			actividadDiaSemanaBeanData.setHoraFin(         horFin   	);
			actividadDiaSemanaBeanData.setEstado(          estadoDia    ); 
			
			
			System.out.print("verificacion de seteo ------------------------------------------");
			System.out.print("crearHorarioDiaSemanaMoficado"); 
			
			System.out.print(actividadDiaSemanaBeanData.getCodigoDia()        +" --> ");
			System.out.print(actividadDiaSemanaBeanData.getCodigoActividad()  +" --> ");
			System.out.print(actividadDiaSemanaBeanData.getHoraInicio()       +" --> ");
			System.out.print(actividadDiaSemanaBeanData.getHoraFin()          +" --> "); 	
			System.out.print(actividadDiaSemanaBeanData.getEstado()           +" --> "); 

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return actividadDiaSemanaBeanData;		
	}
	
	public boolean modificarActividadDiaSemanaBeanData(ActividadDiaSemanaBeanData actividadDiaSemanaBeanData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			
			
			System.out.print("Entra ------------------------------------------");
			System.out.print("modificaractividadDiaSemanaBeanData"); 
			
			System.out.print(actividadDiaSemanaBeanData.getCodigoDia()       +" --> ");
			System.out.print(actividadDiaSemanaBeanData.getCodigoActividad() +" --> ");
			System.out.print(actividadDiaSemanaBeanData.getHoraInicio()      +" --> ");
			System.out.print(actividadDiaSemanaBeanData.getHoraFin()         +" --> "); 	
			System.out.print(actividadDiaSemanaBeanData.getEstado()          +" --> "); 
			
			
			// podemos verificar si existen los codigos
			String codigos = (String)sqlsesion.selectOne("Data.administracion.horariodeactividad.getVerificaciondeCodigosActividadxDia",actividadDiaSemanaBeanData);
			
			if(codigos!=null) //existen los codigos
			{
			
				
				sqlsesion.insert("Data.administracion.horariodeactividad.modificarPlantillaActividadDiaSemana",actividadDiaSemanaBeanData);
			}
			else {
				
				sqlsesion.insert("Data.administracion.horariodeactividad.insertPlantillaActividadDiaSemana",actividadDiaSemanaBeanData);
				
			};

			
			

			
			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error: No se pudo modificar las horas  por dia de la semana ", "SMAHorariodeactividad?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}

	
	
	
}
