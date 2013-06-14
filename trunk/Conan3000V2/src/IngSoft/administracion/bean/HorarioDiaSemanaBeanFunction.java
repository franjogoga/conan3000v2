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

public class HorarioDiaSemanaBeanFunction {
	

	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy"); 

	static private HorarioDiaSemanaBeanFunction horarioDiaSemanaBeanFunction=null;

	   public static HorarioDiaSemanaBeanFunction getInstance(){
	       if(horarioDiaSemanaBeanFunction==null) horarioDiaSemanaBeanFunction= new HorarioDiaSemanaBeanFunction();
	       
	       return horarioDiaSemanaBeanFunction;
	   }

	
	private HorarioDiaSemanaBeanFunction(){
		
		
	}
	
	
	public HorarioDiaSemanaBeanData crearHorarioDiaSemana(String codDia,String codHor,String horIn,String horFin  ){
		   HorarioDiaSemanaBeanData horarioDiaSemanaBeanData= new HorarioDiaSemanaBeanData();
		try{		

			
			horarioDiaSemanaBeanData.setCodigoDia(     codDia   );
			horarioDiaSemanaBeanData.setCodigoHorario( codHor   );
			horarioDiaSemanaBeanData.setHoraInicio(    horIn    );
			horarioDiaSemanaBeanData.setHoraFin(       horFin   ); 		

		}catch(Exception e){
			e.printStackTrace();
			
		}
		return horarioDiaSemanaBeanData;		
	}
	
	
	public boolean agregarHorarioDiaSemana(HorarioDiaSemanaBeanData horarioDiaSemanaBeanData) throws CoException {
		boolean resultado=false;		
		
		l.lock();
		
		SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
		
		try{
			sqlsesion.insert("Data.administracion.horariodetrabajo.insertPlantillaHorarioDiaSemana",horarioDiaSemanaBeanData);

			resultado=true;
		}
		catch(Exception a)		
		{sqlsesion.rollback();
		a.printStackTrace();
			throw CoException.set("Error en ingreso de datos: No se puede agregar la horariodetrabajo ", "SMAHorariodetrabajo?accion=Agregar&tipo=1");
			
		}
		
		finally{
			sqlsesion.commit();
			sqlsesion.close();
			l.unlock();				
		}
			
		return resultado;
	}
	
}
