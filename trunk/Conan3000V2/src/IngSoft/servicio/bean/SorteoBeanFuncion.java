package IngSoft.servicio.bean;

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

public class SorteoBeanFuncion {
	static private SorteoBeanFuncion SorteoFuncion=null;
	private Lock l= new ReentrantLock();     
	SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");
	public static SorteoBeanFuncion getInstance(){
		if(SorteoFuncion==null) SorteoFuncion= new SorteoBeanFuncion();
		return SorteoFuncion;
		}
	public SorteoBeanData crearSorteo(HttpServletRequest request, HttpServletResponse response){
		SorteoBeanData sorteoData= new SorteoBeanData();
		try{
			sorteoData.setIdSede(request.getParameterValues("cmbSedes"));
			sorteoData.setFechaInicio(new Date(DF.parse(request.getParameter("fFecIncio")+"/0000").getTime()));
			sorteoData.setFechaFin(new Date(DF.parse(request.getParameter("fFecIncio")+"/0000").getTime()));
			sorteoData.setFechaSorteo(new Date(DF.parse(request.getParameter("fFecIncio")+"/0000").getTime()));
			sorteoData.setDesc(request.getParameter("txtDescSorteo"));
			sorteoData.setEstado(request.getParameter("txtCodigoSorteo"));
			}catch(Exception e){
				e.printStackTrace();		
			}
			return sorteoData;		
		} 
		
		public boolean agregarSorteo(SorteoBeanData sorteoData) throws CoException {
			boolean resultado=false;		
			l.lock();
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
				sorteoData.setCodigo(Integer.parseInt((String)sqlsesion.selectOne("getNextCodigo")));
				sqlsesion.insert("insertPlantillaSorteo",sorteoData);
				sqlsesion.insert("insertPlantillaSorteoSedes",sorteoData);
				
				resultado=true;
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
				throw CoException.set("Error: Nombre de sorteo repetido", "SMSSorteo?accion=Agregar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();
				l.unlock();					
			}
				
			return resultado;
		}
		
		public boolean eliminarSorteo(int codigo) throws CoException {
			boolean resultado=false;		
			
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			try{
			
				sqlsesion.update("deletePLantillaSorteo",codigo);
				
				resultado=true;
			}
			catch(Exception a)		
			{sqlsesion.rollback();
			a.printStackTrace();
				throw CoException.set("Error: No se pudo eliminar la plantilla intente de nuevo", "SMSEvento?accion=Agregar&tipo=1");
				
			}
			
			finally{
				sqlsesion.commit();
				sqlsesion.close();					
			}
				
			return resultado;
		}
		public Vector<SedeMiniBeanData> getSedes(){
			SqlSession sqlsesion=MyBatisSesion.metodo().openSession();
			List<SedeMiniBeanData> resultados=sqlsesion.selectList("searchSedeMini2");
			sqlsesion.close();
			return new Vector<>(resultados);
		}
		

}
